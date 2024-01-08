package cu.edu.cujae.rentacarback.controller;

import cu.edu.cujae.rentacarback.dto.GenderDTO;
import cu.edu.cujae.rentacarback.dto.save.AuxiliarySaveDTO;
import cu.edu.cujae.rentacarback.service.core.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gender")
public class GenderController {
    @Autowired
    private GenderService genderService;

    @GetMapping
    public List<GenderDTO> getAll() {
        return genderService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenderDTO> getById(@PathVariable Integer id) {
        return genderService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<GenderDTO> create(@RequestBody AuxiliarySaveDTO gender) {
        try {
            return genderService.create(gender)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.badRequest().build());
        } catch (DataIntegrityViolationException exception) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<GenderDTO> update(@PathVariable Integer id, @RequestBody AuxiliarySaveDTO gender) {
        try {
            return genderService.update(id, gender)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        } catch (DataIntegrityViolationException exception) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GenderDTO> delete(@PathVariable Integer id) {
        return genderService.delete(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
