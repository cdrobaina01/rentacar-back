package cu.edu.cujae.rentacarback.service.core;

import cu.edu.cujae.rentacarback.dto.TouristDTO;
import cu.edu.cujae.rentacarback.dto.save.TouristSaveDTO;
import cu.edu.cujae.rentacarback.model.Brand;
import cu.edu.cujae.rentacarback.model.Tourist;

import java.util.List;
import java.util.Optional;

public interface TouristService {
    List<TouristDTO> findAll();
    Optional<TouristDTO> findById(String passport);
    Optional<TouristDTO> create(TouristSaveDTO tourist);
    Optional<TouristDTO> update(String passport, TouristSaveDTO tourist);
    Optional<TouristDTO> delete(String passport);
}
