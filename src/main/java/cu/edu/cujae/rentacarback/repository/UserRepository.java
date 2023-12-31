package cu.edu.cujae.rentacarback.repository;

import cu.edu.cujae.rentacarback.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
