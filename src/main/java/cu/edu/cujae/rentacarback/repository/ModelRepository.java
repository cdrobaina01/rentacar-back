package cu.edu.cujae.rentacarback.repository;

import cu.edu.cujae.rentacarback.model.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelRepository extends JpaRepository<Model, Integer> {
}
