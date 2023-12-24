package cu.edu.cujae.rentacarback.service.core;

import cu.edu.cujae.rentacarback.model.Brand;
import cu.edu.cujae.rentacarback.model.Tourist;

import java.util.List;
import java.util.Optional;

public interface TouristService {
    List<Tourist> findAll();
    Optional<Tourist> findById(String passport);
    Tourist create(Tourist tourist);
    Optional<Tourist> update(String passport, Tourist tourist);
    Optional<Tourist> delete(String passport);
}
