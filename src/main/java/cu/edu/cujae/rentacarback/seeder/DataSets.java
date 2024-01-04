package cu.edu.cujae.rentacarback.seeder;

import com.github.javafaker.Faker;
import cu.edu.cujae.rentacarback.model.*;
import cu.edu.cujae.rentacarback.utils.CarSituation;
import cu.edu.cujae.rentacarback.utils.DriverCategory;
import cu.edu.cujae.rentacarback.utils.TouristGender;
import org.springframework.dao.DataIntegrityViolationException;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class DataSets {
    private final Faker faker;
    private static DataSets instance;
    private final List<Car> cars;
    private final List<Driver> drivers;
    private final List<Tourist> tourists;
    private final List<Contract> contracts;
    private final List<Country> countries;
    private final List<User> users;
    private final Brand[] brands = {
            new Brand(null, "Kia", null),
            new Brand(null, "Hyundai", null),
            new Brand(null, "VW", null),
    };
    private final Model[] models = {
            new Model(null, "Acer", brands[1], null),
            new Model(null, "Atos", brands[1], null),
            new Model(null, "Sportage", brands[0], null),
    };
    private final Fee[] fees = {
            new Fee(null, "Regular", 15.0),
            new Fee(null, "Overdue", 30.0),
    };
    private final Paymethod[] paymethods = {
            new Paymethod(null, "Cash", null),
            new Paymethod(null, "Credit", null),
    };
    private final Role[] roles = {
            new Role("ROLE_ADMIN", "Administrator", null),
            new Role("ROLE_USER", "Regular Worker", null),
            new Role("ROLE_CLIENT", "Tourist Client", null),
            new Role("ROLE_DRIVER", "Driver Worker", null),
    };

    private DataSets() {
        faker = Faker.instance();
        cars = new LinkedList<>();
        drivers = new LinkedList<>();
        tourists = new LinkedList<>();
        contracts = new LinkedList<>();
        countries = countryGenerator();
        users = new ArrayList<>();
        users.add(new User("admin", "cdrobayna01@gmail.com",
                "$2a$12$Fp0.9ip8awWNBin025evqelhKmMAuMPE4SeluHhV1vD3pN1ACegTe", // admin
                faker.name().fullName(), roles[0]));
        users.add(new User("driver", "cdrobayna01@gmail.com",
                "$2a$12$WSJZqM6neAfR1LFSRASuw.hPE2REBY3QwZYQWxCkP8KzI.PGEUEUO", // driver
                faker.name().fullName(), roles[3]));
        users.add(new User("user", "cdrobayna01@gmail.com",
                "$2a$12$g4yHbyqAooSmX5fthYxg.uV6bVyTTKUvSqbl1S1RLNBtUg2dIKXZm", // user
                faker.name().fullName(), roles[1]));

        for (int i = 0; i < 10; i++) {
            cars.add(new Car(faker.regexify("T\\d{6}"), faker.number().numberBetween(150, 1500), faker.color().hex(),
                    CarSituation.READY, models[randIndex(models.length)], null));
            drivers.add(new Driver(faker.regexify("\\d{2}(0[1-9]|1[0-2])(0[1-9]|1[0-9]|2[0-8])\\d{5}"),
                    faker.name().fullName(), faker.address().fullAddress(),
                    faker.internet().emailAddress(), DriverCategory.B, null));
            tourists.add(new Tourist(faker.regexify("[A-Z]{2}\\d{5}"), faker.name().fullName(),
                    faker.number().numberBetween(18, 100), faker.phoneNumber().cellPhone(),
                    faker.internet().emailAddress(), TouristGender.OTHER,
                    countries.get(randIndex(countries.size())), null));
            contracts.add(contractGenerator());
        }
    }

    public static DataSets instance() {
        if (instance == null) {
            instance = new DataSets();
        }
        return instance;
    }

    private int randIndex(int index) {
        return faker.number().numberBetween(0, index - 1);
    }

    private List<Country> countryGenerator() {
        List<String> names = new ArrayList<>();
        int count = 0;
        while (count < 20) {
            String countryName = faker.country().name();
            if (names.contains(countryName)) {
                continue;
            }
            names.add(countryName);
            count++;
        }

        return names.stream().map(s -> new Country(null, s, null)).collect(Collectors.toList());
    }

    private Contract contractGenerator() {
        Date startDate = faker.date().birthday();
        Date deliveryDate = faker.date().future(365, TimeUnit.DAYS, startDate);
        Date endDate = faker.date().between(startDate, deliveryDate);
        LocalDate startLocalDate = startDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate deliveryLocalDate = deliveryDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate endLocalDate = endDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        Car car = cars.get(randIndex(cars.size()));
        Integer endKm = faker.number().numberBetween(car.getKm(), car.getKm() + 1500);
        Double value = (fees[0].getValue() * startLocalDate.until(endLocalDate, ChronoUnit.DAYS))
                + (fees[1].getValue() * endLocalDate.until(deliveryLocalDate, ChronoUnit.DAYS));
        return new Contract(car, startLocalDate,
                tourists.get(randIndex(tourists.size())), startLocalDate, car.getKm(), deliveryLocalDate, endKm,
                paymethods[randIndex(paymethods.length)], drivers.get(randIndex(drivers.size())), value
        );
    }

    public List<Brand> brands() {
        return Arrays.asList(brands);
    }
    public List<Model> models() {
        return Arrays.asList(models);
    }
    public List<Fee> fees() {
        return Arrays.asList(fees);
    }
    public List<Country> countries() {
        return countries;
    }
    public List<Paymethod> paymethods() {
        return Arrays.asList(paymethods);
    }

    public List<Role> roles(){
        return Arrays.asList(roles);
    }
    public List<User> users() {
        return users;
    }

    public List<Car> cars() {
        return cars;
    }
    public List<Driver> drivers() {
        return drivers;
    }
    public List<Tourist> tourists() {
        return tourists;
    }
    public List<Contract> contracts() {
        return contracts;
    }
}
