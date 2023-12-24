package cu.edu.cujae.rentacarback.service.impl;

import cu.edu.cujae.rentacarback.model.Situation;
import cu.edu.cujae.rentacarback.repository.SituationRepository;
import cu.edu.cujae.rentacarback.service.core.SituationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SituationServiceImpl implements SituationService {
    @Autowired
    private SituationRepository situationRepository;

    @Override
    public List<Situation> findAll() {
        return situationRepository.findAll();
    }

    @Override
    public Optional<Situation> findById(Integer id) {
        return situationRepository.findById(id);
    }

    @Override
    public Situation create(Situation situation) {
        return situationRepository.save(situation);
    }

    @Override
    public Optional<Situation> update(Integer id, Situation newSituation) {
        return situationRepository.findById(id)
                .map(situation -> {
                    situation.setName(newSituation.getName());
                    return situationRepository.save(situation);
                });
    }

    @Override
    public Optional<Situation> delete(Integer id) {
        return situationRepository.findById(id).map(situation -> {
            situationRepository.delete(situation);
            return situation;
        });
    }
}
