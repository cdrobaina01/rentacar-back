package cu.edu.cujae.rentacarback.service.impl;

import cu.edu.cujae.rentacarback.dto.TouristDTO;
import cu.edu.cujae.rentacarback.dto.save.TouristSaveDTO;
import cu.edu.cujae.rentacarback.model.Tourist;
import cu.edu.cujae.rentacarback.repository.TouristRepository;
import cu.edu.cujae.rentacarback.service.core.TouristService;
import cu.edu.cujae.rentacarback.utils.TouristGender;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TouristServiceImpl implements TouristService {
    @Autowired
    private TouristRepository touristRepository;
    private final ModelMapper mapper = new ModelMapper();

    @Override
    public List<TouristDTO> findAll() {
        return touristRepository.findAll().stream()
                .map(tourist -> mapper.map(tourist, TouristDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<TouristDTO> findById(String passport) {
        return touristRepository.findById(passport).map(tourist -> mapper.map(tourist, TouristDTO.class));
    }

    @Override
    public Optional<TouristDTO> create(TouristSaveDTO tourist) throws DataIntegrityViolationException {
        return Optional.of(mapper.map(
                touristRepository.save(new Tourist(
                        tourist.getPassport(),
                        tourist.getName(),
                        tourist.getAge(),
                        tourist.getPhone(),
                        tourist.getEmail(),
                        TouristGender.OTHER,
                        "USA",
                        null
                )),
                TouristDTO.class
        ));
    }

    @Override
    public Optional<TouristDTO> update(String passport, TouristSaveDTO newTourist) throws DataIntegrityViolationException {
        return touristRepository.findById(passport).map(tourist -> {
            tourist.setName(newTourist.getName());
            tourist.setAge(newTourist.getAge());
            tourist.setEmail(newTourist.getEmail());
            tourist.setPhone(newTourist.getPhone());
            return mapper.map(touristRepository.save(tourist), TouristDTO.class);
        });
    }

    @Override
    public Optional<TouristDTO> delete(String passport) {
        return touristRepository.findById(passport).map(tourist -> {
            touristRepository.delete(tourist);
            return mapper.map(tourist, TouristDTO.class);
        });
    }
}
