package cu.edu.cujae.rentacarback.service.core;

import cu.edu.cujae.rentacarback.model.Contract;
import cu.edu.cujae.rentacarback.model.Driver;
import cu.edu.cujae.rentacarback.model.Tourist;

import java.time.LocalDate;

public interface EmailService {
    void sendEmail(String to, String subject, String body);
    void notifyContract(Contract contract);
}
