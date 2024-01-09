package cu.edu.cujae.rentacarback.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import cu.edu.cujae.rentacarback.utils.DriverCategory;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "driver")
public class Driver {
    @Id
    @Column(name = "dni")
    private String dni;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "category", nullable = false)
    private DriverCategory category;

    @OneToMany(mappedBy = "driver")
    @JsonIgnore
    private List<Contract> contracts;
}
