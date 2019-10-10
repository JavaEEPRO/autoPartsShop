package si.inspirited.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import si.inspirited.persistence.model.User;
import si.inspirited.registration.OnRegistrationCompleteEvent;
import si.inspirited.service.IEmailService;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Date;
import java.util.Properties;

@Service
public class EmailService implements IEmailService {

    @Autowired
    private Environment env;

    @Qualifier("messageSource")
    @Autowired
    private MessageSource messages;

    public boolean constructAndSend(final String targetEmail, final String subject, final String text) {
        Message msg = constructEmailMessage(targetEmail, subject, text);

        return sendMessage(msg);
    }

    public boolean constructAndSend(final OnRegistrationCompleteEvent event, final User user, final String token) {
        Message msg = constructEmailMessage(event, user, token);

        return sendMessage(msg);
    }

    public boolean sendMessage(Message message) {

        boolean res = false;

        try {
            Transport.send(message);
            res = true;
        }catch (MessagingException me) {me.printStackTrace();}

        return res;
    }

    public final Message constructEmailMessage(final String targetEmail, final String subject, final String text) {
        //final String recipientAddress = user.getEmail();
        //final String subject = subject;
        final String content = text;
        //final String message = messages.getMessage("message.regSucc", null, event.getLocale());
        //final SimpleMailMessage email = new SimpleMailMessage();
        //email.setTo(recipientAddress);
        //email.setText(message + " \r\n" + confirmationUrl);
        //email.setSubject(subject);
        //email.setFrom(env.getProperty("support.email"));
        //my custom mail service)))

        Properties props = new Properties();
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        props.put("mail.smtp.auth", env.getProperty("mail.smtp.auth")); //"true");
        props.put("mail.smtp.port", env.getProperty("mail.smtp.port")); //"587");
        props.put("mail.smtp.starttls.enable", env.getProperty("mail.smtp.starttls.enable")); //"true");
        props.put("mail.smtp.host", env.getProperty("mail.smtp.host")); //"smtp.gmail.com");

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(env.getProperty("spring.mail.username"), env.getProperty("spring.mail.password"));
            }
        });

        Message msg = new MimeMessage(session);

        try {
            msg.setFrom(new InternetAddress(env.getProperty("support.email"), false));
            msg.setSubject(subject);
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(targetEmail));
            //msg.setContent(content, "text/html");
            msg.setSentDate(new Date());

            MimeBodyPart messageBodyPart = new MimeBodyPart();

            Multipart multipart = new MimeMultipart();
            messageBodyPart.setContent(content, "text/html; charset=UTF-8");
            messageBodyPart.setHeader("Content-Type", "text/plain; charset=UTF-8");
            multipart.addBodyPart(messageBodyPart);
            //MimeBodyPart attachPart = new MimeBodyPart();
            //multipart.addBodyPart(attachPart);
            //attachPart.attachFile("/var/tmp/image19.png");

            msg.setContent(multipart);
        }catch (Exception e) {e.printStackTrace();}
        //end of my custom mail svc
        return msg;//email;
    }

    public Message constructEmailMessage(final OnRegistrationCompleteEvent event, final User user, final String token) {
        //final String recipientAddress = user.getEmail();
        final String subject = messages.getMessage("email.registration.confirmation.subject", null, event.getLocale());
        final String explaination = messages.getMessage("email.registration.confirmation.explaination", null, event.getLocale());

        final String confirmationUrl = event.getAppUrl() + "/registrationConfirm.html?token=" + token;
        //final String message = messages.getMessage("message.regSucc", null, event.getLocale());
        //final SimpleMailMessage email = new SimpleMailMessage();
        //email.setTo(recipientAddress);
        //email.setSubject(subject);
        //email.setText(message + " \r\n" + confirmationUrl);
        //email.setFrom(env.getProperty("support.email"));

        //my custom mail service)))

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        //props.put("mail.mime.charset", "UTF-8");

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(env.getProperty("spring.mail.username"), env.getProperty("spring.mail.password"));
            }
        });
        Message msg = new MimeMessage(session);
        try {
            msg.setFrom(new InternetAddress(env.getProperty("support.email"), false));

            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(user.getEmail()));
            msg.setSubject(subject);
            //msg.setContent(confirmationUrl, "text/html");
            msg.setSentDate(new Date());

            MimeBodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setContent(explaination + " " + confirmationUrl, "text/html; charset=UTF-8");
            //messageBodyPart.setHeader("Content-Type", "text/plain; charset=UTF-8");

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);
            //MimeBodyPart attachPart = new MimeBodyPart();

            //attachPart.attachFile("/var/tmp/image19.png");
            //multipart.addBodyPart(attachPart);
            msg.setContent(multipart);

        }catch (Exception e) {e.printStackTrace();}
        //end of my custom mail svc
        return msg;//email;
    }

}
