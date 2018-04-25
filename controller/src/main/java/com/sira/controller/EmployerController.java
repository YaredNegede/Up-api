package com.sira.controller;

import java.util.List;

import org.apache.log4j.Logger;

import com.sira.controller.context.ControllerContext;
import com.sira.dto.employer.EmployerDto;
/**
 * 
 * @author Yared
 *
 */
public class EmployerController implements RequestController<EmployerDto>{

	private static Logger logger = Logger.getLogger(EmployerController.class);

	private ControllerContext controllerContext;

	public ControllerContext getControllerContext() {
		return controllerContext;
	}

	public EmployerController(ControllerContext controllerContext) {
		this.controllerContext = controllerContext;
	}
	
	public EmployerDto getById(long id) {
		
		return null;
	}

	public List<EmployerDto> getAll(long userId) {
		
		return null;
	}

	public List<EmployerDto> getAllMaching() {
		
		return null;
	}

	public EmployerDto save(EmployerDto t) {
		
		return null;
	}

	public EmployerDto delete(EmployerDto t) {
		
		return null;
	}

	public EmployerDto deleteMaching(EmployerDto t) {
		
		return null;
	}


}
