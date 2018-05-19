package com.sira.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sira.dto.common.MessageDto;

@Controller
@RequestMapping("/messageController")
public class MessageController{
	
	private static Logger logger = Logger.getLogger(MessageController.class);
	
	public MessageDto getById(long id) {
		
		logger.info(id);
		
		return null;
	}

	public List<MessageDto> getAll(long userId) {
		
		return null;
	}

	public List<MessageDto> getAllMaching() {
		
		return null;
	}

	public MessageDto save(MessageDto t) {
		
		return null;
	}

	public MessageDto delete(MessageDto t) {
		
		return null;
	}

	public MessageDto deleteMaching(MessageDto t) {
		
		return null;
	}

	
}
