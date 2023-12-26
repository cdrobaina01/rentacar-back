package cu.edu.cujae.rentacarback.service.impl;

import cu.edu.cujae.rentacarback.model.Country;
import cu.edu.cujae.rentacarback.repository.CountryRepository;
import cu.edu.cujae.rentacarback.service.core.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {
    @Autowired
    private CountryRepository countryRepository;

    @Override
    public List<Country> findAll() {
        return countryRepository.findAll();
    }

    @Override
    public Optional<Country> findById(Integer id) {
        return countryRepository.findById(id);
    }

    @Override
    public Country create(Country country) {
        return countryRepository.save(country);
    }

    @Override
    public Optional<Country> update(Integer id, Country newCountry) {
        return countryRepository.findById(id).map(country -> {
            country.setName(newCountry.getName());
            return countryRepository.save(country);
        });
    }

    @Override
    public Optional<Country> delete(Integer id) {
        return countryRepository.findById(id).map(country -> {
            countryRepository.delete(country);
            return country;
        });
    }
}
