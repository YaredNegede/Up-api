package com.sira.controller;

import java.util.List;

import org.apache.log4j.Logger;

import com.sira.controller.context.ControllerContext;
import com.sira.dto.employer.EmployerReviewDto;
/**
 * 
 * @author Yared Negede
 *
 */
public class EmployerReviewController implements RequestController<EmployerReviewDto>{

	private static Logger logger = Logger.getLogger(EmployerReviewController.class);

	private ControllerContext controllerContext;

	public ControllerContext getControllerContext() {
		return controllerContext;
	}

	public EmployerReviewController(ControllerContext controllerContext) {
		this.controllerContext = controllerContext;
	}
	
	public EmployerReviewDto getById(long id) {
		
		return null;
	}

	public List<EmployerReviewDto> getAll(long userId) {
		
		return null;
	}

	public List<EmployerReviewDto> getAllMaching() {
		
		return null;
	}

	public EmployerReviewDto save(EmployerReviewDto t) {
		
		return null;
	}

	public EmployerReviewDto delete(EmployerReviewDto t) {
		
		return null;
	}

	public EmployerReviewDto deleteMaching(EmployerReviewDto t) {
		
		return null;
	}

	
}
