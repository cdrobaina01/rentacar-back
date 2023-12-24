package cu.edu.cujae.rentacarback.service.core;

import cu.edu.cujae.rentacarback.model.Brand;
import cu.edu.cujae.rentacarback.model.Driver;

import java.util.List;
import java.util.Optional;

public interface DriverService {
    List<Driver> findAll();
    Optional<Driver> findById(String dni);
    Driver create(Driver driver);
    Optional<Driver> update(String dni, Driver driver);
    Optional<Driver> delete(String dni);
}
