package com.sira.controller;

import java.util.List;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.sira.api.security.Security;
import com.sira.dto.employee.EmployeeDto;
/**
 * 
 * @author Yared
 *
 */
public class EmployeeController  implements Controller<EmployeeDto>{

	private static Logger logger = Logger.getLogger(EmployeeController.class);
	
	private EntityManager entitimanager;

	private Gson gson = new Gson();

	private Security security;

	private Class<? extends Object>  type;
	
	public EmployeeController(EntityManager entitimanager, Gson gson, Security security, Class<? extends Object> type) {
		super();
		this.entitimanager = entitimanager;
		this.gson = gson;
		this.security = security;
		this.type = type;
	}

	public static Logger getLogger() {
		return logger;
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

	public EmployeeDto getById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<EmployeeDto> getAll(long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<EmployeeDto> getAllMaching() {
		// TODO Auto-generated method stub
		return null;
	}

	public EmployeeDto save(EmployeeDto t) {
		// TODO Auto-generated method stub
		return null;
	}

	public EmployeeDto delete(EmployeeDto t) {
		// TODO Auto-generated method stub
		return null;
	}

	public EmployeeDto deleteMaching(EmployeeDto t) {
		// TODO Auto-generated method stub
		return null;
	}



}
