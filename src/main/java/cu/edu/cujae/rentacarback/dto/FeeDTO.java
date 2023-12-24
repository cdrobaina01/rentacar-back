package cu.edu.cujae.rentacarback.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class FeeDTO {
    private Integer id;
    private String name;
    private Double value;
}
