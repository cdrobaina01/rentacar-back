package cu.edu.cujae.rentacarback.controller;

import cu.edu.cujae.rentacarback.exceptions.UniqueValueException;
import cu.edu.cujae.rentacarback.model.Tourist;
import cu.edu.cujae.rentacarback.service.TouristService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tourist")
@RequiredArgsConstructor
public class TouristController {
    private final TouristService touristService;

    @GetMapping
    public List<Tourist> getAll() {
        return touristService.findAll();
    }

    @GetMapping("/{passport}")
    public Tourist getById(@PathVariable String passport) {
        return touristService.findById(passport);
    }

    @PostMapping
    public Tourist create(@RequestBody @Valid Tourist tourist) throws UniqueValueException {
            return touristService.create(tourist);
    }

    @PutMapping("/{passport}")
    public Tourist update(@PathVariable String passport, @RequestBody @Valid Tourist tourist) throws UniqueValueException {
        return touristService.update(passport, tourist);
    }

    @DeleteMapping("/{passport}")
    @PreAuthorize("hasAnyRole('SUPERUSER')")
    public Tourist delete(@PathVariable String passport) {
        return touristService.delete(passport);
    }
}
