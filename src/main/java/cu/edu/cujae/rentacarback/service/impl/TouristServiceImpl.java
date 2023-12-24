package cu.edu.cujae.rentacarback.service.impl;

import cu.edu.cujae.rentacarback.model.Tourist;
import cu.edu.cujae.rentacarback.repository.TouristRepository;
import cu.edu.cujae.rentacarback.service.core.TouristService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TouristServiceImpl implements TouristService {
    @Autowired
    private TouristRepository touristRepository;

    @Override
    public List<Tourist> findAll() {
        return touristRepository.findAll();
    }

    @Override
    public Optional<Tourist> findById(String passport) {
        return touristRepository.findById(passport);
    }

    @Override
    public Tourist create(Tourist tourist) {
        return touristRepository.save(tourist);
    }

    @Override
    public Optional<Tourist> update(String passport, Tourist newTourist) {
        return touristRepository.findById(passport)
                .map(tourist -> {
                    tourist.setName(newTourist.getName());
                    tourist.setAge(newTourist.getAge());
                    tourist.setEmail(newTourist.getEmail());
                    tourist.setGender(newTourist.getGender());
                    tourist.setPhone(newTourist.getPhone());
                    tourist.setCountry(newTourist.getCountry());
                    return touristRepository.save(tourist);
                });
    }

    @Override
    public Optional<Tourist> delete(String passport) {
        return touristRepository.findById(passport).map(tourist -> {
            touristRepository.delete(tourist);
            return tourist;
        });
    }
}
