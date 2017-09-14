package com.rhcloud.tothought.web.email;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.rhcloud.tothought.web.email.interfaces.MailMessage;


@Component
public class EmailService {

	@Autowired
	private EmailConfiguration configuration;
	
	public EmailConfiguration getConfiguration() {
		return configuration;
	}

	public void setConfiguration(EmailConfiguration configuration) {
		this.configuration = configuration;
	}
	
	public <T> void sendMessage(MailMessage<T> message){
		if(this.isEnabled()){			
			try {
				Transport.send(message.getMessage(this.getSession()));
			} catch (MessagingException e) {
				e.printStackTrace();
			}
		}
	}
	
	public Session getSession(){
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", configuration.getHost());
		props.put("mail.smtp.port", configuration.getPort());
		
		Session session = Session.getInstance(props, new Authenticator(){

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(configuration.getUsername(), configuration.getPassword());
			}
		});
		
		return session;
	}
	
	/**
	 * Determines if an email should be sent, emails are not sent in the test environment
	 * unless manually specified
	 * @return
	 */
	private boolean isEnabled(){
	    boolean active;
		String environment = this.configuration.getEnvironment();
		
		if(environment == null){
			active = true;
		}else if(environment.equalsIgnoreCase(EmailConfiguration.DEV_ENVIRONMENT) && !EmailConfiguration.IS_EMAIL_ENABLED){
			active = false;
		}else{
			active = true;
		}
		
		return active;
	}

}
