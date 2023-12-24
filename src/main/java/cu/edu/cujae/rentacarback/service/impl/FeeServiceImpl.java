package cu.edu.cujae.rentacarback.service.impl;

import cu.edu.cujae.rentacarback.model.Fee;
import cu.edu.cujae.rentacarback.repository.FeeRepository;
import cu.edu.cujae.rentacarback.service.core.FeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FeeServiceImpl implements FeeService {
    @Autowired
    private FeeRepository feeRepository;

    @Override
    public List<Fee> findAll() {
        return feeRepository.findAll();
    }

    @Override
    public Optional<Fee> findById(Integer id) {
        return feeRepository.findById(id);
    }

    @Override
    public Fee create(Fee fee) {
        return feeRepository.save(fee);
    }

    @Override
    public Optional<Fee> update(Integer id, Fee newFee) {
        return feeRepository.findById(id)
                .map(fee -> {
                    fee.setName(newFee.getName());
                    return feeRepository.save(fee);
                });
    }

    @Override
    public Optional<Fee> delete(Integer id) {
        return feeRepository.findById(id).map(fee -> {
            feeRepository.delete(fee);
            return fee;
        });
    }
}
