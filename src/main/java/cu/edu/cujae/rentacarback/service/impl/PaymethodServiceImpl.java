package cu.edu.cujae.rentacarback.service.impl;

import cu.edu.cujae.rentacarback.dto.PaymethodDTO;
import cu.edu.cujae.rentacarback.dto.save.AuxiliarySaveDTO;
import cu.edu.cujae.rentacarback.model.Paymethod;
import cu.edu.cujae.rentacarback.repository.PaymethodRepository;
import cu.edu.cujae.rentacarback.service.core.PaymethodService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PaymethodServiceImpl implements PaymethodService {
    @Autowired
    private PaymethodRepository paymethodRepository;
    private final ModelMapper mapper = new ModelMapper();

    @Override
    public List<PaymethodDTO> findAll() {
        return paymethodRepository.findAll().stream()
                .map(paymethod -> mapper.map(paymethod, PaymethodDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<PaymethodDTO> findById(Integer id) {
        return paymethodRepository.findById(id).map(paymethod -> mapper.map(paymethod, PaymethodDTO.class));
    }

    @Override
    public Optional<PaymethodDTO> create(AuxiliarySaveDTO paymethod) throws DataIntegrityViolationException {
        return Optional.of(mapper.map(
                paymethodRepository.save(new Paymethod(null, paymethod.getName(), null)),
                PaymethodDTO.class
        ));
    }

    @Override
    public Optional<PaymethodDTO> update(Integer id, AuxiliarySaveDTO newPaymethod) throws DataIntegrityViolationException {
        return paymethodRepository.findById(id)
                .map(paymethod -> {
                    paymethod.setName(newPaymethod.getName());
                    return mapper.map(paymethodRepository.save(paymethod), PaymethodDTO.class);
                });
    }

    @Override
    public Optional<PaymethodDTO> delete(Integer id) {
        return paymethodRepository.findById(id).map(paymethod -> {
            paymethodRepository.delete(paymethod);
            return mapper.map(paymethod, PaymethodDTO.class);
        });
    }
}
