package cu.edu.cujae.rentacarback.service.core;

import cu.edu.cujae.rentacarback.dto.BrandDTO;
import cu.edu.cujae.rentacarback.dto.save.AuxiliarySaveDTO;
import cu.edu.cujae.rentacarback.model.Brand;

import java.util.List;
import java.util.Optional;

public interface BrandService {
    List<BrandDTO> findAll();
    Optional<BrandDTO> findById(Integer id);
    Optional<BrandDTO> create(AuxiliarySaveDTO brand);
    Optional<BrandDTO> update(Integer id, AuxiliarySaveDTO brand);
    Optional<BrandDTO> delete(Integer id);
}
