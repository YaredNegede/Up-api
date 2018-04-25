package com.sira.controller;

import java.util.List;

import org.apache.log4j.Logger;

import com.sira.controller.context.ControllerContext;
import com.sira.dto.employee.AccountDto;

public class AccountController implements RequestController<AccountDto>{
	
	private static Logger logger = Logger.getLogger(AccountController.class);
	
	private ControllerContext controllerContext;

	public ControllerContext getControllerContext() {
		return controllerContext;
	}

	public AccountController(ControllerContext controllerContext) {
		this.controllerContext = controllerContext;
	}

	public AccountDto getById(long id) {

		return null;
	}

	public List<AccountDto> getAll(long userId) {
		
		return null;
	}

	public List<AccountDto> getAllMaching() {
		
		return null;
	}

	public AccountDto save(AccountDto t) {
		
		return null;
	}

	public AccountDto delete(AccountDto t) {
		
		return null;
	}

	public AccountDto deleteMaching(AccountDto t) {
		
		return null;
	}

	
	
}
