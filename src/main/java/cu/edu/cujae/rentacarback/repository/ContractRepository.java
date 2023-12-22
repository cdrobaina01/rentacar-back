package cu.edu.cujae.rentacarback.repository;

import cu.edu.cujae.rentacarback.model.Category;
import cu.edu.cujae.rentacarback.model.Contract;
import cu.edu.cujae.rentacarback.model.ContractPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractRepository extends JpaRepository<Contract, ContractPK> {
}
