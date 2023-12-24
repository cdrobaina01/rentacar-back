package cu.edu.cujae.rentacarback.service.core;

import cu.edu.cujae.rentacarback.model.Brand;
import cu.edu.cujae.rentacarback.model.Contract;
import cu.edu.cujae.rentacarback.model.ContractPK;

import java.util.List;
import java.util.Optional;

public interface ContractService {
    List<Contract> findAll();
    Optional<Contract> findById(ContractPK pk);
    Contract create(Contract contract);
    Optional<Contract> update(ContractPK pk, Contract contract);
    Optional<Contract> delete(ContractPK pk);
}
