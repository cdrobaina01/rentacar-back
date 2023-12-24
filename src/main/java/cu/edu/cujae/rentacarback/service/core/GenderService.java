package cu.edu.cujae.rentacarback.service.core;

import cu.edu.cujae.rentacarback.model.Brand;
import cu.edu.cujae.rentacarback.model.Gender;

import java.util.List;
import java.util.Optional;

public interface GenderService {
    List<Gender> findAll();
    Optional<Gender> findById(Integer id);
    Gender create(Gender gender);
    Optional<Gender> update(Integer id, Gender gender);
    Optional<Gender> delete(Integer id);
}
