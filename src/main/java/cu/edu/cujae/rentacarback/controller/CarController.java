package cu.edu.cujae.rentacarback.controller;

import cu.edu.cujae.rentacarback.dto.CarDTO;
import cu.edu.cujae.rentacarback.dto.ModelDTO;
import cu.edu.cujae.rentacarback.dto.save.CarSaveDTO;
import cu.edu.cujae.rentacarback.service.core.CarService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/car")
public class CarController {
    @Autowired
    private CarService carService;

    @GetMapping
    public List<CarDTO> getAll() {
        return carService.findAll();
    }

    @GetMapping("/{plate}")
    public ResponseEntity<CarDTO> getById(@PathVariable String plate) {
        return carService.findById(plate)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<CarDTO> create(@RequestBody CarSaveDTO car) {
        try {
            return carService.create(car)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.badRequest().build());
        } catch (DataIntegrityViolationException exception) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{plate}")
    public ResponseEntity<CarDTO> update(@PathVariable String plate, @RequestBody CarSaveDTO car) {
        try {
            return carService.update(plate, car)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        } catch (DataIntegrityViolationException exception) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{plate}")
    public ResponseEntity<CarDTO> delete(@PathVariable String plate) {
        return carService.delete(plate)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());}
}
