package cu.edu.cujae.rentacarback.api.controller;

import cu.edu.cujae.rentacarback.dto.CategoryDTO;
import cu.edu.cujae.rentacarback.dto.ModelDTO;
import cu.edu.cujae.rentacarback.dto.save.AuxiliarySaveDTO;
import cu.edu.cujae.rentacarback.model.Category;
import cu.edu.cujae.rentacarback.service.core.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    private final ModelMapper mapper = new ModelMapper();

    @GetMapping
    public List<CategoryDTO> getAll() {
        return categoryService.findAll().stream()
                .map(category -> mapper.map(category, CategoryDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> getById(@PathVariable Integer id) {
        return categoryService.findById(id)
                .map(category -> mapper.map(category, CategoryDTO.class))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public CategoryDTO create(@RequestBody AuxiliarySaveDTO category) {
        return mapper.map(categoryService.create(mapper.map(category, Category.class)), CategoryDTO.class);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryDTO> update(@PathVariable Integer id, @RequestBody AuxiliarySaveDTO category) {
        return categoryService.update(id, mapper.map(category, Category.class))
                .map(updatedCategory -> mapper.map(updatedCategory, CategoryDTO.class))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CategoryDTO> delete(@PathVariable Integer id) {
        return categoryService.delete(id)
                .map(category -> mapper.map(category, CategoryDTO.class))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
