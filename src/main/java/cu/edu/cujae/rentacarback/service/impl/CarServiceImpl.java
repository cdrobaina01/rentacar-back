package cu.edu.cujae.rentacarback.service.impl;

import cu.edu.cujae.rentacarback.dto.CarDTO;
import cu.edu.cujae.rentacarback.dto.save.CarSaveDTO;
import cu.edu.cujae.rentacarback.model.Car;
import cu.edu.cujae.rentacarback.model.Model;
import cu.edu.cujae.rentacarback.model.Situation;
import cu.edu.cujae.rentacarback.repository.CarRepository;
import cu.edu.cujae.rentacarback.repository.ModelRepository;
import cu.edu.cujae.rentacarback.repository.SituationRepository;
import cu.edu.cujae.rentacarback.service.core.CarService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {
    @Autowired
    private CarRepository carRepository;
    private final ModelMapper mapper = new ModelMapper();

    @Autowired
    private ModelRepository modelRepository;
    @Autowired
    private SituationRepository situationRepository;

    @Override
    public List<CarDTO> findAll() {
        return carRepository.findAll().stream()
                .map(car -> mapper.map(car, CarDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<CarDTO> findById(String plate) {
        return carRepository.findById(plate).map(car -> mapper.map(car, CarDTO.class));
    }

    @Override
    public Optional<CarDTO> create(CarSaveDTO car) throws DataIntegrityViolationException {
        Optional<Model> model = modelRepository.findById(car.getModelId());
        Optional<Situation> situation = situationRepository.findById(car.getSituationId());
        if (model.isEmpty() || situation.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(mapper.map(
                carRepository.save(new Car(car.getPlate(), car.getKm(), car.getColor(), model.get(), situation.get(), null)),
                CarDTO.class
        ));
    }

    @Override
    public Optional<CarDTO> update(String plate, CarSaveDTO newCar) throws DataIntegrityViolationException {
        Optional<Model> model = modelRepository.findById(newCar.getModelId());
        Optional<Situation> situation = situationRepository.findById(newCar.getSituationId());
        if (model.isEmpty() || situation.isEmpty()) {
            return Optional.empty();
        }
        return carRepository.findById(plate).map(car -> {
            car.setModel(model.get());
            car.setSituation(situation.get());
            car.setKm(newCar.getKm());
            car.setColor(newCar.getColor());
            return mapper.map(carRepository.save(car), CarDTO.class);
        });
    }

    @Override
    public Optional<CarDTO> delete(String plate) {
        return carRepository.findById(plate).map(car -> {
            carRepository.delete(car);
            return mapper.map(car, CarDTO.class);
        });
    }
}
