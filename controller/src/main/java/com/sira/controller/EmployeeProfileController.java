package com.sira.controller;

import java.util.List;

import org.apache.log4j.Logger;

import com.sira.controller.context.ControllerContext;
import com.sira.dto.employee.EmployeeProfileDto;

/**
 * 
 * @author Yared Negede
 *
 */

public class EmployeeProfileController implements RequestController<EmployeeProfileDto>{

	private static Logger logger = Logger.getLogger(EmployeeProfileController.class);
	
	private ControllerContext controllerContext;

	public ControllerContext getControllerContext() {
		return controllerContext;
	}

	public EmployeeProfileController(ControllerContext controllerContext) {
		this.controllerContext = controllerContext;
	}
	
	public EmployeeProfileDto getById(long id) {
		
		return null;
	}

	public List<EmployeeProfileDto> getAll(long userId) {
		
		return null;
	}

	public List<EmployeeProfileDto> getAllMaching() {
		
		return null;
	}

	public EmployeeProfileDto save(EmployeeProfileDto t) {
		
		return null;
	}

	public EmployeeProfileDto delete(EmployeeProfileDto t) {
		
		return null;
	}

	public EmployeeProfileDto deleteMaching(EmployeeProfileDto t) {
		
		return null;
	}

	
}
