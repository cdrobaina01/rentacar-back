package cu.edu.cujae.rentacarback.service.core;

import cu.edu.cujae.rentacarback.model.Brand;
import cu.edu.cujae.rentacarback.model.Situation;

import java.util.List;
import java.util.Optional;

public interface SituationService {
    List<Situation> findAll();
    Optional<Situation> findById(Integer id);
    Situation create(Situation situation);
    Optional<Situation> update(Integer id, Situation situation);
    Optional<Situation> delete(Integer id);
}
