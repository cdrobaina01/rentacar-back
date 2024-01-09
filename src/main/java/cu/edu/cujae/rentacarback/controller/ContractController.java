package cu.edu.cujae.rentacarback.controller;

import cu.edu.cujae.rentacarback.exceptions.UniqueValueException;
import cu.edu.cujae.rentacarback.model.Contract;
import cu.edu.cujae.rentacarback.model.ContractPK;
import cu.edu.cujae.rentacarback.service.ContractService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/contract")
@RequiredArgsConstructor
public class ContractController {
    private final ContractService contractService;

    @GetMapping
    public List<Contract> getAll() {
        return contractService.findAll();
    }

    @GetMapping("/{plate}/{date}")
    public Contract getById(@PathVariable String plate, @PathVariable LocalDate date) {
        return contractService.findById(new ContractPK(plate, date));
    }

    @PostMapping
    @PreAuthorize("hasRole('SUPERUSER')")
    public Contract create(@RequestBody @Valid Contract contract) throws UniqueValueException {
            return contractService.create(contract);
    }

    @PostMapping("/open")
    public Contract open(@RequestBody @Valid Contract contract) throws UniqueValueException {
        return contractService.open(contract);
    }

    @PutMapping("/close/{plate}/{date}")
    public Contract close(@PathVariable String plate, @PathVariable LocalDate date, @RequestBody @Valid Contract contract) throws UniqueValueException {
        return contractService.close(new ContractPK(plate, date), contract);
    }

    @PutMapping("/{plate}/{date}")
    public Contract update(@PathVariable String plate, @PathVariable LocalDate date, @RequestBody @Valid Contract contract) throws UniqueValueException {
            return contractService.update(new ContractPK(plate, date), contract);
    }

    @DeleteMapping("/{plate}/{date}")
    public Contract delete(@PathVariable String plate, @PathVariable LocalDate date) {
        return contractService.delete(new ContractPK(plate, date));
    }
}
