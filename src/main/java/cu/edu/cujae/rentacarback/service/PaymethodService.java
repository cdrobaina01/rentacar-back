package cu.edu.cujae.rentacarback.service;

import cu.edu.cujae.rentacarback.exceptions.UniqueValueException;
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
    protected JpaRepository<Paymethod, Integer> repository() {
        return repository;
    }

    @Override
    protected void validateKeys(Paymethod paymethod) throws UniqueValueException {
        repository.findByName(paymethod.getName()).orElseThrow(uniqueValueException("Name"));
    }

    @Override
    protected Paymethod updateData(Paymethod paymethod, Paymethod data) {
        paymethod.setName(data.getName());
        return paymethod;
    }
}
