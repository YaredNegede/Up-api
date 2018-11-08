package com.sira.uplancer.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sira.dto.common.MessageDto;

@RestController("messageController")
@RequestMapping("/api/message/")
public class MessageController{
	
	private static Logger logger = Logger.getLogger(MessageController.class);
	
	@GetMapping(value = "/{id}")
	public MessageDto getById(long id) {
		
		return null;
		
	}

	@GetMapping
	public List<MessageDto> getAll(long userId) {
		
		return null;
	}

	@PostMapping
	public MessageDto save(MessageDto t) {
		
		return null;
	}

	@DeleteMapping
	public MessageDto delete(MessageDto t) {
		
		return null;
		
	}
	
}
