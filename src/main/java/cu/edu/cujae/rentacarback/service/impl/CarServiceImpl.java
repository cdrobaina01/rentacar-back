package cu.edu.cujae.rentacarback.service.impl;

import cu.edu.cujae.rentacarback.model.Car;
import cu.edu.cujae.rentacarback.repository.CarRepository;
import cu.edu.cujae.rentacarback.service.core.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {
    @Autowired
    private CarRepository carRepository;

    @Override
    public List<Car> findAll() {
        return carRepository.findAll();
    }

    @Override
    public Optional<Car> findById(String plate) {
        return carRepository.findById(plate);
    }

    @Override
    public Car create(Car car) {
        return carRepository.save(car);
    }

    @Override
    public Optional<Car> update(String plate, Car newCar) {
        return carRepository.findById(plate).map(car -> {
            car.setModel(newCar.getModel());
            car.setSituation(newCar.getSituation());
            car.setKm(newCar.getKm());
            car.setColor(newCar.getColor());
            return carRepository.save(car);
        });
    }

    @Override
    public Optional<Car> delete(String plate) {
        return carRepository.findById(plate).map(car -> {
            carRepository.delete(car);
            return car;
        });
    }
}
