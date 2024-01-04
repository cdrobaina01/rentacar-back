package cu.edu.cujae.rentacarback.exceptions.notfound;

import java.lang.reflect.Field;
import java.util.List;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String entity, String key) {
        super("Could not find " + entity + " with key: " + key);
    }
}
