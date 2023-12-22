package cu.edu.cujae.rentacarback.repository;

import cu.edu.cujae.rentacarback.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
