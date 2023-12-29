package cu.edu.cujae.rentacarback.service.impl;

import cu.edu.cujae.rentacarback.dto.SituationDTO;
import cu.edu.cujae.rentacarback.dto.save.AuxiliarySaveDTO;
import cu.edu.cujae.rentacarback.model.Situation;
import cu.edu.cujae.rentacarback.repository.SituationRepository;
import cu.edu.cujae.rentacarback.service.core.SituationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SituationServiceImpl implements SituationService {
    @Autowired
    private SituationRepository situationRepository;
    private final ModelMapper mapper = new ModelMapper();

    @Override
    public List<SituationDTO> findAll() {
        return situationRepository.findAll().stream()
                .map(situation -> mapper.map(situation, SituationDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<SituationDTO> findById(Integer id) {
        return situationRepository.findById(id).map(situation -> mapper.map(situation, SituationDTO.class));
    }

    @Override
    public Optional<SituationDTO> create(AuxiliarySaveDTO situation) throws DataIntegrityViolationException {
        return Optional.of(mapper.map(
                situationRepository.save(new Situation(null, situation.getName(), null)),
                SituationDTO.class
        ));
    }

    @Override
    public Optional<SituationDTO> update(Integer id, AuxiliarySaveDTO newSituation) throws DataIntegrityViolationException {
        return situationRepository.findById(id)
                .map(situation -> {
                    situation.setName(newSituation.getName());
                    return mapper.map(situationRepository.save(situation), SituationDTO.class);
                });
    }

    @Override
    public Optional<SituationDTO> delete(Integer id) {
        return situationRepository.findById(id).map(situation -> {
            situationRepository.delete(situation);
            return mapper.map(situation, SituationDTO.class);
        });
    }
}
