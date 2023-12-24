package cu.edu.cujae.rentacarback.service.impl;

import cu.edu.cujae.rentacarback.model.Paymethod;
import cu.edu.cujae.rentacarback.repository.PaymethodRepository;
import cu.edu.cujae.rentacarback.service.core.PaymethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymethodServiceImpl implements PaymethodService {
    @Autowired
    private PaymethodRepository paymethodRepository;

    @Override
    public List<Paymethod> findAll() {
        return paymethodRepository.findAll();
    }

    @Override
    public Optional<Paymethod> findById(Integer id) {
        return paymethodRepository.findById(id);
    }

    @Override
    public Paymethod create(Paymethod paymethod) {
        return paymethodRepository.save(paymethod);
    }

    @Override
    public Optional<Paymethod> update(Integer id, Paymethod newPaymethod) {
        return paymethodRepository.findById(id)
                .map(paymethod -> {
                    paymethod.setName(newPaymethod.getName());
                    return paymethodRepository.save(paymethod);
                });
    }

    @Override
    public Optional<Paymethod> delete(Integer id) {
        return paymethodRepository.findById(id).map(paymethod -> {
            paymethodRepository.delete(paymethod);
            return paymethod;
        });
    }
}
