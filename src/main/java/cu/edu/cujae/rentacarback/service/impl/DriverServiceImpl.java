package cu.edu.cujae.rentacarback.service.impl;

import cu.edu.cujae.rentacarback.model.Driver;
import cu.edu.cujae.rentacarback.repository.DriverRepository;
import cu.edu.cujae.rentacarback.service.core.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DriverServiceImpl implements DriverService {
    @Autowired
    private DriverRepository driverRepository;

    @Override
    public List<Driver> findAll() {
        return driverRepository.findAll();
    }

    @Override
    public Optional<Driver> findById(String dni) {
        return driverRepository.findById(dni);
    }

    @Override
    public Driver create(Driver driver) {
        return driverRepository.save(driver);
    }

    @Override
    public Optional<Driver> update(String dni, Driver newDriver) {
        return driverRepository.findById(dni).map(driver -> {
            driver.setName(newDriver.getName());
            driver.setEmail(newDriver.getEmail());
            driver.setAddress(newDriver.getAddress());
            driver.setCategory(newDriver.getCategory());
            return driverRepository.save(driver);
        });
    }

    @Override
    public Optional<Driver> delete(String dni) {
        return driverRepository.findById(dni).map(driver -> {
            driverRepository.delete(driver);
            return driver;
        });
    }
}
