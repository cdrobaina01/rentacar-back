package cu.edu.cujae.rentacarback.api.controller;

import cu.edu.cujae.rentacarback.dto.FeeDTO;
import cu.edu.cujae.rentacarback.dto.save.FeeSaveDTO;
import cu.edu.cujae.rentacarback.model.Fee;
import cu.edu.cujae.rentacarback.service.core.FeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/fee")
public class FeeController {
    @Autowired
    private FeeService feeService;

    @GetMapping
    public List<FeeDTO> getAll() {
        return feeService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FeeDTO> getById(@PathVariable Integer id) {
        return feeService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<FeeDTO> create(@RequestBody FeeSaveDTO fee) {
        try {
            return feeService.create(fee)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.badRequest().build());
        } catch (DataIntegrityViolationException exception) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<FeeDTO> update(@PathVariable Integer id, @RequestBody FeeSaveDTO fee) {
        try {
            return feeService.update(id, fee)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        } catch (DataIntegrityViolationException exception) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<FeeDTO> delete(@PathVariable Integer id) {
        return feeService.delete(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
