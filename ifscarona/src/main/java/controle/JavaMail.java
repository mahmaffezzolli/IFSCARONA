package controle;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class JavaMail {

	public static void enviarEmail(String emailDestinatario) {
        String meuEmail = "ifscarona@gmail.com";
        String appPassword = "bupl gqqy xgcv qawy";
        
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        properties.put("mail.smtp.ssl.protocols", "TLSv1.2");

        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(meuEmail, appPassword);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(meuEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailDestinatario));
            message.setSubject("Seja bem vinde a sua conta no IFSCarona");
            message.setText("Email");

            Transport.send(message);
            System.out.println("Email enviado com sucesso para " + emailDestinatario);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
