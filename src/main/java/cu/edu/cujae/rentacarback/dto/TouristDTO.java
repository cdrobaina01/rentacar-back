package cu.edu.cujae.rentacarback.dto;

import cu.edu.cujae.rentacarback.model.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class TouristDTO {
    private String passport;
    private String name;
    private Integer age;
    private String phone;
    private String email;
    private GenderDTO gender;
    private CountryDTO country;
}
