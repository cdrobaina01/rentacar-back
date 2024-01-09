package cu.edu.cujae.rentacarback.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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
    @NotNull
    private Car car;

    @Id
    @Column(name = "startdate")
    @NotNull
    private LocalDate startDate;

    @ManyToOne
    @JoinColumn(nullable = false, name = "passport", referencedColumnName = "passport")
    @NotNull
    private Tourist tourist;

    @Column(name = "enddate", nullable = false)
    @NotNull
    private LocalDate endDate;

    @Column(name = "startkm", nullable = false)
    private Integer startKm;

    @Column(name = "deliverydate")
    private LocalDate deliveryDate;

    @Column(name = "endkm")
    private Integer endKm;

    @ManyToOne
    @NotNull
    private Paymethod paymethod;

    @ManyToOne
    private Driver driver;

    @Column(name = "value")
    private Double value;
}
