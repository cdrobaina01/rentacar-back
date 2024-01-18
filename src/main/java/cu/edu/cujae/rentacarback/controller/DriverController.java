package cu.edu.cujae.rentacarback.controller;

import cu.edu.cujae.rentacarback.exceptions.UniqueValueException;
import cu.edu.cujae.rentacarback.model.Driver;
import cu.edu.cujae.rentacarback.service.DriverService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/driver")
@RequiredArgsConstructor
public class DriverController {
    private final DriverService driverService;

    @GetMapping
    public List<Driver> getAll() {
        return driverService.findAll();
    }

    @GetMapping("/{dni}")
    public Driver getById(@PathVariable String dni) {
        return driverService.findById(dni);
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('SUPERUSER')")
    public Driver create(@RequestBody @Valid Driver driver) throws UniqueValueException {
            return driverService.create(driver);
    }

    @PutMapping("/{dni}")
    @PreAuthorize("hasAnyRole('SUPERUSER')")
    public Driver update(@PathVariable String dni, @RequestBody @Valid Driver driver) throws UniqueValueException {
            return driverService.update(dni, driver);
    }

    @DeleteMapping("/{dni}")
    @PreAuthorize("hasAnyRole('SUPERUSER')")
    public Driver delete(@PathVariable String dni) {
        return driverService.delete(dni);
    }
}
