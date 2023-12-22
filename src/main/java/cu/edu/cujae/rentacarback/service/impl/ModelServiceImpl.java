package cu.edu.cujae.rentacarback.service.impl;

import cu.edu.cujae.rentacarback.model.Brand;
import cu.edu.cujae.rentacarback.model.Model;
import cu.edu.cujae.rentacarback.repository.BrandRepository;
import cu.edu.cujae.rentacarback.repository.ModelRepository;
import cu.edu.cujae.rentacarback.service.core.BrandService;
import cu.edu.cujae.rentacarback.service.core.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModelServiceImpl implements ModelService {
    private final ModelRepository modelRepository;

    @Autowired
    public ModelServiceImpl(ModelRepository modelRepository){
        this.modelRepository = modelRepository;
    }

    @Override
    public List<Model> findAll() {
        return modelRepository.findAll();
    }

    @Override
    public Optional<Model> findById(Integer id) {
        return modelRepository.findById(id);
    }

    @Override
    public Model create(Model model) {
        return modelRepository.save(model);
    }

    @Override
    public Optional<Model> update(Integer id, Model newModel) {
        return modelRepository.findById(id)
                .map(brand -> {
                    brand.setName(newModel.getName());
                    return modelRepository.save(brand);
                });
    }

    @Override
    public Optional<Model> delete(Integer id) {
        return modelRepository.findById(id).map(brand -> {
            modelRepository.delete(brand);
            return brand;
        });
    }
}
