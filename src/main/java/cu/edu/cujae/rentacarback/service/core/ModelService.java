package cu.edu.cujae.rentacarback.service.core;

import cu.edu.cujae.rentacarback.dto.ModelDTO;
import cu.edu.cujae.rentacarback.dto.save.ModelSaveDTO;
import cu.edu.cujae.rentacarback.model.Model;

import java.util.List;
import java.util.Optional;

public interface ModelService {
    List<ModelDTO> findAll();
    Optional<ModelDTO> findById(Integer id);
    Optional<ModelDTO> create(ModelSaveDTO model);
    Optional<ModelDTO> update(Integer id, ModelSaveDTO model);
    Optional<ModelDTO> delete(Integer id);
}
