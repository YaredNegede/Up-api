package com.sira.controller;

import java.util.List;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.sira.api.security.Security;
import com.sira.dto.employer.EmployerProfileDto;
/**
 * 
 * @author Yared
 *
 */
public class EmployerProfileController implements Controller<EmployerProfileDto>{

	private static Logger logger = Logger.getLogger(EmployerProfileController.class);

	private EntityManager entitimanager;

	private Gson gson = new Gson();

	private Security security;

	private Class<? extends Object>  type;

	public EmployerProfileController(EntityManager entitimanager, Gson gson, Security security,
			Class<? extends Object> type) {
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
	public EmployerProfileDto getById(long id) {
		
		return null;
	}
	public List<EmployerProfileDto> getAll(long userId) {
		
		return null;
	}
	public List<EmployerProfileDto> getAllMaching() {
		
		return null;
	}
	public EmployerProfileDto save(EmployerProfileDto t) {
		
		return null;
	}
	public EmployerProfileDto delete(EmployerProfileDto t) {
		
		return null;
	}
	public EmployerProfileDto deleteMaching(EmployerProfileDto t) {
		
		return null;
	}


	
}
