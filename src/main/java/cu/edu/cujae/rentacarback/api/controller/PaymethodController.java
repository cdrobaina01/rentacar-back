package cu.edu.cujae.rentacarback.api.controller;

import cu.edu.cujae.rentacarback.dto.PaymethodDTO;
import cu.edu.cujae.rentacarback.dto.save.AuxiliarySaveDTO;
import cu.edu.cujae.rentacarback.service.core.PaymethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paymethod")
public class PaymethodController {
    @Autowired
    private PaymethodService paymethodService;

    @GetMapping
    public List<PaymethodDTO> getAll() {
        return paymethodService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymethodDTO> getById(@PathVariable Integer id) {
        return paymethodService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PaymethodDTO> create(@RequestBody AuxiliarySaveDTO paymethod) {
        try {
            return paymethodService.create(paymethod)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.badRequest().build());
        } catch (DataIntegrityViolationException exception) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<PaymethodDTO> update(@PathVariable Integer id, @RequestBody AuxiliarySaveDTO paymethod) {
        try {
            return paymethodService.update(id, paymethod)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        } catch (DataIntegrityViolationException exception) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PaymethodDTO> delete(@PathVariable Integer id) {
        return paymethodService.delete(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
