package controle;

import java.sql.Time;
import java.time.LocalDate;
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

	public static void enviarEmailContaCadastrada(String emailDestinatario) {
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
			message.setSubject("Bem-vinde ao IFSCarona! 🚗");
			message.setText("Olá,\n\n"
			        + "Seja bem-vinde à sua conta no IFSCarona! Estamos felizes por você fazer parte da nossa comunidade.\n"
			        + "Esperamos que aproveite ao máximo e faça bom uso do nosso sistema de caronas.\n\n"
			        + "Qualquer dúvida ou sugestão, sinta-se à vontade para entrar em contato.\n\n"
			        + "Tenha ótimas viagens!\n\n"
			        + "Atenciosamente,\n"
			        + "Equipe IFSCarona");


			Transport.send(message);
			System.out.println("Email enviado com sucesso para " + emailDestinatario);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
	
	public static void enviarEmailCaronaConfirmada(String emailDestinatario, String nome, String destino, LocalDate data, Time horario) {
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
	    	message.setSubject("Confirmação de carona");

	    	String mensagem = String.format("Olá,\n\n"
	    	    + "Boas notícias! O usuário %s aceitou sua carona para %s.\n"
	    	    + "A viagem está confirmada para o dia %s, às %s horas.\n"
	    	    + "Prepare-se para uma carona tranquila e agradável!\n\n"
	    	    + "Atenciosamente,\n"
	    	    + "Equipe IFSCarona", nome, destino, data, horario);

	    	message.setText(mensagem);


	        message.setText(mensagem);

	        Transport.send(message);
	        System.out.println("Email enviado com sucesso para " + emailDestinatario);
	    } catch (MessagingException e) {
	        e.printStackTrace();
	    }
	}

}
