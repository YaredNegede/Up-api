package com.sira.controller;

import java.util.List;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.sira.api.security.Security;
import com.sira.controller.context.ControllerContext;
import com.sira.dto.employer.EmployerPortoFolioDto;

public class EmployerPortoFolioController implements RequestController<EmployerPortoFolioDto>{

	private static Logger logger = Logger.getLogger(EmployerPortoFolioController.class);
	
	private ControllerContext controllerContext;

	public ControllerContext getControllerContext() {
		return controllerContext;
	}

	public EmployerPortoFolioController(ControllerContext controllerContext) {
		this.controllerContext = controllerContext;
	}

	public EmployerPortoFolioDto getById(long id) {
		return null;
	}

	public List<EmployerPortoFolioDto> getAll(long userId) {
		return null;
	}

	public List<EmployerPortoFolioDto> getAllMaching() {
		return null;
	}

	public EmployerPortoFolioDto save(EmployerPortoFolioDto t) {
		return null;
	}

	public EmployerPortoFolioDto delete(EmployerPortoFolioDto t) {
		return null;
	}

	public EmployerPortoFolioDto deleteMaching(EmployerPortoFolioDto t) {
		return null;
	}
	
}
