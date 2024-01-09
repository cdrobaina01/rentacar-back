package cu.edu.cujae.rentacarback.service;

import cu.edu.cujae.rentacarback.exceptions.UniqueValueException;
import cu.edu.cujae.rentacarback.model.Car;
import cu.edu.cujae.rentacarback.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarService extends CrudService<Car, String> {
    private final CarRepository repository;
    private final ModelService modelService;

    @Override
    protected String getEntityName() {
        return "Car";
    }

    @Override
    protected String getKeyName() {
        return "Plate";
    }

    @Override
    protected JpaRepository<Car, String> repository() {
        return repository;
    }

    @Override
    protected String getKey(Car car) {
        return car.getPlate();
    }

    @Override
    protected void validateExistingForeignKeys(Car car) throws UniqueValueException {
        modelService.findById(car.getModel().getId());
    }

    @Override
    protected Car updateData(Car car, Car data) {
        car.setKm(data.getKm());
        car.setCarSituation(data.getCarSituation());
        car.setModel(data.getModel());
        car.setColor(data.getColor());
        return car;
    }
}
