package cu.edu.cujae.rentacarback.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ContractPK implements Serializable {
    private String car;
    private LocalDate startDate;
}

