package cu.edu.cujae.rentacarback.seeder;

import cu.edu.cujae.rentacarback.model.Brand;
import cu.edu.cujae.rentacarback.model.Model;

public class DataSets {
    public static Brand[] brands = {
            new Brand(null, "Mercedes", null),
            new Brand(null, "Audi", null),
            new Brand(null, "BMW", null)
    };
    public static Model[] models = {
            new Model(null, "A4", brands[1], null),
            new Model(null, "A6", brands[1], null),
            new Model(null, "S350", brands[0], null),
    };
}
