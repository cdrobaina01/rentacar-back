package cu.edu.cujae.rentacarback.service.impl;

import cu.edu.cujae.rentacarback.dto.ModelDTO;
import cu.edu.cujae.rentacarback.dto.save.ModelSaveDTO;
import cu.edu.cujae.rentacarback.model.Brand;
import cu.edu.cujae.rentacarback.model.Model;
import cu.edu.cujae.rentacarback.repository.BrandRepository;
import cu.edu.cujae.rentacarback.repository.ModelRepository;
import cu.edu.cujae.rentacarback.service.core.BrandService;
import cu.edu.cujae.rentacarback.service.core.ModelService;
import jakarta.annotation.PostConstruct;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ModelServiceImpl implements ModelService {
    @Autowired
    private ModelRepository modelRepository;
    private final ModelMapper mapper = new ModelMapper();

    @Autowired
    private BrandRepository brandRepository;

    @Override
    public List<ModelDTO> findAll() {
        return modelRepository.findAll().stream()
                .map(model -> mapper.map(model, ModelDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ModelDTO> findById(Integer id) {
        return modelRepository.findById(id).map(model -> mapper.map(model, ModelDTO.class));
    }

    @Override
    public Optional<ModelDTO> create(ModelSaveDTO model) throws DataIntegrityViolationException {
        Optional<Brand> brand = brandRepository.findById(model.getBrandId());
        if (brand.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(mapper.map(
                modelRepository.save(new Model(null, model.getName(), brand.get(), null)),
                ModelDTO.class
        ));
    }

    @Override
    public Optional<ModelDTO> update(Integer id, ModelSaveDTO newModel) throws DataIntegrityViolationException {
        Optional<Brand> brand = brandRepository.findById(newModel.getBrandId());
        if (brand.isEmpty()) {
            return Optional.empty();
        }
        return modelRepository.findById(id).map(model -> {
            model.setName(newModel.getName());
            model.setBrand(brand.get());
            return mapper.map(modelRepository.save(model), ModelDTO.class);
        });
    }

    @Override
    public Optional<ModelDTO> delete(Integer id) {
        return modelRepository.findById(id).map(model -> {
            modelRepository.delete(model);
            return mapper.map(model, ModelDTO.class);
        });
    }
}
