package cu.edu.cujae.rentacarback.service;

import cu.edu.cujae.rentacarback.exceptions.UniqueValueException;
import cu.edu.cujae.rentacarback.model.Tourist;
import cu.edu.cujae.rentacarback.repository.TouristRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TouristService extends CrudService<Tourist, String> {
    private final TouristRepository repository;

    @Override
    protected String getEntityName() {
        return "Tourist";
    }

    @Override
    protected String getKeyName() {
        return "Passport";
    }

    @Override
    protected JpaRepository<Tourist, String> repository() {
        return repository;
    }

    @Override
    protected String getKey(Tourist tourist) {
        return tourist.getPassport();
    }

    @Override
    protected void validateExistingForeignKeys(Tourist tourist) throws UniqueValueException {

    }

    @Override
    protected Tourist updateData(Tourist tourist, Tourist data) {
        tourist.setAge(data.getAge());
        tourist.setName(data.getName());
        tourist.setEmail(data.getEmail());
        tourist.setCountry(data.getCountry());
        tourist.setPhone(data.getPhone());
        tourist.setGender(data.getGender());
        tourist.setPassport(tourist.getPassport());
        return tourist;
    }
}
