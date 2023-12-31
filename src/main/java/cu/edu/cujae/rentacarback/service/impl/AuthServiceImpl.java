package cu.edu.cujae.rentacarback.service.impl;

import cu.edu.cujae.rentacarback.security.UserPrincipal;
import cu.edu.cujae.rentacarback.security.dto.LoginRequestDTO;
import cu.edu.cujae.rentacarback.security.dto.LoginResponseDTO;
import cu.edu.cujae.rentacarback.security.jwt.JwtIssuer;
import cu.edu.cujae.rentacarback.service.core.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final JwtIssuer issuer;
    private final AuthenticationManager authenticationManager;

    @Override
    public LoginResponseDTO loginAttempt(LoginRequestDTO request) {
        var authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        var principal = (UserPrincipal) authentication.getPrincipal();
        var roles = principal.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .toList();
        var token = issuer.issue(principal.getUsername(), principal.getEmail(), roles);
        return LoginResponseDTO.builder().token(token).build();
    }
}
