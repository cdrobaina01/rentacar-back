package cu.edu.cujae.rentacarback.service.impl;

import cu.edu.cujae.rentacarback.dto.DriverDTO;
import cu.edu.cujae.rentacarback.dto.save.DriverSaveDTO;
import cu.edu.cujae.rentacarback.model.Category;
import cu.edu.cujae.rentacarback.model.Driver;
import cu.edu.cujae.rentacarback.repository.CategoryRepository;
import cu.edu.cujae.rentacarback.repository.DriverRepository;
import cu.edu.cujae.rentacarback.service.core.DriverService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DriverServiceImpl implements DriverService {
    @Autowired
    private DriverRepository driverRepository;
    private final ModelMapper mapper = new ModelMapper();

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<DriverDTO> findAll() {
        return driverRepository.findAll().stream()
                .map(driver -> mapper.map(driver, DriverDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<DriverDTO> findById(String dni) {
        return driverRepository.findById(dni).map(driver -> mapper.map(driver, DriverDTO.class));
    }

    @Override
    public Optional<DriverDTO> create(DriverSaveDTO driver) throws DataIntegrityViolationException {
        Optional<Category> category = categoryRepository.findById(driver.getCategoryId());
        if (category.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(mapper.map(
                driverRepository.save(new Driver(
                        driver.getDni(),
                        driver.getName(),
                        driver.getAddress(),
                        driver.getEmail(),
                        category.get(),
                        null
                )),
                DriverDTO.class
        ));
    }

    @Override
    public Optional<DriverDTO> update(String dni, DriverSaveDTO newDriver) throws DataIntegrityViolationException {
        Optional<Category> category = categoryRepository.findById(newDriver.getCategoryId());
        if (category.isEmpty()) {
            return Optional.empty();
        }
        return driverRepository.findById(dni).map(driver -> {
            driver.setName(newDriver.getName());
            driver.setEmail(newDriver.getEmail());
            driver.setAddress(newDriver.getAddress());
            driver.setCategory(category.get());
            return mapper.map(driverRepository.save(driver), DriverDTO.class);
        });
    }

    @Override
    public Optional<DriverDTO> delete(String dni) {
        return driverRepository.findById(dni).map(driver -> {
            driverRepository.delete(driver);
            return mapper.map(driver, DriverDTO.class);
        });
    }
}
