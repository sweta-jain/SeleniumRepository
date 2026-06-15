package Utils;

import java.io.File;
import java.util.Properties;

import jakarta.mail.Authenticator;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;

public class EmailUtil {
	
	public static void sendEmail(File reportFile) {
		// TODO Auto-generated method stub
		final String senderEnail = "testswetaemail@gmail.com";
		final String appPassword = "brnknrewkrqscmat";
		final String receiverEnail = "testswetaemail@gmail.com";
		
		Properties prop = new Properties();
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.starttls.enable", "true");
		prop.put("mail.smtp.port", "587");
		
		Session session = Session.getInstance(prop, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(senderEnail, appPassword);
			}
		});
		
		session.setDebug(true);
		
		try {
			MimeMessage msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(senderEnail));
			msg.setRecipients(MimeMessage.RecipientType.TO, InternetAddress.parse(receiverEnail));
			msg.setSubject("Demo Email");
						
			MimeBodyPart msgPart = new MimeBodyPart();
			msgPart.setText("Demo Email for Automation \n\n Thank you");
			
			MimeBodyPart msgAttachmentPart = new MimeBodyPart();
			msgAttachmentPart.attachFile(reportFile);
			
			MimeMultipart multiPart = new MimeMultipart();
			multiPart.addBodyPart(msgPart);
			multiPart.addBodyPart(msgAttachmentPart);
			msg.setContent(multiPart);
			
			
			Transport.send(msg);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
