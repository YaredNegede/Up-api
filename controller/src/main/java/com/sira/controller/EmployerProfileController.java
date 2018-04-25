package com.sira.controller;

import java.util.List;

import org.apache.log4j.Logger;

import com.sira.controller.context.ControllerContext;
import com.sira.dto.employer.EmployerProfileDto;
/**
 * 
 * @author Yared Negede
 *
 */
public class EmployerProfileController implements RequestController<EmployerProfileDto>{

	private static Logger logger = Logger.getLogger(EmployerProfileController.class);

	private ControllerContext controllerContext;

	public ControllerContext getControllerContext() {
		return controllerContext;
	}

	public EmployerProfileController(ControllerContext controllerContext) {
		this.controllerContext = controllerContext;
	}

	public EmployerProfileDto getById(long id) {
		
		return null;
	}
	public List<EmployerProfileDto> getAll(long userId) {
		
		return null;
	}
	public List<EmployerProfileDto> getAllMaching() {
		
		return null;
	}
	public EmployerProfileDto save(EmployerProfileDto t) {
		
		return null;
	}
	public EmployerProfileDto delete(EmployerProfileDto t) {
		
		return null;
	}
	public EmployerProfileDto deleteMaching(EmployerProfileDto t) {
		
		return null;
	}


	
}
