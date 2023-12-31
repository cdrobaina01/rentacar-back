package cu.edu.cujae.rentacarback.controller;

import cu.edu.cujae.rentacarback.security.UserPrincipal;
import cu.edu.cujae.rentacarback.security.dto.LoginRequestDTO;
import cu.edu.cujae.rentacarback.security.dto.LoginResponseDTO;
import cu.edu.cujae.rentacarback.security.jwt.JwtIssuer;
import cu.edu.cujae.rentacarback.service.core.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    public LoginResponseDTO login(@RequestBody LoginRequestDTO request) {
        return authService.loginAttempt(request);
    }
}
