package cu.edu.cujae.rentacarback.service.core;

import cu.edu.cujae.rentacarback.model.Model;

import java.util.List;
import java.util.Optional;

public interface ModelService {
    List<Model> findAll();
    Optional<Model> findById(Integer id);
    Model create(Model model);
    Optional<Model> update(Integer id, Model model);
    Optional<Model> delete(Integer id);
}
