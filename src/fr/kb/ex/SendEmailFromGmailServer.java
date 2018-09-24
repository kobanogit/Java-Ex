package fr.kb.ex;

import java.util.Properties;
import java.util.Scanner;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmailFromGmailServer {
	public static void main(String[] args) {
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		System.out.println("Gmail login :");
		try(Scanner scLogin = new Scanner(System.in)){
			String login = scLogin.nextLine();
			
			System.out.println("Gmail Password :");
			try(Scanner scPwd = new Scanner(System.in)){
				String password = scPwd.nextLine();
				
				Session session = Session.getDefaultInstance(props,	
					new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(login,password);
					}
				});
				
				try {
					Message message = new MimeMessage(session);
					message.setFrom(new InternetAddress("from@no-spam.com"));
					message.setRecipients(Message.RecipientType.TO,
							InternetAddress.parse("to@no-spam.com"));
					message.setSubject("Testing email sent from Java App");
					message.setText("Dear dev," +
							"\n\n your email app works!");

					Transport.send(message);

					System.out.println("Done");

				} catch (MessagingException e) {
					throw new RuntimeException(e);
				}
			}
		}
		

	}
}
