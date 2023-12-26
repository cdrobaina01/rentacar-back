package cu.edu.cujae.rentacarback.api.controller;

import cu.edu.cujae.rentacarback.dto.SituationDTO;
import cu.edu.cujae.rentacarback.dto.save.AuxiliarySaveDTO;
import cu.edu.cujae.rentacarback.model.Situation;
import cu.edu.cujae.rentacarback.service.core.SituationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/situation")
public class SituationController {
    @Autowired
    private SituationService situationService;
    private final ModelMapper mapper = new ModelMapper();

    @GetMapping
    public List<SituationDTO> getAll() {
        return situationService.findAll().stream()
                .map(category -> mapper.map(category, SituationDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SituationDTO> getById(@PathVariable Integer id) {
        return situationService.findById(id)
                .map(category -> mapper.map(category, SituationDTO.class))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public SituationDTO create(@RequestBody AuxiliarySaveDTO category) {
        return mapper.map(situationService.create(mapper.map(category, Situation.class)), SituationDTO.class);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SituationDTO> update(@PathVariable Integer id, @RequestBody AuxiliarySaveDTO category) {
        return situationService.update(id, mapper.map(category, Situation.class))
                .map(updatedCategory -> mapper.map(updatedCategory, SituationDTO.class))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SituationDTO> delete(@PathVariable Integer id) {
        return situationService.delete(id)
                .map(category -> mapper.map(category, SituationDTO.class))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
