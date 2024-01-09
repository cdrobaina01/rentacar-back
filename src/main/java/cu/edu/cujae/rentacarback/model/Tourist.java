package cu.edu.cujae.rentacarback.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import cu.edu.cujae.rentacarback.utils.TouristGender;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "tourist")
public class Tourist {
    @Id
    @Column(name = "passport")
    private String passport;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "age")
    private Integer age;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "gender", nullable = false)
    private TouristGender gender;

    @Column(name = "country", nullable = false)
    @Size(min = 3, max = 4)
    private String country;

    @OneToMany(mappedBy = "tourist")
    @JsonIgnore
    private List<Contract> contracts;
}
