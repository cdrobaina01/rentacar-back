package cu.edu.cujae.rentacarback.service.core;

import cu.edu.cujae.rentacarback.dto.GenderDTO;
import cu.edu.cujae.rentacarback.dto.save.AuxiliarySaveDTO;
import cu.edu.cujae.rentacarback.model.Brand;
import cu.edu.cujae.rentacarback.model.Gender;

import java.util.List;
import java.util.Optional;

public interface GenderService {
    List<GenderDTO> findAll();
    Optional<GenderDTO> findById(Integer id);
    Optional<GenderDTO> create(AuxiliarySaveDTO gender);
    Optional<GenderDTO> update(Integer id, AuxiliarySaveDTO gender);
    Optional<GenderDTO> delete(Integer id);
}
