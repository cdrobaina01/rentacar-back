package cu.edu.cujae.rentacarback.dto.save;

import cu.edu.cujae.rentacarback.dto.RoleDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserSaveDTO {
    private String username;
    private String email;
    private String name;
    private String password;
    private String roleName;
}
