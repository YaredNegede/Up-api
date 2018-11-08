package com.sira.uplancer.controller;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
@RequestMapping("/api/user")
public class UserController {

	private static Logger logger = Logger.getLogger(UserController.class);

	@GetMapping(value = "/{id}")
	public Employee getById(long id) {
		
		logger.info("getting user ["+id+" ]");
		
		return null;
	}

	@PostMapping(value = "/signup")
	public Users signup(Users user) {
		
		return null;
	}

	@PostMapping(value = "/login")
	public Users login(Users user) {
		
		return null;
	}
	
	@PostMapping(value = "/forget")	
	public Users forget(Users user) {
		
		return null;
	}

}
