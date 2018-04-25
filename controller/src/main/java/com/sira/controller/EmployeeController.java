package com.sira.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;

import com.sira.api.repository.EmployeeRepository;
import com.sira.controller.context.ControllerContext;
import com.sira.dto.employee.EmployeeDto;
import com.sira.dto.employee.mapperimpl.EmployeeMapperImpl;
import com.sira.model.stateschema.model.Employee;

/**
 * 
 * @author Yared Negede
 *
 */
@Controller
public class EmployeeController  implements RequestController<EmployeeDto>{

	private static Logger logger = Logger.getLogger(EmployeeController.class);
	private ControllerContext controllerContext;

	public ControllerContext getControllerContext() {
		return controllerContext;
	}

	public EmployeeController(ControllerContext controllerContext) {
		this.controllerContext = controllerContext;
	}

	public EmployeeDto getById(long id) {
		
		return null;
	}

	public List<EmployeeDto> getAll(long userId) {
		
		return null;
	}

	public List<EmployeeDto> getAllMaching() {
		
		return null;
	}

	public EmployeeDto save(EmployeeDto t) {
		
		return null;
	}

	public EmployeeDto delete(EmployeeDto t) {
		
		EmployeeMapperImpl employeeMapperImpl = new com.sira.dto.employee.mapperimpl.EmployeeMapperImpl();
		
		Employee ent = employeeMapperImpl.toEntity(t);
		
		EmployeeRepository employeeRepository = new  EmployeeRepository(getEntitimanager(), getGson(), getSecurity(), getType());
		
		employeeRepository.delete(ent);
		
		return t;
	}

	public EmployeeDto deleteMaching(EmployeeDto t) {
		
		return null;
	}

}
