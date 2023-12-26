package cu.edu.cujae.rentacarback.api.controller;

import cu.edu.cujae.rentacarback.dto.CountryDTO;
import cu.edu.cujae.rentacarback.dto.save.AuxiliarySaveDTO;
import cu.edu.cujae.rentacarback.model.Country;
import cu.edu.cujae.rentacarback.service.core.CountryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
        return countryService.findAll().stream()
                .map(category -> mapper.map(category, CountryDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CountryDTO> getById(@PathVariable Integer id) {
        return countryService.findById(id)
                .map(category -> mapper.map(category, CountryDTO.class))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public CountryDTO create(@RequestBody AuxiliarySaveDTO category) {
        return mapper.map(countryService.create(mapper.map(category, Country.class)), CountryDTO.class);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CountryDTO> update(@PathVariable Integer id, @RequestBody AuxiliarySaveDTO category) {
        return countryService.update(id, mapper.map(category, Country.class))
                .map(updatedCategory -> mapper.map(updatedCategory, CountryDTO.class))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CountryDTO> delete(@PathVariable Integer id) {
        return countryService.delete(id)
                .map(category -> mapper.map(category, CountryDTO.class))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
