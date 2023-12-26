package cu.edu.cujae.rentacarback.api.controller;

import cu.edu.cujae.rentacarback.dto.ModelDTO;
import cu.edu.cujae.rentacarback.dto.save.ModelSaveDTO;
import cu.edu.cujae.rentacarback.service.core.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/model")
public class ModelController {
    @Autowired
    private ModelService modelService;

    @GetMapping
    public List<ModelDTO> getAll() {
        return modelService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ModelDTO> getById(@PathVariable Integer id) {
        return modelService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ModelDTO> create(@RequestBody ModelSaveDTO model) {
        try {
            return modelService.create(model)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.badRequest().build());
        } catch (DataIntegrityViolationException exception) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ModelDTO> update(@PathVariable Integer id, @RequestBody ModelSaveDTO model) {
        try {
            return modelService.update(id, model)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        } catch (DataIntegrityViolationException exception) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ModelDTO> delete(@PathVariable Integer id) {
        return modelService.delete(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
