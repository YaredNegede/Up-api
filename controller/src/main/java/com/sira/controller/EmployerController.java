package com.sira.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sira.dto.employer.EmployerDto;
import com.sira.model.stateschema.employer.Employer;
import com.sira.service.EmployerService;


/**
 * ----------------------
 * -@author Yared Negede-
 * ----------------------
 *
 */
@RequestMapping("service")
@RestController
public class EmployerController {

	private static Logger logger = Logger.getLogger(EmployerController.class);

	@Autowired
	EmployerService employerService;
	
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
	public EmployerDto getEmployer(String employerId) {

		logger.info("Inside getemployerId, returned: ");

		EmployerDto ret = new EmployerDto();
		
		ret.name = employerId;
		
		return ret ;

	}

	@RequestMapping(value = "/employer/", method = RequestMethod.POST)
	@ResponseBody
	public EmployerDto save(@ModelAttribute("employer") EmployerDto employer,BindingResult res) {
		
		logger.info("saving "+employer);
		
//		EmployeeMapperImpl mapper = new EmployeeMapperImpl();
		
//		employerService.save(employer)?
		
		if(res.hasErrors()) {
			
			logger.error("error found");
			
		}
		
		employerService.save(new Employer());
		
		return employer;
	}


}
