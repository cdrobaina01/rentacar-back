package cu.edu.cujae.rentacarback.controller;

import cu.edu.cujae.rentacarback.security.dto.LoginRequestDTO;
import cu.edu.cujae.rentacarback.security.dto.LoginResponseDTO;
import cu.edu.cujae.rentacarback.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
