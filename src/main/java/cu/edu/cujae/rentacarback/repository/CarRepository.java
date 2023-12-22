package cu.edu.cujae.rentacarback.repository;

import cu.edu.cujae.rentacarback.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, String> {
}
