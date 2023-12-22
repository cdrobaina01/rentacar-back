package cu.edu.cujae.rentacarback.repository;

import cu.edu.cujae.rentacarback.model.Brand;
import cu.edu.cujae.rentacarback.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends JpaRepository<Driver, String> {
}
