package cu.edu.cujae.rentacarback.dto.save;

import cu.edu.cujae.rentacarback.dto.CountryDTO;
import cu.edu.cujae.rentacarback.dto.GenderDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class TouristSaveDTO {
    private String passport;
    private String name;
    private Integer age;
    private String phone;
    private String email;
    private Integer genderId;
    private Integer countryId;
}
