package cu.edu.cujae.rentacarback.service.core;

import cu.edu.cujae.rentacarback.dto.CategoryDTO;
import cu.edu.cujae.rentacarback.dto.save.AuxiliarySaveDTO;
import cu.edu.cujae.rentacarback.model.Brand;
import cu.edu.cujae.rentacarback.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<CategoryDTO> findAll();
    Optional<CategoryDTO> findById(Integer id);
    Optional<CategoryDTO> create(AuxiliarySaveDTO category);
    Optional<CategoryDTO> update(Integer id, AuxiliarySaveDTO category);
    Optional<CategoryDTO> delete(Integer id);
}
