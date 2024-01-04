package cu.edu.cujae.rentacarback.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "model")
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name",nullable = false, unique = true)
    @NotBlank
    private String name;

    @ManyToOne
    @NotNull
    private Brand brand;

    @OneToMany(mappedBy = "model")
    @JsonIgnore
    private List<Car> cars;
}
