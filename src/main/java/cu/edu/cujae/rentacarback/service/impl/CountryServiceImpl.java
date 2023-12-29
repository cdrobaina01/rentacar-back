package cu.edu.cujae.rentacarback.service.impl;

import cu.edu.cujae.rentacarback.dto.CountryDTO;
import cu.edu.cujae.rentacarback.dto.save.AuxiliarySaveDTO;
import cu.edu.cujae.rentacarback.model.Country;
import cu.edu.cujae.rentacarback.repository.CountryRepository;
import cu.edu.cujae.rentacarback.service.core.CountryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CountryServiceImpl implements CountryService {
    @Autowired
    private CountryRepository countryRepository;
    private final ModelMapper mapper = new ModelMapper();

    @Override
    public List<CountryDTO> findAll() {
        return countryRepository.findAll().stream()
                .map(country -> mapper.map(country, CountryDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<CountryDTO> findById(Integer id) {
        return countryRepository.findById(id).map(country -> mapper.map(country, CountryDTO.class));
    }

    @Override
    public Optional<CountryDTO> create(AuxiliarySaveDTO country) throws DataIntegrityViolationException {
        return Optional.of(mapper.map(
                countryRepository.save(new Country(null, country.getName(), null)),
                CountryDTO.class
        ));
    }

    @Override
    public Optional<CountryDTO> update(Integer id, AuxiliarySaveDTO newCountry) throws DataIntegrityViolationException {
        return countryRepository.findById(id).map(country -> {
            country.setName(newCountry.getName());
            return mapper.map(countryRepository.save(country), CountryDTO.class);
        });
    }

    @Override
    public Optional<CountryDTO> delete(Integer id) {
        return countryRepository.findById(id).map(country -> {
            countryRepository.delete(country);
            return mapper.map(country, CountryDTO.class);
        });
    }
}
