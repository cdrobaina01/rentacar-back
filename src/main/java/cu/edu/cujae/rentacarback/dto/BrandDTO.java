package cu.edu.cujae.rentacarback.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class BrandDTO {
    private Integer id;
    private String name;
}
