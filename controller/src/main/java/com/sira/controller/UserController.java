package com.sira.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;

import com.sira.dto.employee.EmployeeDto;
import com.sira.model.stateschema.common.User;


/**
 * 
 * @author Yared Negede
 *
 */
@Controller
public class UserController  extends RequestController{

	private static Logger logger = Logger.getLogger(UserController.class);

	public EmployeeDto getById(long id) {
		
		return null;
	}

	public User signup(User user) {
		
		return null;
	}

	public User login(User user) {
		
		return null;
	}

}
