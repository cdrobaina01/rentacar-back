package cu.edu.cujae.rentacarback.api.controller;

import cu.edu.cujae.rentacarback.dto.CountryDTO;
import cu.edu.cujae.rentacarback.dto.save.AuxiliarySaveDTO;
import cu.edu.cujae.rentacarback.model.Country;
import cu.edu.cujae.rentacarback.service.core.CountryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/country")
public class CountryController {
    @Autowired
    private CountryService countryService;
    private final ModelMapper mapper = new ModelMapper();

    @GetMapping
    public List<CountryDTO> getAll() {
        return countryService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CountryDTO> getById(@PathVariable Integer id) {
        return countryService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<CountryDTO> create(@RequestBody AuxiliarySaveDTO country) {
        try {
            return countryService.create(country)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.badRequest().build());
        } catch (DataIntegrityViolationException exception) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<CountryDTO> update(@PathVariable Integer id, @RequestBody AuxiliarySaveDTO country) {
        try {
            return countryService.update(id, country)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        } catch (DataIntegrityViolationException exception) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CountryDTO> delete(@PathVariable Integer id) {
        return countryService.delete(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
