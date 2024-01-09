package cu.edu.cujae.rentacarback.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import cu.edu.cujae.rentacarback.utils.CarSituation;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "car")
public class Car {
    @Id
    @Column(name = "plate")
    private String plate;

    @Column(name = "km")
    private Integer km;

    @Column(name = "color")
    private String color;

    @Column(name = "situation", nullable = false)
    private CarSituation carSituation;

    @ManyToOne
    private Model model;

    @OneToMany(mappedBy = "car")
    @JsonIgnore
    private List<Contract> contracts;
}
