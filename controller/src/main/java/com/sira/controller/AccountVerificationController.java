package com.sira.controller;

import java.util.List;

import org.apache.log4j.Logger;

import com.sira.controller.context.ControllerContext;
import com.sira.dto.employee.AccountVerificationDto;

public class AccountVerificationController implements RequestController<AccountVerificationDto> {
	
	private static Logger logger = Logger.getLogger(AccountVerificationController.class);
	
	private ControllerContext controllerContext;

	public ControllerContext getControllerContext() {
		return controllerContext;
	}

	public AccountVerificationController(ControllerContext controllerContext) {
		this.controllerContext = controllerContext;
	}

	public AccountVerificationDto getById(long id) {
		
		return null;
	}

	public List<AccountVerificationDto> getAll(long userId) {
		
		return null;
	}

	public List<AccountVerificationDto> getAllMaching() {
		
		return null;
	}

	public AccountVerificationDto save(AccountVerificationDto t) {
		
		return null;
	}

	public AccountVerificationDto delete(AccountVerificationDto t) {
		
		return null;
	}

	public AccountVerificationDto deleteMaching(AccountVerificationDto t) {
		
		return null;
	}
	
}
