package cu.edu.cujae.rentacarback.service;

import cu.edu.cujae.rentacarback.exceptions.UniqueValueException;
import cu.edu.cujae.rentacarback.model.Car;
import cu.edu.cujae.rentacarback.model.Contract;
import cu.edu.cujae.rentacarback.model.ContractPK;
import cu.edu.cujae.rentacarback.repository.ContractRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;

@Service
@RequiredArgsConstructor
public class ContractService extends CrudService<Contract, ContractPK> {
    private final ContractRepository repository;
    private final TouristService touristService;
    private final DriverService driverService;
    private final CarService carService;
    private final FeeService feeService;

    private final EmailService emailService;

    @Override
    protected String getEntityName() {
        return "Contract";
    }

    @Override
    protected String getKeyName() {
        return "Car + Start Date";
    }

    @Override
    protected JpaRepository<Contract, ContractPK> repository() {
        return repository;
    }

    @Override
    protected ContractPK getKey(Contract contract) {
        return new ContractPK(contract.getCar().getPlate(), contract.getStartDate());
    }

    @Override
    protected void validateExistingForeignKeys(Contract contract) throws UniqueValueException {
        carService.findById(contract.getCar().getPlate());
        touristService.findById(contract.getTourist().getPassport());
        if (contract.getDriver() != null)
            driverService.findById(contract.getDriver().getDni());
    }

    @Override
    protected Contract updateData(Contract contract, Contract data) {
        contract.setTourist(data.getTourist());
        contract.setEndDate(data.getEndDate());
        contract.setStartKm(data.getStartKm());
        contract.setDeliveryDate(data.getDeliveryDate());
        contract.setEndKm(data.getEndKm());
        contract.setPaymethod(data.getPaymethod());
        contract.setDriver(data.getDriver());
        calculateValue(contract);
        return contract;
    }

    public Contract open(Contract data) throws UniqueValueException {
        validateAvailableKey(data);
        validateExistingForeignKeys(data);
        Contract contract = new Contract();
        contract.setCar(data.getCar());
        contract.setStartDate(data.getStartDate());
        contract.setTourist(data.getTourist());
        contract.setEndDate(data.getEndDate());
        contract.setStartKm(data.getCar().getKm());
        contract.setPaymethod(data.getPaymethod());
        contract.setDriver(data.getDriver());
        calculateValue(contract);

        emailService.notifyContract(contract);

        return repository.save(contract);
    }

    public Contract close(ContractPK key, Contract data) throws UniqueValueException {
        validateExistingForeignKeys(data);
        Contract contract = findById(key);
        contract.setDeliveryDate(data.getDeliveryDate());
        contract.setEndKm(data.getEndKm());
        calculateValue(contract);

        Car car = contract.getCar();
        car.setKm(contract.getEndKm());
        carService.update(car.getPlate(), car);

        return repository.save(contract);
    }

    private void calculateValue(Contract contract) {
        Integer regularDays = Math.toIntExact(contract.getStartDate().until(contract.getEndDate(), ChronoUnit.DAYS));
        int overdueDays = 0;
        if (contract.getDeliveryDate() != null) {
            overdueDays = Math.toIntExact(contract.getEndDate().until(contract.getDeliveryDate(), ChronoUnit.DAYS));
        }
        Double regularFee = feeService.getRegularFee().getValue();
        Double overdueFee = feeService.getOverdueFee().getValue();
        contract.setValue(regularDays * regularFee + (overdueDays > 0 ? overdueDays * overdueFee : 0));
    }
}
