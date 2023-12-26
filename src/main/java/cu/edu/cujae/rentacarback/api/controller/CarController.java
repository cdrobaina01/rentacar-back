package cu.edu.cujae.rentacarback.api.controller;

import cu.edu.cujae.rentacarback.dto.CarDTO;
import cu.edu.cujae.rentacarback.service.core.CarService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/car")
public class CarController {
    @Autowired
    private CarService carService;
    private final ModelMapper mapper = new ModelMapper();

    @GetMapping
    public List<CarDTO> getAll() {
        return carService.findAll().stream()
                .map(car -> mapper.map(car, CarDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/{plate}")
    public ResponseEntity<CarDTO> getById(@PathVariable String plate) {
        return carService.findById(plate)
                .map(car -> mapper.map(car, CarDTO.class))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
