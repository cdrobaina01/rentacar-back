package cu.edu.cujae.rentacarback.service.impl;

import cu.edu.cujae.rentacarback.dto.BrandDTO;
import cu.edu.cujae.rentacarback.model.Brand;
import cu.edu.cujae.rentacarback.repository.BrandRepository;
import cu.edu.cujae.rentacarback.service.core.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BrandServiceImpl implements BrandService {
    private final BrandRepository brandRepository;

    @Autowired
    public BrandServiceImpl(BrandRepository brandRepository){
        this.brandRepository = brandRepository;
    }

    @Override
    public List<Brand> findAll() {
        return brandRepository.findAll();
    }

    @Override
    public Optional<Brand> findById(Integer id) {
        return brandRepository.findById(id);
    }

    @Override
    public Brand create(Brand brand) {
        return brandRepository.save(brand);
    }

    @Override
    public Optional<Brand> update(Integer id, Brand newBrand) {
        return brandRepository.findById(id)
                .map(brand -> {
                    brand.setName(newBrand.getName());
                    return brandRepository.save(brand);
                });
    }

    @Override
    public Optional<Brand> delete(Integer id) {
        return brandRepository.findById(id).map(brand -> {
            brandRepository.delete(brand);
            return brand;
        });
    }
}
