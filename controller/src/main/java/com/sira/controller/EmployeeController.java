package com.sira.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sira.dto.employee.EmployeeDto;


/**
 * 
 * @author Yared Negede
 *
 */
@Controller
@RequestMapping("employee")
public class EmployeeController  extends RequestController{

	private static Logger logger = Logger.getLogger(EmployeeController.class);

	public String getById(long id) {
		
		return null;
	}

	public String getAll(long userId) {
		
		return null;
	}

	public List<EmployeeDto> getAllMaching() {
		
		return null;
	}

	public EmployeeDto save(EmployeeDto t) {
		
		return null;
	}

	public EmployeeDto delete(EmployeeDto t) {
		
		return t;
	}

	public EmployeeDto deleteMaching(EmployeeDto t) {
		
		return null;
	}

}
