package cu.edu.cujae.rentacarback.service.impl;

import cu.edu.cujae.rentacarback.model.Contract;
import cu.edu.cujae.rentacarback.model.ContractPK;
import cu.edu.cujae.rentacarback.repository.ContractRepository;
import cu.edu.cujae.rentacarback.service.core.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContractServiceImpl implements ContractService {
    @Autowired
    private ContractRepository contractRepository;

    @Override
    public List<Contract> findAll() {
        return contractRepository.findAll();
    }

    @Override
    public Optional<Contract> findById(ContractPK pk) {
        return contractRepository.findById(pk);
    }

    @Override
    public Contract create(Contract contract) {
        return contractRepository.save(contract);
    }

    @Override
    public Optional<Contract> update(ContractPK pk, Contract newContract) {
        return contractRepository.findById(pk).map(contract -> {
            contract.setDriver(newContract.getDriver());
            contract.setPaymethod(newContract.getPaymethod());
            contract.setEndKm(newContract.getEndKm());
            contract.setEndDate(newContract.getEndDate());
            contract.setValue(newContract.getValue());
            contract.setTourist(newContract.getTourist());
            contract.setDeliveryDate(newContract.getDeliveryDate());
            contract.setStartKm(newContract.getStartKm());
            return contractRepository.save(contract);
        });
    }

    @Override
    public Optional<Contract> delete(ContractPK pk) {
        return contractRepository.findById(pk).map(contract -> {
            contractRepository.delete(contract);
            return contract;
        });
    }
}
