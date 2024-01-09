package cu.edu.cujae.rentacarback.service;

import cu.edu.cujae.rentacarback.exceptions.UniqueValueException;
import cu.edu.cujae.rentacarback.model.Fee;
import cu.edu.cujae.rentacarback.repository.FeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FeeService extends CrudService<Fee, Integer> {
    private final FeeRepository repository;

    @Override
    protected String getEntityName() {
        return "Fee";
    }

    @Override
    protected JpaRepository<Fee, Integer> repository() {
        return repository;
    }

    @Override
    protected void validateKeys(Fee fee) throws UniqueValueException {
        repository.findByName(fee.getName()).orElseThrow(uniqueValueException("Name"));
    }

    @Override
    protected Fee updateData(Fee fee, Fee data) {
        fee.setName(fee.getName());
        fee.setValue(fee.getValue());
        return fee;
    }

    public Fee getRegularFee() {
        return repository.findByName("Regular").orElseThrow();
    }

    public Fee getOverdueFee() {
        return repository.findByName("Overdue").orElseThrow();
    }
}