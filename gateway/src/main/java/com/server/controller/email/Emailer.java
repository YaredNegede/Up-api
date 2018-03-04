package com.server.controller.email;

import org.apache.log4j.Logger;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import com.server.error.GateException;
import com.sira.api.deamon.UplancerInfo;
import com.sira.api.error.APIException;
import com.sira.model.stateschema.model.Uplancer;
import com.sira.model.stateschema.model.UserBase;

public class Emailer {

	private static Logger logger = Logger.getLogger(Emailer.class);
	
	public void sendTokenLint(UserBase userBase, UplancerInfo uplancerInfo) throws GateException{
		
		logger.info("Email Sent to [ "+userBase.getUser().getEmail()+" ]");
		
		Uplancer uplancer;
		
		try {
			
			uplancer = uplancerInfo.getUplancer();
			
		} catch (APIException e1) {

			throw new GateException(e1.getLocalizedMessage());
			
		}
		
		JavaMailSenderImpl sender = new JavaMailSenderImpl();
		
		SimpleMailMessage simpleMessage = new SimpleMailMessage();
		
		simpleMessage.setText(userBase.getUser().getStatusToken());
		
		simpleMessage.setFrom(uplancer.getEmail());
		
		simpleMessage.setTo(userBase.getUser().getEmail());
		
		try {
			
			sender.send(simpleMessage );
			
		} catch (MailException e) {

			throw new  GateException(e.getLocalizedMessage());
			
		}
		
	}

}
