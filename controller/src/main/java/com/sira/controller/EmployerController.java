package com.sira.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sira.dto.employer.EmployerDto;
/**
 * 
 * @author Yared
 *
 */
@RestController
@RequestMapping("/employer")
public class EmployerController   extends RequestController{

	private static Logger logger = Logger.getLogger(EmployerController.class);

	public String getById(long id) {
		
		logger.info("getting employee");
		
		return "{}";
	}

	public List<EmployerDto> getAll(long userId) {
		
		return null;
	}

	public List<EmployerDto> getAllMaching() {
		
		return null;
	}

	public EmployerDto save(EmployerDto t) {
		
		
		return null;
	}

	public EmployerDto delete(EmployerDto t) {
		
		return null;
	}

	public EmployerDto deleteMaching(EmployerDto t) {
		
		return null;
	}



}
