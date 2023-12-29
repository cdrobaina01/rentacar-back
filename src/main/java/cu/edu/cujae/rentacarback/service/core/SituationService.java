package cu.edu.cujae.rentacarback.service.core;

import cu.edu.cujae.rentacarback.dto.SituationDTO;
import cu.edu.cujae.rentacarback.dto.save.AuxiliarySaveDTO;
import cu.edu.cujae.rentacarback.model.Brand;
import cu.edu.cujae.rentacarback.model.Situation;

import java.util.List;
import java.util.Optional;

public interface SituationService {
    List<SituationDTO> findAll();
    Optional<SituationDTO> findById(Integer id);
    Optional<SituationDTO> create(AuxiliarySaveDTO situation);
    Optional<SituationDTO> update(Integer id, AuxiliarySaveDTO situation);
    Optional<SituationDTO> delete(Integer id);
}
