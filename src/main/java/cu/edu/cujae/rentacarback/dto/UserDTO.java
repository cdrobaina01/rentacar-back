package cu.edu.cujae.rentacarback.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserDTO {
    private String username;
    private String email;
    private String name;
    private RoleDTO role;
}
