package com.sira.controller;

import java.util.List;

import org.apache.log4j.Logger;

import com.sira.controller.context.ControllerContext;
import com.sira.dto.employee.EmployeeReviewDto;

public class EmployeeReviewController implements RequestController<EmployeeReviewDto>{

	private static Logger logger = Logger.getLogger(EmployeeReviewController.class);

	private ControllerContext controllerContext;

	public ControllerContext getControllerContext() {
		return controllerContext;
	}

	public EmployeeReviewController(ControllerContext controllerContext) {
		this.controllerContext = controllerContext;
	}
	
	public EmployeeReviewDto getById(long id) {
		
		return null;
	}

	public List<EmployeeReviewDto> getAll(long userId) {
		
		return null;
	}

	public List<EmployeeReviewDto> getAllMaching() {
		
		return null;
	}

	public EmployeeReviewDto save(EmployeeReviewDto t) {
		
		return null;
	}

	public EmployeeReviewDto delete(EmployeeReviewDto t) {
		
		return null;
	}

	public EmployeeReviewDto deleteMaching(EmployeeReviewDto t) {
		
		return null;
	}


}
