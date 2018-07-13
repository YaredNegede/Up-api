package com.sira.uplancer.controller;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
@RestController("employeeController")
@RequestMapping("/api/employee")
public class EmployeeController {

	private static Logger logger = Logger.getLogger(EmployeeController.class);

	@GetMapping(value = "/{employeeId}")
	@ResponseBody
	public String getById(long id) {

		logger.info("getting employee");

		return "";
	}

	@GetMapping
	@ResponseBody
	public String getAll(long userId) {
		logger.info("getting employee");
		return "";
	}

	@PostMapping()
	@ResponseBody
	public String save(EmployeeDto t) {

		return "";
	}

	@DeleteMapping(value = "/{id}")
	@ResponseBody
	public String delete() {

		return "";

	}

}
