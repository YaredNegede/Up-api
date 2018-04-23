package com.sira.controller;

import java.util.List;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.sira.api.security.Security;
import com.sira.dto.employer.EmployerDto;
/**
 * 
 * @author Yared
 *
 */
public class EmployerController implements Controller<EmployerDto>{

	private static Logger logger = Logger.getLogger(EmployerController.class);

	private EntityManager entitimanager;

	private Gson gson = new Gson();

	private Security security;

	private Class<? extends Object>  type;
	
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

	public EmployerController(EntityManager entitimanager, Gson gson, Security security, Class<? extends Object> type) {
		super();
		this.entitimanager = entitimanager;
		this.gson = gson;
		this.security = security;
		this.type = type;
	}

	public EmployerDto getById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<EmployerDto> getAll(long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<EmployerDto> getAllMaching() {
		// TODO Auto-generated method stub
		return null;
	}

	public EmployerDto save(EmployerDto t) {
		// TODO Auto-generated method stub
		return null;
	}

	public EmployerDto delete(EmployerDto t) {
		// TODO Auto-generated method stub
		return null;
	}

	public EmployerDto deleteMaching(EmployerDto t) {
		// TODO Auto-generated method stub
		return null;
	}


}
