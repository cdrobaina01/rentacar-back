package cu.edu.cujae.rentacarback.controller;

import cu.edu.cujae.rentacarback.dto.ContractDTO;
import cu.edu.cujae.rentacarback.dto.save.ContractSaveDTO;
import cu.edu.cujae.rentacarback.model.ContractPK;
import cu.edu.cujae.rentacarback.service.core.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    private ContractService contractService;

    @GetMapping
    public List<ContractDTO> getAll() {
        return contractService.findAll();
    }

    @GetMapping("/{plate}/{date}")
    public ResponseEntity<ContractDTO> getById(@PathVariable String plate, @PathVariable LocalDate date) {
        return contractService.findById(new ContractPK(plate, date))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ContractDTO> create(@RequestBody ContractSaveDTO contract) {
        try {
            return contractService.create(contract)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.badRequest().build());
        } catch (DataIntegrityViolationException exception) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{plate}/{date}")
    public ResponseEntity<ContractDTO> update(@PathVariable String plate, @PathVariable LocalDate date, @RequestBody ContractSaveDTO contract) {
        try {
            return contractService.update(new ContractPK(plate, date), contract)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        } catch (DataIntegrityViolationException exception) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{plate}/{date}")
    public ResponseEntity<ContractDTO> delete(@PathVariable String plate, @PathVariable LocalDate date) {
        return contractService.delete(new ContractPK(plate, date))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
