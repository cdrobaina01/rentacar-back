package cu.edu.cujae.rentacarback.seeder;

import com.github.javafaker.Faker;
import cu.edu.cujae.rentacarback.model.Brand;
import cu.edu.cujae.rentacarback.model.Model;
import cu.edu.cujae.rentacarback.model.Paymethod;
import cu.edu.cujae.rentacarback.model.Tourist;
import cu.edu.cujae.rentacarback.repository.*;
import cu.edu.cujae.rentacarback.service.core.EmailService;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Arrays;


@Component
@Profile("dev")
public class DatabaseSeeder {
    @Autowired
    private BrandRepository brandRepository;
    @Autowired
    private ModelRepository modelRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private SituationRepository situationRepository;
    @Autowired
    private CountryRepository countryRepository;
    @Autowired
    private FeeRepository feeRepository;
    @Autowired
    private GenderRepository genderRepository;
    @Autowired
    private PaymethodRepository paymethodRepository;
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private DriverRepository driverRepository;
    @Autowired
    private TouristRepository touristRepository;
    @Autowired
    private ContractRepository contractRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    public void seed() {
        DataSets data = DataSets.instance();

        cleanDatabase();

        brandRepository.saveAll(data.brands());
        modelRepository.saveAll(data.models());
        categoryRepository.saveAll(data.categories());
        situationRepository.saveAll(data.situations());
        feeRepository.saveAll(data.fees());
        genderRepository.saveAll(data.genders());
        paymethodRepository.saveAll(data.paymethods());
        countryRepository.saveAll(data.countries());

        carRepository.saveAll(data.cars());
        driverRepository.saveAll(data.drivers());
        touristRepository.saveAll(data.tourists());
        contractRepository.saveAll(data.contracts());

        roleRepository.saveAll(data.roles());
        userRepository.saveAll(data.users());
    }

    public void cleanDatabase() {
        contractRepository.deleteAll();
        carRepository.deleteAll();
        driverRepository.deleteAll();
        touristRepository.deleteAll();
        modelRepository.deleteAll();
        brandRepository.deleteAll();
        categoryRepository.deleteAll();
        situationRepository.deleteAll();
        feeRepository.deleteAll();
        genderRepository.deleteAll();
        paymethodRepository.deleteAll();
        countryRepository.deleteAll();
        userRepository.deleteAll();
        roleRepository.deleteAll();
    }
}
