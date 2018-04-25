package com.sira.controller;

import java.util.List;

import org.apache.log4j.Logger;

import com.sira.controller.context.ControllerContext;
import com.sira.dto.employee.EmployeePortoFolioDto;

public class EmployeePortoFolioController implements RequestController<EmployeePortoFolioDto>{

	private static Logger logger = Logger.getLogger(EmployeePortoFolioController.class);
	
	private ControllerContext controllerContext;

	public ControllerContext getControllerContext() {
		return controllerContext;
	}

	public EmployeePortoFolioController(ControllerContext controllerContext) {
		this.controllerContext = controllerContext;
	}

	public EmployeePortoFolioDto getById(long id) {
		
		return null;
	}

	public List<EmployeePortoFolioDto> getAll(long userId) {
		
		return null;
	}

	public List<EmployeePortoFolioDto> getAllMaching() {
		
		return null;
	}

	public EmployeePortoFolioDto save(EmployeePortoFolioDto t) {
		
		return null;
	}

	public EmployeePortoFolioDto delete(EmployeePortoFolioDto t) {
		
		return null;
	}

	public EmployeePortoFolioDto deleteMaching(EmployeePortoFolioDto t) {
		
		return null;
	}

	
}
