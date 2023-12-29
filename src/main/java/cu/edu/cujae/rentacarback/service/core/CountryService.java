package cu.edu.cujae.rentacarback.service.core;

import cu.edu.cujae.rentacarback.dto.CountryDTO;
import cu.edu.cujae.rentacarback.dto.save.AuxiliarySaveDTO;
import cu.edu.cujae.rentacarback.model.Brand;
import cu.edu.cujae.rentacarback.model.Country;

import java.util.List;
import java.util.Optional;

public interface CountryService {
    List<CountryDTO> findAll();
    Optional<CountryDTO> findById(Integer id);
    Optional<CountryDTO> create(AuxiliarySaveDTO country);
    Optional<CountryDTO> update(Integer id, AuxiliarySaveDTO country);
    Optional<CountryDTO> delete(Integer id);
}
