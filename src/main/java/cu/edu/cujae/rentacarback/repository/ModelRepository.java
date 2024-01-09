package cu.edu.cujae.rentacarback.repository;

import cu.edu.cujae.rentacarback.model.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ModelRepository extends JpaRepository<Model, Integer> {
    @Query("SELECT e FROM Model e WHERE e.name = :name")
    Optional<Model> findByName(@Param("name") String name);
}
