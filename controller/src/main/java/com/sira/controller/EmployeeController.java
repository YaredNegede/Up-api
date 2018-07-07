package com.sira.controller;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sira.dto.employee.EmployeeDto;

/**
 * 
 * @author Yared Negede
 *
 */
@RestController("employeeController")
@RequestMapping("/services/employee/")
public class EmployeeController {

	private static Logger logger = Logger.getLogger(EmployeeController.class);

	@RequestMapping(value = "/{employeeId}", method = RequestMethod.GET)
	public String getById(long id) {

		logger.info("getting employee");

		return "";
	}

	@RequestMapping(method = RequestMethod.GET)
	public String getAll(long userId) {
		logger.info("getting employee");
		return "";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String save(EmployeeDto t) {

		return "";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String delete() {

		return "";

	}

}
