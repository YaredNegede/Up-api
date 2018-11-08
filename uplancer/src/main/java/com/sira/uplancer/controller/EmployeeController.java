package com.sira.uplancer.controller;

import org.apache.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	public String getById(@PathVariable Long employeeId) {

		logger.info("getting employee" + employeeId);

		return "";
	}

	@GetMapping
	@ResponseBody
	public String getAll(@PathVariable Long userId) {
		logger.info("getting employee");
		return "";
	}

	@PostMapping
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
