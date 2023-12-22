package cu.edu.cujae.rentacarback.api.controller;

import cu.edu.cujae.rentacarback.dto.BrandDTO;
import cu.edu.cujae.rentacarback.model.Brand;
import cu.edu.cujae.rentacarback.service.core.BrandService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/brand")
public class BrandController {
    private final BrandService brandService;
    private final ModelMapper mapper = new ModelMapper();

    @Autowired
    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping
    public List<BrandDTO> getAll() {
        return brandService.findAll().stream()
                .map(brand -> mapper.map(brand, BrandDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BrandDTO> getById(@PathVariable Integer id) {
        return brandService.findById(id)
                .map(brand -> mapper.map(brand, BrandDTO.class))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public BrandDTO create(@RequestBody BrandDTO brand) {
        return mapper.map(brandService
                .create(mapper.map(brand, Brand.class)), BrandDTO.class);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BrandDTO> update(@PathVariable Integer id, @RequestBody Brand brand) {
        return brandService.update(id, brand)
                .map(updatedBrand -> mapper.map(updatedBrand, BrandDTO.class))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BrandDTO> delete(@PathVariable Integer id) {
        return brandService.delete(id)
                .map(brand -> mapper.map(brand, BrandDTO.class))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
