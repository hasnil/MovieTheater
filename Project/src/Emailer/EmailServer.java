package Emailer;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;


public class EmailServer {

	private String smtpServer;
	private String smtpPrefix;
	private String userName;
	private String password;
	
	private String self; //fixed because we don't want to send emails to random persons testing our app
						//production version should remove it
	
	public EmailServer() {
		smtpServer = "smtp.gmail.com";
		smtpPrefix = "mail.smtp.";
		password = "slabcinemas123!";
		self = "slabcinemas@gmail.com";
		userName = "slabcinemas";
	}
	
	
	/**
	 * Sends an email to the user from the Slab Cinemas.
	 * Currently implemented to send emails only to slabcinemas@gmail.com
	 * to avoid sending emails to random people accidentally.
	 *
	 * @param email email form object to be sent
	 * @return true if email send was successful.
	 */
	@SuppressWarnings("finally")
	public boolean send(EmailForm email) {
		
		boolean result = false;
		
		//Get properties object    
		Properties props = new Properties();
		
		props.put(smtpPrefix + "host", smtpServer);
		props.put(smtpPrefix + "socketFactory.port", "465");
		props.put(smtpPrefix + "socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put(smtpPrefix + "auth", "true");
		props.put(smtpPrefix + "port", "465");
		
		//get Session   
		Session session = Session.getDefaultInstance
				(props,    
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(userName, password);
						}
					}
				);

		//compose message    
		try {    
			MimeMessage message = new MimeMessage(session);
			
			//message.addRecipient(Message.RecipientType.TO, new InternetAddress( email.getTo() )); //production version
			
			message.addRecipient(Message.RecipientType.TO, new InternetAddress( self )); //testing version
			message.setSubject( email.getSubject() );
			message.setText( email.getBody() );
			
			//send message
			Transport.send(message);
			
			result = true;
			
		} catch (MessagingException e) {
			throw new RuntimeException(e);
			
		} finally {
			return result;
		}
		

	}
	
}
