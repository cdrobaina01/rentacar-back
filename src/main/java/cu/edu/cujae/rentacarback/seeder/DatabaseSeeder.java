package cu.edu.cujae.rentacarback.seeder;

import com.github.javafaker.Faker;
import cu.edu.cujae.rentacarback.model.Brand;
import cu.edu.cujae.rentacarback.model.Model;
import cu.edu.cujae.rentacarback.repository.BrandRepository;
import cu.edu.cujae.rentacarback.repository.ModelRepository;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Random;

import static cu.edu.cujae.rentacarback.seeder.DataSets.*;

@Component
@Profile("dev")
public class DatabaseSeeder {
    @Autowired
    private BrandRepository brandRepository;
    @Autowired
    private ModelRepository modelRepository;

    private Faker faker;

    @PostConstruct
    public void seed() {
        faker = new Faker(new Random(1));
        cleanDatabase();

        brandRepository.saveAll(Arrays.asList(brands));
        modelRepository.saveAll(Arrays.asList(models));
    }

    public void cleanDatabase() {
        modelRepository.deleteAll();
        brandRepository.deleteAll();
    }
}
