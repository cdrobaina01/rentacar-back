package cu.edu.cujae.rentacarback.service.core;

import cu.edu.cujae.rentacarback.dto.ContractDTO;
import cu.edu.cujae.rentacarback.dto.save.ContractSaveDTO;
import cu.edu.cujae.rentacarback.model.Brand;
import cu.edu.cujae.rentacarback.model.Contract;
import cu.edu.cujae.rentacarback.model.ContractPK;

import java.util.List;
import java.util.Optional;

public interface ContractService {
    List<ContractDTO> findAll();
    Optional<ContractDTO> findById(ContractPK pk);
    Optional<ContractDTO> create(ContractSaveDTO contract);
    Optional<ContractDTO> update(ContractPK pk, ContractSaveDTO contract);
    Optional<ContractDTO> delete(ContractPK pk);
}
