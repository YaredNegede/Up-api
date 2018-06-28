package com.sira.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sira.dto.common.MessageDto;

@RestController("messageController")
@RequestMapping("/services/message/")
public class MessageController{
	
	private static Logger logger = Logger.getLogger(MessageController.class);
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public MessageDto getById(long id) {
		
		logger.info(id);
		
		return null;
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<MessageDto> getAll(long userId) {
		
		return null;
	}

	@RequestMapping(method = RequestMethod.POST)
	public MessageDto save(MessageDto t) {
		
		return null;
	}

	@RequestMapping(method = RequestMethod.DELETE)
	public MessageDto delete(MessageDto t) {
		
		return null;
	}
	
}
