package cu.edu.cujae.rentacarback.service;

import cu.edu.cujae.rentacarback.model.Brand;
import cu.edu.cujae.rentacarback.repository.BrandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BrandService extends CrudService<Brand, Integer> {
    private final BrandRepository repository;

    @Override
    protected String getEntityName() {
        return "Brand";
    }

    @Override
    protected JpaRepository<Brand, Integer> repository() {
        return repository;
    }

    @Override
    protected void validateKeys(Brand brand) {
        if (repository.findByName(brand.getName()).isPresent()) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    protected Brand updateData(Brand brand, Brand data) {
        brand.setName(brand.getName());
        return brand;
    }
}
