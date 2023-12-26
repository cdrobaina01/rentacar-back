package cu.edu.cujae.rentacarback.service.impl;

import cu.edu.cujae.rentacarback.dto.FeeDTO;
import cu.edu.cujae.rentacarback.dto.save.FeeSaveDTO;
import cu.edu.cujae.rentacarback.model.Fee;
import cu.edu.cujae.rentacarback.repository.FeeRepository;
import cu.edu.cujae.rentacarback.service.core.FeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FeeServiceImpl implements FeeService {
    @Autowired
    private FeeRepository feeRepository;
    private final ModelMapper mapper = new ModelMapper();

    @Override
    public List<FeeDTO> findAll() {
        return feeRepository.findAll().stream()
                .map(fee -> mapper.map(fee, FeeDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<FeeDTO> findById(Integer id) {
        return feeRepository.findById(id).map(fee -> mapper.map(fee, FeeDTO.class));
    }

    @Override
    public Optional<FeeDTO> create(FeeSaveDTO fee) throws DataIntegrityViolationException {
        return Optional.of(mapper.map(
                feeRepository.save(new Fee(null, fee.getName(), fee.getValue())),
                FeeDTO.class
        ));
    }

    @Override
    public Optional<FeeDTO> update(Integer id, FeeSaveDTO newFee) throws DataIntegrityViolationException {
        return feeRepository.findById(id).map(fee -> {
            fee.setName(newFee.getName());
            fee.setValue(newFee.getValue());
            return mapper.map(feeRepository.save(fee), FeeDTO.class);
        });
    }

    @Override
    public Optional<FeeDTO> delete(Integer id) {
        return feeRepository.findById(id).map(fee -> {
            feeRepository.delete(fee);
            return mapper.map(fee, FeeDTO.class);
        });
    }
}
