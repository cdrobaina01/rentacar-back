package cu.edu.cujae.rentacarback.service;

import cu.edu.cujae.rentacarback.model.Contract;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {
    private final JavaMailSender mailSender;

    public void sendEmail(String to, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);

        mailSender.send(message);
    }

    public void notifyContract(Contract contract) {
        SimpleMailMessage driverNotification = new SimpleMailMessage();
        SimpleMailMessage touristNotification = new SimpleMailMessage();

        driverNotification.setTo(contract.getDriver().getEmail());
        driverNotification.setSubject("New Contract!");
        driverNotification.setText(
                "You has been assigned to a new Contract, starting on " + contract.getStartDate().toString() + ", "
                        + "until " + contract.getEndDate().toString() + ".\n"
                        + "The selected car is the " + contract.getCar().getModel().getBrand().getName() + " "
                        + contract.getCar().getModel().getName() + " with plate " + contract.getCar().getPlate() + "."
        );

        touristNotification.setTo(contract.getTourist().getEmail());
        touristNotification.setSubject("Signed Contract with Rider: Rent the Bests Cars");
        touristNotification.setText("You can check your contract details at: ");

        mailSender.send(driverNotification);
        mailSender.send(touristNotification);
    }
}
