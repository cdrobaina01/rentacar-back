package cu.edu.cujae.rentacarback.model;

import jakarta.persistence.*;
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

    @ManyToOne
    private Gender gender;

    @ManyToOne
    private Country country;

    @OneToMany(mappedBy = "tourist")
    private List<Contract> contracts;
}
