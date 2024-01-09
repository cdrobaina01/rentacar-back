package cu.edu.cujae.rentacarback.controller;

import cu.edu.cujae.rentacarback.exceptions.UniqueValueException;
import cu.edu.cujae.rentacarback.model.Paymethod;
import cu.edu.cujae.rentacarback.service.PaymethodService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paymethod")
@RequiredArgsConstructor
public class PaymethodController {
    private final PaymethodService paymethodService;

    @GetMapping
    public List<Paymethod> getAll() {
        return paymethodService.findAll();
    }

    @GetMapping("/{id}")
    public Paymethod getById(@PathVariable Integer id) {
        return paymethodService.findById(id);
    }

    @PostMapping
    public Paymethod create(@RequestBody @Valid Paymethod paymethod) throws UniqueValueException {
        return paymethodService.create(paymethod);
    }

    @PutMapping("/{id}")
    public Paymethod update(@PathVariable Integer id, @RequestBody @Valid Paymethod paymethod) throws UniqueValueException {
        return paymethodService.update(id, paymethod);
    }

    @DeleteMapping("/{id}")
    public Paymethod delete(@PathVariable Integer id) {
        return paymethodService.delete(id);
    }
}
