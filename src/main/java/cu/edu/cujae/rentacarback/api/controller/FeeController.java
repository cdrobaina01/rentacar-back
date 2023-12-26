package cu.edu.cujae.rentacarback.api.controller;

import cu.edu.cujae.rentacarback.dto.FeeDTO;
import cu.edu.cujae.rentacarback.dto.save.FeeSaveDTO;
import cu.edu.cujae.rentacarback.model.Fee;
import cu.edu.cujae.rentacarback.service.core.FeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/fee")
public class FeeController {
    @Autowired
    private FeeService feeService;
    private final ModelMapper mapper = new ModelMapper();

    @GetMapping
    public List<FeeDTO> getAll() {
        return feeService.findAll().stream()
                .map(fee -> mapper.map(fee, FeeDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FeeDTO> getById(@PathVariable Integer id) {
        return feeService.findById(id)
                .map(fee -> mapper.map(fee, FeeDTO.class))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public FeeDTO create(@RequestBody FeeSaveDTO fee) {
        return mapper.map(feeService.create(mapper.map(fee, Fee.class)), FeeDTO.class);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FeeDTO> update(@PathVariable Integer id, @RequestBody FeeSaveDTO fee) {
        return feeService.update(id, mapper.map(fee, Fee.class))
                .map(updatedFee -> mapper.map(updatedFee, FeeDTO.class))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<FeeDTO> delete(@PathVariable Integer id) {
        return feeService.delete(id)
                .map(fee -> mapper.map(fee, FeeDTO.class))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
