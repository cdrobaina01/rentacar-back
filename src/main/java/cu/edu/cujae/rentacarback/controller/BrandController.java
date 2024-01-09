package cu.edu.cujae.rentacarback.controller;

import cu.edu.cujae.rentacarback.exceptions.UniqueValueException;
import cu.edu.cujae.rentacarback.model.Brand;
import cu.edu.cujae.rentacarback.service.BrandService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brand")
@RequiredArgsConstructor
public class BrandController {
    private final BrandService brandService;

    @GetMapping
    public List<Brand> getAll() {
        return brandService.findAll();
    }

    @GetMapping("/{id}")
    public Brand getById(@PathVariable Integer id) {
        return brandService.findById(id);
    }

    @PostMapping
    public Brand create(@RequestBody @Valid Brand brand) throws UniqueValueException {
        return brandService.create(brand);
    }

    @PutMapping("/{id}")
    public Brand update(@PathVariable Integer id, @RequestBody @Valid Brand brand) throws UniqueValueException {
        return brandService.update(id, brand);
    }

    @DeleteMapping("/{id}")
    public Brand delete(@PathVariable Integer id) {
        return brandService.delete(id);
    }
}
