package com.server.controller.email;

import org.apache.log4j.Logger;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import com.server.error.GateException;
import com.sira.model.stateschema.model.UserBase;

public class Emailer {

	private static Logger logger = Logger.getLogger(Emailer.class);
	
	public void sendTokenLint(UserBase userBase) throws GateException{
		
		logger.info("Email Sent to [ "+userBase.getUser().getEmail()+" ]");
		
		JavaMailSenderImpl sender = new JavaMailSenderImpl();
		
		SimpleMailMessage simpleMessage = new SimpleMailMessage();
		
		simpleMessage.setText(userBase.getUser().getStatusToken());
		
		simpleMessage.setFrom("system@uplancer.io");
		
		simpleMessage.setTo(userBase.getUser().getEmail());
		
		try {
			
			sender.send(simpleMessage );
			
		} catch (MailException e) {

			throw new  GateException(e.getLocalizedMessage());
			
		}

		
	}

}
