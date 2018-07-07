package com.sira.uplancer.controller;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sira.model.stateschema.common.Users;
import com.sira.model.stateschema.employee.Employee;


/**
 * 
 * @author Yared Negede
 *
 */
@RestController("userController")
@RequestMapping("/services/user/")
public class UserController {

	private static Logger logger = Logger.getLogger(UserController.class);

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Employee getById(long id) {
		
		logger.info("getting user ["+id+" ]");
		
		return null;
	}

	@RequestMapping(value = "/signup",  method = RequestMethod.POST)
	public Users signup(Users user) {
		
		return null;
	}

	@RequestMapping(value = "/login",method = RequestMethod.POST)
	public Users login(Users user) {
		
		return null;
	}
	
	@RequestMapping(value = "/forget", method = RequestMethod.POST)	
	public Users forget(Users user) {
		
		return null;
	}

}
