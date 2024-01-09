package cu.edu.cujae.rentacarback.repository;

import cu.edu.cujae.rentacarback.model.Fee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FeeRepository extends JpaRepository<Fee, Integer> {
    @Query("SELECT e FROM Fee e WHERE e.name = :name")
    Optional<Fee> findByName(@Param("name") String name);
}
