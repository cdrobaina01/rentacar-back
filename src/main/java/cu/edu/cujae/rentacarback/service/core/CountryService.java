package cu.edu.cujae.rentacarback.service.core;

import cu.edu.cujae.rentacarback.model.Brand;
import cu.edu.cujae.rentacarback.model.Country;

import java.util.List;
import java.util.Optional;

public interface CountryService {
    List<Country> findAll();
    Optional<Country> findById(Integer id);
    Country create(Country country);
    Optional<Country> update(Integer id, Country country);
    Optional<Country> delete(Integer id);
}
