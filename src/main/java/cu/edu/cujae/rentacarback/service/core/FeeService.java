package cu.edu.cujae.rentacarback.service.core;

import cu.edu.cujae.rentacarback.dto.FeeDTO;
import cu.edu.cujae.rentacarback.dto.save.FeeSaveDTO;
import cu.edu.cujae.rentacarback.model.Brand;
import cu.edu.cujae.rentacarback.model.Fee;

import java.util.List;
import java.util.Optional;

public interface FeeService {
    List<FeeDTO> findAll();
    Optional<FeeDTO> findById(Integer id);
    Optional<FeeDTO> create(FeeSaveDTO fee);
    Optional<FeeDTO> update(Integer id, FeeSaveDTO fee);
    Optional<FeeDTO> delete(Integer id);
}
