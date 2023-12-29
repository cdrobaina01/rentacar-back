package cu.edu.cujae.rentacarback.service.impl;

import cu.edu.cujae.rentacarback.dto.CategoryDTO;
import cu.edu.cujae.rentacarback.dto.save.AuxiliarySaveDTO;
import cu.edu.cujae.rentacarback.model.Category;
import cu.edu.cujae.rentacarback.repository.CategoryRepository;
import cu.edu.cujae.rentacarback.service.core.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    private final ModelMapper mapper = new ModelMapper();

    @Override
    public List<CategoryDTO> findAll() {
        return categoryRepository.findAll().stream()
                .map(category -> mapper.map(category, CategoryDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<CategoryDTO> findById(Integer id) {
        return categoryRepository.findById(id).map(category -> mapper.map(category, CategoryDTO.class));
    }

    @Override
    public Optional<CategoryDTO> create(AuxiliarySaveDTO category) throws DataIntegrityViolationException {
        return Optional.of(mapper.map(
                categoryRepository.save(new Category(null, category.getName(), null)),
                CategoryDTO.class
        ));
    }

    @Override
    public Optional<CategoryDTO> update(Integer id, AuxiliarySaveDTO newCategory) throws DataIntegrityViolationException {
        return categoryRepository.findById(id).map(category -> {
                    newCategory.setName(newCategory.getName());
                    return mapper.map(categoryRepository.save(category), CategoryDTO.class);
                });
    }

    @Override
    public Optional<CategoryDTO> delete(Integer id) {
        return categoryRepository.findById(id).map(category -> {
            categoryRepository.delete(category);
            return mapper.map(category, CategoryDTO.class);
        });
    }
}
