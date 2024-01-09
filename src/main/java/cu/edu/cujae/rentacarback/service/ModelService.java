package cu.edu.cujae.rentacarback.service;

import cu.edu.cujae.rentacarback.exceptions.UniqueValueException;
import cu.edu.cujae.rentacarback.model.Brand;
import cu.edu.cujae.rentacarback.model.Model;
import cu.edu.cujae.rentacarback.repository.ModelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ModelService extends CrudService<Model, Integer> {
    private final ModelRepository repository;
    private final BrandService brandService;

    @Override
    protected String getEntityName() {
        return "Model";
    }

    @Override
    protected String getKeyName() {
        return "Name";
    }

    @Override
    protected JpaRepository<Model, Integer> repository() {
        return repository;
    }

    @Override
    protected Integer getKey(Model model) {
        return model.getId();
    }

    @Override
    protected void validateExistingForeignKeys(Model model) throws UniqueValueException {
        brandService.findById(model.getBrand().getId());
    }

    @Override
    protected Model updateData(Model model, Model data) {
        model.setName(data.getName());
        model.setBrand(data.getBrand());
        return model;
    }

    @Override
    protected void validateAvailableKey(Model model) throws UniqueValueException {
        if (repository.findByName(model.getName()).isPresent()) {
            throw new UniqueValueException(getEntityName(), getKeyName());
        }
    }
}
