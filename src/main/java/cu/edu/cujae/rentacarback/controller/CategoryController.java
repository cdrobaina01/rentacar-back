package cu.edu.cujae.rentacarback.controller;

import cu.edu.cujae.rentacarback.dto.CategoryDTO;
import cu.edu.cujae.rentacarback.dto.save.AuxiliarySaveDTO;
import cu.edu.cujae.rentacarback.service.core.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public List<CategoryDTO> getAll() {
        return categoryService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> getById(@PathVariable Integer id) {
        return categoryService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<CategoryDTO> create(@RequestBody AuxiliarySaveDTO category) {
        try {
            return categoryService.create(category)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.badRequest().build());
        } catch (DataIntegrityViolationException exception) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryDTO> update(@PathVariable Integer id, @RequestBody AuxiliarySaveDTO category) {
        try {
            return categoryService.update(id, category)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.badRequest().build());
        } catch (DataIntegrityViolationException exception) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CategoryDTO> delete(@PathVariable Integer id) {
        return categoryService.delete(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
