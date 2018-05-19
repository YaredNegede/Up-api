package com.sira.controller;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sira.dto.employee.EmployeeDto;


/**
 * 
 * @author Yared Negede
 *
 */
@RestController
@RequestMapping("/employee")
public class EmployeeController{

	private static Logger logger = Logger.getLogger(EmployeeController.class);

	@RequestMapping(value = "/{employeeId}", method = RequestMethod.GET)
	@ResponseBody
	public String getById(long id) {
		
		logger.info("getting employee");
		
		return "";
	}
	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ResponseBody
	public String getAll(long userId) {
		logger.info("getting employee");
		return "";
	}

	@RequestMapping(value = "/matching", method = RequestMethod.GET)
	@ResponseBody
	public String getAllMachinngg(EmployeeDto t) {
		
		return "";
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ResponseBody
	public String save(EmployeeDto t) {
		
		return "";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public String delete() {
		
		return "";
		
	}

}
