package cu.edu.cujae.rentacarback.service.impl;

import cu.edu.cujae.rentacarback.dto.GenderDTO;
import cu.edu.cujae.rentacarback.dto.save.AuxiliarySaveDTO;
import cu.edu.cujae.rentacarback.model.Gender;
import cu.edu.cujae.rentacarback.repository.GenderRepository;
import cu.edu.cujae.rentacarback.service.core.GenderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GenderServiceImpl implements GenderService {
    @Autowired
    private GenderRepository genderRepository;
    private final ModelMapper mapper = new ModelMapper();

    @Override
    public List<GenderDTO> findAll() {
        return genderRepository.findAll().stream()
                .map(gender -> mapper.map(gender, GenderDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<GenderDTO> findById(Integer id) {
        return genderRepository.findById(id).map(gender -> mapper.map(gender, GenderDTO.class));
    }

    @Override
    public Optional<GenderDTO> create(AuxiliarySaveDTO gender) throws DataIntegrityViolationException {
        return Optional.of(mapper.map(
                genderRepository.save(new Gender(null, gender.getName(), null)),
                GenderDTO.class
        ));
    }

    @Override
    public Optional<GenderDTO> update(Integer id, AuxiliarySaveDTO newGender) throws DataIntegrityViolationException {
        return genderRepository.findById(id).map(gender -> {
            gender.setName(newGender.getName());
            return mapper.map(genderRepository.save(gender), GenderDTO.class);
        });
    }

    @Override
    public Optional<GenderDTO> delete(Integer id) {
        return genderRepository.findById(id).map(gender -> {
            genderRepository.delete(gender);
            return mapper.map(gender, GenderDTO.class);
        });
    }
}
