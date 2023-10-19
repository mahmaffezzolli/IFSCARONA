package controle;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class JavaMail {

	public static void sendEmail(String recebe) throws Exception {

		Properties properties = new Properties();
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");

		String meuEmail = "xxx";
		String senha = "xxx";

		Session session = Session.getInstance(properties, new Authenticator() {

			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(meuEmail, senha);

			}
		});

		Message mensagem = prepararMensagem(session, meuEmail, recebe);

		Transport.send(mensagem);
		System.out.println("Email enviado");
	}

	private static Message prepararMensagem(Session session, String meuEmail, String recebe) throws Exception {

		try {
			Message mensagem = new MimeMessage(session);
			mensagem.setFrom(new InternetAddress(meuEmail));
			mensagem.setRecipient(Message.RecipientType.TO, new InternetAddress(recebe));
			mensagem.setSubject("Teste email");
			mensagem.setText("olá, tudo bem?\nEspero q isso de certo");

			return mensagem;

		} catch (AddressException e) {
			e.printStackTrace();

			return null;
		}
	}
}
