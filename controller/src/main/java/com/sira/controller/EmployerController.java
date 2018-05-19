package com.sira.controller;

import org.apache.log4j.Logger;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sira.dto.employer.EmployerDto;


/**
 * ----------------------
 * -@author Yared Negede-
 * ----------------------
 *
 */
@RestController
public class EmployerController {

	private static Logger logger = Logger.getLogger(EmployerController.class);

	
	@RequestMapping(value = "/employer/{employerId}", method = RequestMethod.DELETE)
	@ResponseBody
	public void delete(@PathVariable String employeeId,BindingResult res) {
		
		logger.info("Inside getemployerId, returned: ");

	}

	@RequestMapping(value = "/employer/", method = RequestMethod.GET)
	public String getEmployers(BindingResult res) {

		logger.info("Inside getAllIssuers() method...");

		return "{}";
	}
	
	@RequestMapping(value = "/employer/{employerId}", method = RequestMethod.GET)
	@ResponseBody
	public EmployerDto getEmployer(@PathVariable("employerId") String employerId,BindingResult res) {

		logger.info("Inside getemployerId, returned: ");

		EmployerDto ret = new EmployerDto();
		
		ret.name = "yared is awesome";
		
		return ret ;

	}

	@RequestMapping(value = "/employer/", method = RequestMethod.POST)
	@ResponseBody
	public EmployerDto save(@ModelAttribute("employer") EmployerDto employer,BindingResult res) {
		
		logger.info("saving "+employer);
		
		if(res.hasErrors()) {
			
		}
		
		return employer;
	}


}
