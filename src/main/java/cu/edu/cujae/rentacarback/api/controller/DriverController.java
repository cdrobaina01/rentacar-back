package cu.edu.cujae.rentacarback.api.controller;

import cu.edu.cujae.rentacarback.dto.DriverDTO;
import cu.edu.cujae.rentacarback.dto.save.DriverSaveDTO;
import cu.edu.cujae.rentacarback.service.core.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/driver")
public class DriverController {
    @Autowired
    private DriverService driverService;

    @GetMapping
    public List<DriverDTO> getAll() {
        return driverService.findAll();
    }

    @GetMapping("/{dni}")
    public ResponseEntity<DriverDTO> getById(@PathVariable String dni) {
        return driverService.findById(dni)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<DriverDTO> create(@RequestBody DriverSaveDTO driver) {
        try {
            return driverService.create(driver)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.badRequest().build());
        } catch (DataIntegrityViolationException exception) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{dni}")
    public ResponseEntity<DriverDTO> update(@PathVariable String dni, @RequestBody DriverSaveDTO driver) {
        try {
            return driverService.update(dni, driver)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        } catch (DataIntegrityViolationException exception) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{dni}")
    public ResponseEntity<DriverDTO> delete(@PathVariable String dni) {
        return driverService.delete(dni)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
