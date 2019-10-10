package si.inspirited.registration.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationListener;
import org.springframework.context.MessageSource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import si.inspirited.persistence.model.User;
import si.inspirited.registration.OnRegistrationCompleteEvent;
import si.inspirited.service.IEmailService;
import si.inspirited.service.IUserService;

import java.util.UUID;

@Component
public class RegistrationListener implements ApplicationListener<OnRegistrationCompleteEvent> {
    @Autowired
    private IUserService service;
/*
    @Autowired
    private JavaMailSender mailSender;
*/
    @Qualifier("messageSource")
    @Autowired
    private MessageSource messages;

    @Autowired
    private Environment env;

    @Autowired
    private IEmailService emailService;



    // API

    @Override
    public void onApplicationEvent(final OnRegistrationCompleteEvent event) {
        this.confirmRegistration(event);
    }

    private void confirmRegistration(final OnRegistrationCompleteEvent event) {
        final User user = event.getUser();
        final String token = UUID.randomUUID().toString();
        service.createVerificationTokenForUser(user, token);

        emailService.constructAndSend(event, user, token);  //, messages.getMessage("email.registration.confirmation.subject", null, event.getLocale()));
 /*
        //System.setProperty("javax.net.ssl.trustStore","clientTrustStore.key");
        //System.setProperty("javax.net.ssl.trustStorePassword","qwerty");
        //mailSender.send(email);
        try {
            Transport.send(email);//msg);
        }catch (MessagingException me) {me.printStackTrace();}

 */
    }
}
