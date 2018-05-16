package com.sira.controller;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sira.dto.employee.EmployeeDto;
import com.sira.model.stateschema.common.User;


/**
 * 
 * @author Yared Negede
 *
 */
@RestController
@RequestMapping("/userController")
public class UserController  extends RequestController{

	private static Logger logger = Logger.getLogger(UserController.class);

	public EmployeeDto getById(long id) {
		
		logger.info("getting user ["+id+" ]");
		
		return null;
	}

	public User signup(User user) {
		
		return null;
	}

	public User login(User user) {
		
		return null;
	}

}
