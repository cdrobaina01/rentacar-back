package cu.edu.cujae.rentacarback.service.impl;

import cu.edu.cujae.rentacarback.dto.BrandDTO;
import cu.edu.cujae.rentacarback.dto.save.AuxiliarySaveDTO;
import cu.edu.cujae.rentacarback.model.Brand;
import cu.edu.cujae.rentacarback.repository.BrandRepository;
import cu.edu.cujae.rentacarback.service.core.BrandService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandRepository brandRepository;
    private final ModelMapper mapper = new ModelMapper();

    @Override
    public List<BrandDTO> findAll() {
        return brandRepository.findAll().stream()
                .map(brand -> mapper.map(brand, BrandDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<BrandDTO> findById(Integer id) {
        return brandRepository.findById(id).map(brand -> mapper.map(brand, BrandDTO.class));
    }

    @Override
    public Optional<BrandDTO> create(AuxiliarySaveDTO brand) throws DataIntegrityViolationException {
        return Optional.of(mapper.map(
                brandRepository.save(new Brand(null, brand.getName(), null)),
                BrandDTO.class
        ));
    }

    @Override
    public Optional<BrandDTO> update(Integer id, AuxiliarySaveDTO newBrand) throws DataIntegrityViolationException{
        return brandRepository.findById(id).map(brand -> {
            brand.setName(newBrand.getName());
            return mapper.map(brandRepository.save(brand), BrandDTO.class);
        });
    }

    @Override
    public Optional<BrandDTO> delete(Integer id) {
        return brandRepository.findById(id).map(brand -> {
            brandRepository.delete(brand);
            return mapper.map(brand, BrandDTO.class);
        });
    }
}
