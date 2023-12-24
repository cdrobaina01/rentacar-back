package cu.edu.cujae.rentacarback.service.core;

import cu.edu.cujae.rentacarback.model.Car;
import cu.edu.cujae.rentacarback.model.Contract;
import cu.edu.cujae.rentacarback.model.ContractPK;

import java.util.List;
import java.util.Optional;

public interface CarService {
    List<Car> findAll();
    Optional<Car> findById(String plate);
    Car create(Car car);
    Optional<Car> update(String plate, Car car);
    Optional<Car> delete(String plate);
}
