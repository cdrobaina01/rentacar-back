package cu.edu.cujae.rentacarback.service.impl;

import cu.edu.cujae.rentacarback.dto.ContractDTO;
import cu.edu.cujae.rentacarback.dto.save.ContractSaveDTO;
import cu.edu.cujae.rentacarback.model.*;
import cu.edu.cujae.rentacarback.repository.*;
import cu.edu.cujae.rentacarback.service.core.ContractService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ContractServiceImpl implements ContractService {
    @Autowired
    private ContractRepository contractRepository;
    private final ModelMapper mapper = new ModelMapper();

    @Autowired
    private CarRepository carRepository;
    @Autowired
    private TouristRepository touristRepository;
    @Autowired
    private DriverRepository driverRepository;
    @Autowired
    private PaymethodRepository paymethodRepository;

    @Override
    public List<ContractDTO> findAll() {
        return contractRepository.findAll().stream()
                .map(contract -> mapper.map(contract, ContractDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ContractDTO> findById(ContractPK pk) {
        return contractRepository.findById(pk).map(contract -> mapper.map(contract, ContractDTO.class));
    }

    @Override
    public Optional<ContractDTO> create(ContractSaveDTO contract) throws DataIntegrityViolationException {
        Optional<Car> car = carRepository.findById(contract.getCarPlate());
        Optional<Tourist> tourist = touristRepository.findById(contract.getTouristPassport());
        Optional<Driver> driver = driverRepository.findById(contract.getDriverDni());
        Optional<Paymethod> paymethod = paymethodRepository.findById(contract.getPaymethodId());
        if ((car.isEmpty() || tourist.isEmpty()) || (driver.isEmpty() || paymethod.isEmpty())) {
            return Optional.empty();
        }
        return Optional.of(mapper.map(
                contractRepository.save(new Contract(
                        car.get(),
                        contract.getStartDate(),
                        tourist.get(),
                        contract.getEndDate(),
                        contract.getStartKm(),
                        contract.getDeliveryDate(),
                        contract.getEndKm(),
                        paymethod.get(),
                        driver.get(),
                        contract.getValue()
                )),
                ContractDTO.class
        ));
    }

    @Override
    public Optional<ContractDTO> update(ContractPK pk, ContractSaveDTO newContract) throws DataIntegrityViolationException {
        Optional<Tourist> tourist = touristRepository.findById(newContract.getTouristPassport());
        Optional<Driver> driver = driverRepository.findById(newContract.getDriverDni());
        Optional<Paymethod> paymethod = paymethodRepository.findById(newContract.getPaymethodId());
        if (tourist.isEmpty() || (driver.isEmpty() || paymethod.isEmpty())) {
            return Optional.empty();
        }
        return contractRepository.findById(pk).map(contract -> {
            contract.setDriver(driver.get());
            contract.setPaymethod(paymethod.get());
            contract.setEndKm(newContract.getEndKm());
            contract.setEndDate(newContract.getEndDate());
            contract.setValue(newContract.getValue());
            contract.setTourist(tourist.get());
            contract.setDeliveryDate(newContract.getDeliveryDate());
            contract.setStartKm(newContract.getStartKm());
            return mapper.map(contractRepository.save(contract), ContractDTO.class);
        });
    }

    @Override
    public Optional<ContractDTO> delete(ContractPK pk) {
        return contractRepository.findById(pk).map(contract -> {
            contractRepository.delete(contract);
            return mapper.map(contract, ContractDTO.class);
        });
    }
}
