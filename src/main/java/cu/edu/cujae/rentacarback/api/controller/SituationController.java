package cu.edu.cujae.rentacarback.api.controller;

import cu.edu.cujae.rentacarback.dto.SituationDTO;
import cu.edu.cujae.rentacarback.dto.save.AuxiliarySaveDTO;
import cu.edu.cujae.rentacarback.model.Situation;
import cu.edu.cujae.rentacarback.service.core.SituationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/situation")
public class SituationController {
    @Autowired
    private SituationService situationService;

    @GetMapping
    public List<SituationDTO> getAll() {
        return situationService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SituationDTO> getById(@PathVariable Integer id) {
        return situationService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<SituationDTO> create(@RequestBody AuxiliarySaveDTO situation) {
        try {
            return situationService.create(situation)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.badRequest().build());
        } catch (DataIntegrityViolationException exception) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<SituationDTO> update(@PathVariable Integer id, @RequestBody AuxiliarySaveDTO situation) {
        try {
            return situationService.update(id, situation)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        } catch (DataIntegrityViolationException exception) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SituationDTO> delete(@PathVariable Integer id) {
        return situationService.delete(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
