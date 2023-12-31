package cu.edu.cujae.rentacarback.repository;

import cu.edu.cujae.rentacarback.model.Paymethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PaymethodRepository extends JpaRepository<Paymethod, Integer> {
    @Query("SELECT e FROM Paymethod e WHERE e.name = :name")
    Optional<Paymethod> findByName(@Param("name") String name);
}
