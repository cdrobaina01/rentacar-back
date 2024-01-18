package cu.edu.cujae.rentacarback.controller;

import cu.edu.cujae.rentacarback.exceptions.UniqueValueException;
import cu.edu.cujae.rentacarback.model.Car;
import cu.edu.cujae.rentacarback.service.CarService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
@RequiredArgsConstructor
public class CarController {
    private final CarService carService;

    @GetMapping
    public List<Car> getAll() {
        return carService.findAll();
    }

    @GetMapping("/{plate}")
    public Car getById(@PathVariable String plate) {
        return carService.findById(plate);
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMINISTRATIVE', 'SUPERUSER')")
    public Car create(@RequestBody @Valid Car car) throws UniqueValueException {
            return carService.create(car);
    }

    @PutMapping("/{plate}")
    @PreAuthorize("hasAnyRole('ADMINISTRATIVE', 'SUPERUSER')")
    public Car update(@PathVariable String plate, @RequestBody @Valid Car car) throws UniqueValueException {
            return carService.update(plate, car);
    }

    @DeleteMapping("/{plate}")
    @PreAuthorize("hasAnyRole('SUPERUSER')")
    public Car delete(@PathVariable String plate) {
        return carService.delete(plate);
    }
}
