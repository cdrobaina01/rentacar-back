package cu.edu.cujae.rentacarback.controller;

import cu.edu.cujae.rentacarback.exceptions.UniqueValueException;
import cu.edu.cujae.rentacarback.model.Model;
import cu.edu.cujae.rentacarback.service.ModelService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/model")
@RequiredArgsConstructor
public class ModelController {
    private final ModelService modelService;

    @GetMapping
    public List<Model> getAll() {
        return modelService.findAll();
    }

    @GetMapping("/{id}")
    public Model getById(@PathVariable Integer id) {
        return modelService.findById(id);
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMINISTRATIVE', 'SUPERUSER')")
    public Model create(@RequestBody @Valid Model model) throws UniqueValueException {
        return modelService.create(model);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMINISTRATIVE', 'SUPERUSER')")
    public Model update(@PathVariable Integer id, @RequestBody @Valid Model model) throws UniqueValueException {
        return modelService.update(id, model);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('SUPERUSER')")
    public Model delete(@PathVariable Integer id) {
        return modelService.delete(id);
    }
}
