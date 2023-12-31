package cu.edu.cujae.rentacarback.service.core;

import cu.edu.cujae.rentacarback.security.dto.LoginRequestDTO;
import cu.edu.cujae.rentacarback.security.dto.LoginResponseDTO;

public interface AuthService {
    LoginResponseDTO loginAttempt(LoginRequestDTO request);
}
