package cu.edu.cujae.rentacarback.service.core;

import cu.edu.cujae.rentacarback.dto.CarDTO;
import cu.edu.cujae.rentacarback.dto.save.CarSaveDTO;
import cu.edu.cujae.rentacarback.model.Car;
import cu.edu.cujae.rentacarback.model.Contract;
import cu.edu.cujae.rentacarback.model.ContractPK;

import java.util.List;
import java.util.Optional;

public interface CarService {
    List<CarDTO> findAll();
    Optional<CarDTO> findById(String plate);
    Optional<CarDTO> create(CarSaveDTO car);
    Optional<CarDTO> update(String plate, CarSaveDTO car);
    Optional<CarDTO> delete(String plate);
}
