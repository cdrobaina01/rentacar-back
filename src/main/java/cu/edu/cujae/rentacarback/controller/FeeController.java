package cu.edu.cujae.rentacarback.controller;

import cu.edu.cujae.rentacarback.exceptions.UniqueValueException;
import cu.edu.cujae.rentacarback.model.Fee;
import cu.edu.cujae.rentacarback.service.FeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fee")
@RequiredArgsConstructor
public class FeeController {
    private final FeeService feeService;

    @GetMapping
    public List<Fee> getAll() {
        return feeService.findAll();
    }

    @GetMapping("/{id}")
    public Fee getById(@PathVariable Integer id) {
        return feeService.findById(id);
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('SUPERUSER')")
    public Fee create(@RequestBody @Valid Fee fee) throws UniqueValueException {
            return feeService.create(fee);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('SUPERUSER')")
    public Fee update(@PathVariable Integer id, @RequestBody @Valid Fee fee) throws UniqueValueException {
            return feeService.update(id, fee);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('SUPERUSER')")
    public Fee delete(@PathVariable Integer id) {
        return feeService.delete(id);
    }
}
