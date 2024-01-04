package cu.edu.cujae.rentacarback.repository;

import cu.edu.cujae.rentacarback.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Integer> {
    @Query("SELECT e FROM Brand e WHERE e.name = :name")
    Optional<Brand> findByName(@Param("name") String name);
}
