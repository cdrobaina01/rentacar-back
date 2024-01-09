package cu.edu.cujae.rentacarback.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String entity, String key) {
        super("Could not find " + entity + " with key: " + key);
    }
}
