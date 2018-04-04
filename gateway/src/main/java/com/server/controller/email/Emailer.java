package com.server.controller.email;

import org.apache.log4j.Logger;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import com.server.error.GateException;
import com.sira.model.stateschema.model.Uplancer;
import com.sira.model.stateschema.model.UserBase;

public class Emailer {

	private static Logger logger = Logger.getLogger(Emailer.class);
	
	private Uplancer uplancer;

	private JavaMailSenderImpl javaMailSenderImpl;
	
	public void sendTokenLint(UserBase userBase) throws GateException{
		
		logger.info("Email Sent to [ "+userBase.getUser().getEmail()+" ]");
		
		JavaMailSenderImpl sender = this.getJavaMailSenderImpl();
		
		SimpleMailMessage simpleMessage = new SimpleMailMessage();
		
		simpleMessage.setText(userBase.getUser().getStatusToken());
		
		simpleMessage.setFrom(this.getUplancer().getEmail());
		
		simpleMessage.setTo(userBase.getUser().getEmail());
		
		try {
			
			sender.send(simpleMessage );
			
		} catch (MailException e) {

			throw new  GateException(e.getLocalizedMessage());
			
		}
		
	}

	private JavaMailSenderImpl getJavaMailSenderImpl() {
		return this.javaMailSenderImpl;
	}

	private Uplancer getUplancer() {
		
		return this.uplancer;
		
	}

}
