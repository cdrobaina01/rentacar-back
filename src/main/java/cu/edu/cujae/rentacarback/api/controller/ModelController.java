package cu.edu.cujae.rentacarback.api.controller;

import cu.edu.cujae.rentacarback.dto.BrandDTO;
import cu.edu.cujae.rentacarback.dto.ModelDTO;
import cu.edu.cujae.rentacarback.model.Brand;
import cu.edu.cujae.rentacarback.model.Model;
import cu.edu.cujae.rentacarback.service.core.BrandService;
import cu.edu.cujae.rentacarback.service.core.ModelService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/model")
public class ModelController {
    private final ModelService modelService;
    private final ModelMapper mapper = new ModelMapper();

    @Autowired
    public ModelController(ModelService modelService) {
        this.modelService = modelService;
    }

    @GetMapping
    public List<ModelDTO> getAll() {
        return modelService.findAll().stream()
                .map(brand -> mapper.map(brand, ModelDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ModelDTO> getById(@PathVariable Integer id) {
        return modelService.findById(id)
                .map(brand -> mapper.map(brand, ModelDTO.class))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ModelDTO create(@RequestBody Model model) {
        return mapper.map(modelService.create(model), ModelDTO.class);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ModelDTO> update(@PathVariable Integer id, @RequestBody Model model) {
        return modelService.update(id, model)
                .map(updatedBrand -> mapper.map(updatedBrand, ModelDTO.class))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ModelDTO> delete(@PathVariable Integer id) {
        return modelService.delete(id)
                .map(model -> mapper.map(model, ModelDTO.class))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
