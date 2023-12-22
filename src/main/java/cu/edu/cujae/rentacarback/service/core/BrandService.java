package cu.edu.cujae.rentacarback.service.core;

import cu.edu.cujae.rentacarback.dto.BrandDTO;
import cu.edu.cujae.rentacarback.model.Brand;

import java.util.List;
import java.util.Optional;

public interface BrandService {
    List<Brand> findAll();
    Optional<Brand> findById(Integer id);
    Brand create(Brand brand);
    Optional<Brand> update(Integer id, Brand brand);
    Optional<Brand> delete(Integer id);
}
