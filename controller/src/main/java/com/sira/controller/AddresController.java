package com.sira.controller;

import java.util.List;

import org.apache.log4j.Logger;

import com.sira.controller.context.ControllerContext;
import com.sira.dto.employee.AddresDto;

public class AddresController implements RequestController<AddresDto> {
	
	private static Logger logger = Logger.getLogger(AddresController.class);
	
	private ControllerContext controllerContext;

	public ControllerContext getControllerContext() {
		return controllerContext;
	}

	public AddresController(ControllerContext controllerContext) {
		this.controllerContext = controllerContext;
	}

	public AddresDto getById(long id) {
		
		return null;
	}

	public List<AddresDto> getAll(long userId) {
		
		return null;
	}

	public List<AddresDto> getAllMaching() {
		
		return null;
	}

	public AddresDto save(AddresDto t) {
		
		return null;
	}

	public AddresDto delete(AddresDto t) {
		
		return null;
	}

	public AddresDto deleteMaching(AddresDto t) {
		
		return null;
	}


	
}
