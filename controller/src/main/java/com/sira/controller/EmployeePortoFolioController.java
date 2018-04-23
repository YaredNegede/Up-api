package com.sira.controller;

import java.util.List;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.sira.api.security.Security;
import com.sira.dto.employee.EmployeePortoFolioDto;

public class EmployeePortoFolioController implements Controller<EmployeePortoFolioDto>{

	private static Logger logger = Logger.getLogger(EmployeePortoFolioController.class);
	
	private EntityManager entitimanager;

	private Gson gson = new Gson();

	private Security security;

	private Class<? extends Object>  type;

	
	public EmployeePortoFolioController(EntityManager entitimanager, Gson gson, Security security,
			Class<? extends Object> type) {
		super();
		this.entitimanager = entitimanager;
		this.gson = gson;
		this.security = security;
		this.type = type;
	}

	public EntityManager getEntitimanager() {
		return entitimanager;
	}

	public Gson getGson() {
		return gson;
	}

	public Security getSecurity() {
		return security;
	}

	public Class<? extends Object> getType() {
		return type;
	}

	public EmployeePortoFolioDto getById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<EmployeePortoFolioDto> getAll(long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<EmployeePortoFolioDto> getAllMaching() {
		// TODO Auto-generated method stub
		return null;
	}

	public EmployeePortoFolioDto save(EmployeePortoFolioDto t) {
		// TODO Auto-generated method stub
		return null;
	}

	public EmployeePortoFolioDto delete(EmployeePortoFolioDto t) {
		// TODO Auto-generated method stub
		return null;
	}

	public EmployeePortoFolioDto deleteMaching(EmployeePortoFolioDto t) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
