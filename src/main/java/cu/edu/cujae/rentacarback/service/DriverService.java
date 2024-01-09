package cu.edu.cujae.rentacarback.service;

import cu.edu.cujae.rentacarback.exceptions.UniqueValueException;
import cu.edu.cujae.rentacarback.model.Driver;
import cu.edu.cujae.rentacarback.repository.DriverRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DriverService extends CrudService<Driver, String> {
    private final DriverRepository repository;

    @Override
    protected String getEntityName() {
        return "Driver";
    }

    @Override
    protected String getKeyName() {
        return "DNI";
    }

    @Override
    protected JpaRepository<Driver, String> repository() {
        return repository;
    }

    @Override
    protected String getKey(Driver driver) {
        return driver.getDni();
    }

    @Override
    protected void validateExistingForeignKeys(Driver driver) throws UniqueValueException {

    }

    @Override
    protected Driver updateData(Driver driver, Driver data) {
        driver.setName(data.getName());
        driver.setAddress(data.getAddress());
        driver.setEmail(data.getEmail());
        driver.setCategory(data.getCategory());
        return driver;
    }
}
