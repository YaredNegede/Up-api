package com.sira.controller;

import java.util.List;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.sira.api.security.Security;
import com.sira.dto.employee.EmployeeProfileDto;

/**
 * 
 * @author Yared Negede
 *
 */

public class EmployeeProfileController implements Controller<EmployeeProfileDto>{

	private static Logger logger = Logger.getLogger(EmployeeProfileController.class);
	
	private EntityManager entitimanager;

	private Gson gson = new Gson();

	private Security security;

	private Class<? extends Object>  type;
	
	public EmployeeProfileController(EntityManager entitimanager, Gson gson, Security security,
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

	public EmployeeProfileDto getById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<EmployeeProfileDto> getAll(long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<EmployeeProfileDto> getAllMaching() {
		// TODO Auto-generated method stub
		return null;
	}

	public EmployeeProfileDto save(EmployeeProfileDto t) {
		// TODO Auto-generated method stub
		return null;
	}

	public EmployeeProfileDto delete(EmployeeProfileDto t) {
		// TODO Auto-generated method stub
		return null;
	}

	public EmployeeProfileDto deleteMaching(EmployeeProfileDto t) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
