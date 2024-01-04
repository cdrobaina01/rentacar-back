package cu.edu.cujae.rentacarback.service;

import cu.edu.cujae.rentacarback.model.Model;
import cu.edu.cujae.rentacarback.repository.BrandRepository;
import cu.edu.cujae.rentacarback.repository.ModelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ModelService extends CrudService<Model, Integer> {
    private final ModelRepository repository;
    private final BrandRepository brandRepository;

    @Override
    protected String getEntityName() {
        return "Model";
    }

    @Override
    protected JpaRepository<Model, Integer> repository() {
        return repository;
    }

    @Override
    protected void validateKeys(Model model) {

    }

    @Override
    protected Model updateData(Model model, Model data) {
        model.setName(data.getName());
        model.setBrand(data.getBrand());
        return model;
    }
}
