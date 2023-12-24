package cu.edu.cujae.rentacarback.service.impl;

import cu.edu.cujae.rentacarback.model.Gender;
import cu.edu.cujae.rentacarback.repository.GenderRepository;
import cu.edu.cujae.rentacarback.service.core.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenderServiceImpl implements GenderService {
    @Autowired
    private GenderRepository genderRepository;

    @Override
    public List<Gender> findAll() {
        return genderRepository.findAll();
    }

    @Override
    public Optional<Gender> findById(Integer id) {
        return genderRepository.findById(id);
    }

    @Override
    public Gender create(Gender gender) {
        return genderRepository.save(gender);
    }

    @Override
    public Optional<Gender> update(Integer id, Gender newGender) {
        return genderRepository.findById(id)
                .map(gender -> {
                    gender.setName(newGender.getName());
                    return genderRepository.save(gender);
                });
    }

    @Override
    public Optional<Gender> delete(Integer id) {
        return genderRepository.findById(id).map(gender -> {
            genderRepository.delete(gender);
            return gender;
        });
    }
}
