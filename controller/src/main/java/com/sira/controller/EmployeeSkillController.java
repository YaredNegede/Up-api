package com.sira.controller;

import java.util.List;

import org.apache.log4j.Logger;

import com.sira.controller.context.ControllerContext;
import com.sira.dto.employee.SkillDto;
/**
 * 
 * @author Yared
 *
 */
public class EmployeeSkillController  implements RequestController<SkillDto>{

	private static Logger logger = Logger.getLogger(EmployeeSkillController.class);

	private ControllerContext controllerContext;

	public ControllerContext getControllerContext() {
		return controllerContext;
	}

	public EmployeeSkillController(ControllerContext controllerContext) {
		this.controllerContext = controllerContext;
	}
	
	public SkillDto getById(long id) {
		
		return null;
	}

	public List<SkillDto> getAll(long userId) {
		
		return null;
	}

	public List<SkillDto> getAllMaching() {
		
		return null;
	}

	public SkillDto save(SkillDto t) {
		
		return null;
	}

	public SkillDto delete(SkillDto t) {
		
		return null;
	}

	public SkillDto deleteMaching(SkillDto t) {
		
		return null;
	}

}
