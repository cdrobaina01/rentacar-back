package cu.edu.cujae.rentacarback.service.core;

import cu.edu.cujae.rentacarback.dto.DriverDTO;
import cu.edu.cujae.rentacarback.dto.save.DriverSaveDTO;
import cu.edu.cujae.rentacarback.model.Brand;
import cu.edu.cujae.rentacarback.model.Driver;

import java.util.List;
import java.util.Optional;

public interface DriverService {
    List<DriverDTO> findAll();
    Optional<DriverDTO> findById(String dni);
    Optional<DriverDTO> create(DriverSaveDTO driver);
    Optional<DriverDTO> update(String dni, DriverSaveDTO driver);
    Optional<DriverDTO> delete(String dni);
}
