package cu.edu.cujae.rentacarback.exceptions;

public class UniqueValueException extends Exception {
    public UniqueValueException(String entity, String field) {
        super("The " + field + " value already exists in the " + entity + " table.");
    }
}
