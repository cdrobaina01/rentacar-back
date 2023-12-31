package cu.edu.cujae.rentacarback.controller;

import cu.edu.cujae.rentacarback.dto.TouristDTO;
import cu.edu.cujae.rentacarback.dto.save.TouristSaveDTO;
import cu.edu.cujae.rentacarback.service.core.TouristService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tourist")
public class TouristController {
    @Autowired
    private TouristService touristService;

    @GetMapping
    public List<TouristDTO> getAll() {
        return touristService.findAll();
    }

    @GetMapping("/{passport}")
    public ResponseEntity<TouristDTO> getById(@PathVariable String passport) {
        return touristService.findById(passport)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<TouristDTO> create(@RequestBody TouristSaveDTO tourist) {
        try {
            return touristService.create(tourist)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.badRequest().build());
        } catch (DataIntegrityViolationException exception) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{passport}")
    public ResponseEntity<TouristDTO> update(@PathVariable String passport, @RequestBody TouristSaveDTO tourist) {
        try {
            return touristService.update(passport, tourist)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        } catch (DataIntegrityViolationException exception) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{passport}")
    public ResponseEntity<TouristDTO> delete(@PathVariable String passport) {
        return touristService.delete(passport)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
