package si.inspirited.service;

import si.inspirited.persistence.model.User;
import si.inspirited.registration.OnRegistrationCompleteEvent;

import javax.mail.Message;

public interface IEmailService {

    boolean constructAndSend(final String targetEmail, final String subject, final String text);
    boolean constructAndSend(final OnRegistrationCompleteEvent event, final User user, final String token);

    boolean sendMessage(Message message);

    Message constructEmailMessage(final String targetEmail, final String subject, final String text);
    Message constructEmailMessage(final OnRegistrationCompleteEvent event, final User user, final String token);
}
