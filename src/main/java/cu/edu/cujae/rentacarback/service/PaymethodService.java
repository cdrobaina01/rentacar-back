package cu.edu.cujae.rentacarback.service;

import cu.edu.cujae.rentacarback.exceptions.UniqueValueException;
import cu.edu.cujae.rentacarback.model.Brand;
import cu.edu.cujae.rentacarback.model.Paymethod;
import cu.edu.cujae.rentacarback.repository.PaymethodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymethodService extends CrudService<Paymethod, Integer> {
    private final PaymethodRepository repository;

    @Override
    protected String getEntityName() {
        return "Paymethod";
    }

    @Override
    protected String getKeyName() {
        return "Name";
    }

    @Override
    protected JpaRepository<Paymethod, Integer> repository() {
        return repository;
    }

    @Override
    protected Integer getKey(Paymethod paymethod) {
        return paymethod.getId();
    }

    @Override
    protected void validateExistingForeignKeys(Paymethod paymethod) throws UniqueValueException {

    }

    @Override
    protected Paymethod updateData(Paymethod paymethod, Paymethod data) {
        paymethod.setName(data.getName());
        return paymethod;
    }

    @Override
    protected void validateAvailableKey(Paymethod paymethod) throws UniqueValueException {
        if (repository.findByName(paymethod.getName()).isPresent()) {
            throw new UniqueValueException(getEntityName(), getKeyName());
        }
    }
}
