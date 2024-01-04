package cu.edu.cujae.rentacarback.exceptions.advices;

import cu.edu.cujae.rentacarback.exceptions.UniqueValueException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class UniqueValueAdvice {
    @ResponseBody
    @ExceptionHandler(UniqueValueException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String uniqueValueHandler(UniqueValueException exception) {
        return exception.getMessage();
    }

}
