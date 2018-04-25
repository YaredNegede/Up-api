package com.sira.controller;

import java.util.List;

import org.apache.log4j.Logger;

import com.sira.controller.context.ControllerContext;
import com.sira.dto.common.UplancerDto;
/**
 * 
 * @author Yared Negede
 *
 */
public class UplancerController implements RequestController<UplancerDto>{

	private static Logger logger = Logger.getLogger(UplancerController.class);
	
	private ControllerContext controllerContext;

	public ControllerContext getControllerContext() {
		return controllerContext;
	}

	public UplancerController(ControllerContext controllerContext) {
		this.controllerContext = controllerContext;
	}
	
	public UplancerDto getById(long id) {
		
		return null;
	}

	public List<UplancerDto> getAll(long userId) {
		
		return null;
	}

	public List<UplancerDto> getAllMaching() {
		
		return null;
	}

	public UplancerDto save(UplancerDto t) {
		return null;
	}

	public UplancerDto delete(UplancerDto t) {
		
		return null;
	}

	public UplancerDto deleteMaching(UplancerDto t) {
		
		return null;
	}
	
}
