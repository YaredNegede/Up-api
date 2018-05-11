package com.sira.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.sira.dto.employer.EmployerDto;
import com.sira.model.stateschema.employer.Employer;
import com.sira.service.EmployerService;
/**
 * 
 * @author Yared
 *
 */
@Controller
public class EmployerController   extends RequestController{

	private static Logger logger = Logger.getLogger(EmployerController.class);

	@Autowired
	private EmployerService employerService;
	
	public String getById(long id) {
		
		return null;
	}

	public List<EmployerDto> getAll(long userId) {
		
		return null;
	}

	public List<EmployerDto> getAllMaching() {
		
		return null;
	}

	public EmployerDto save(EmployerDto t) {
		
		this.getEmployerService().save(new Employer());
		
		return null;
	}

	public EmployerDto delete(EmployerDto t) {
		
		return null;
	}

	public EmployerDto deleteMaching(EmployerDto t) {
		
		return null;
	}

	public EmployerService getEmployerService() {
		return employerService;
	}

	public void setEmployerService(EmployerService employerService) {
		this.employerService = employerService;
	}


}
