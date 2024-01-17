package cu.edu.cujae.rentacarback.security.dto;

import cu.edu.cujae.rentacarback.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class LoginResponseDTO {
    private User user;
    private String token;
}
