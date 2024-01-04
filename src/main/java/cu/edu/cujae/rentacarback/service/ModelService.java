package cu.edu.cujae.rentacarback.service;

import cu.edu.cujae.rentacarback.exceptions.UniqueValueException;
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
    protected JpaRepository<Model, Integer> repository() {
        return repository;
    }

    @Override
    protected void validateKeys(Model model) throws UniqueValueException {
        repository.findByName(model.getName()).orElseThrow(() -> new UniqueValueException(getEntityName(), "Name"));
        brandService.findById(model.getBrand().getId());
    }

    @Override
    protected Model updateData(Model model, Model data) {
        model.setName(data.getName());
        model.setBrand(data.getBrand());
        return model;
    }
}
