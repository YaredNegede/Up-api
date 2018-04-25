package com.sira.controller;

import java.util.List;

import org.apache.log4j.Logger;

import com.sira.controller.context.ControllerContext;
import com.sira.dto.common.MessageDto;

public class MessageController  implements RequestController<MessageDto>{
	
	private static Logger logger = Logger.getLogger(MessageController.class);
	
	private ControllerContext controllerContext;

	public ControllerContext getControllerContext() {
		return controllerContext;
	}

	public MessageController(ControllerContext controllerContext) {
		this.controllerContext = controllerContext;
	}

	public MessageDto getById(long id) {
		
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
