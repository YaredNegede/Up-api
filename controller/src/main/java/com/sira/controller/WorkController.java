package com.sira.controller;

import java.util.List;

import org.apache.log4j.Logger;

import com.sira.controller.context.ControllerContext;
import com.sira.dto.common.WorkBaseDto;
/**
 * 
 * @author Yared
 *
 */
public class WorkController implements RequestController<WorkBaseDto>{

	private static Logger logger = Logger.getLogger(WorkController.class);
	
	private ControllerContext controllerContext;

	public ControllerContext getControllerContext() {
		return controllerContext;
	}

	public WorkController(ControllerContext controllerContext) {
		this.controllerContext = controllerContext;
	}

	public WorkBaseDto getById(long id) {
		
		return null;
	}


	public List<WorkBaseDto> getAll(long userId) {
		
		return null;
	}


	public List<WorkBaseDto> getAllMaching() {
		
		return null;
	}


	public WorkBaseDto save(WorkBaseDto t) {
		
		return null;
	}


	public WorkBaseDto delete(WorkBaseDto t) {
		
		return null;
	}


	public WorkBaseDto deleteMaching(WorkBaseDto t) {
		
		return null;
	}



}
