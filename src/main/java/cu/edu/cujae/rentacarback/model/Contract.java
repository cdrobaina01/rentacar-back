package cu.edu.cujae.rentacarback.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "contract")
@IdClass(ContractPK.class)
public class Contract {
    @Id
    @ManyToOne
    @JoinColumn(name = "plate", referencedColumnName = "plate")
    private Car car;

    @Id
    @Column(name = "startdate")
    private LocalDate startDate;

    @ManyToOne
    @JoinColumn(nullable = false, name = "passport", referencedColumnName = "passport")
    private Tourist tourist;

    @Column(name = "enddate", nullable = false)
    private LocalDate endDate;

    @Column(name = "startkm", nullable = false)
    private Integer startKm;

    @Column(name = "deliverydate")
    private LocalDate deliveryDate;

    @Column(name = "endkm")
    private Integer endKm;

    @ManyToOne
    private Paymethod paymethod;

    @ManyToOne
    private Driver driver;

    @Column(name = "value")
    private Double value;
}
