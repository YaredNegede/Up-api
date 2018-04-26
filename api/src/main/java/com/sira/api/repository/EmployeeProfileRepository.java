package com.sira.api.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.sira.api.security.Security;
import com.sira.model.stateschema.employee.EmployeeProfile;

/**
 * 
 * @author Yared Negede
 *
 */

public class EmployeeProfileRepository implements Repository<EmployeeProfile>{

	private static Logger logger = Logger.getLogger(EmployeeProfileRepository.class);
	
	private EntityManager entitimanager;

	private Gson gson = new Gson();

	private Security security;

	private Class<? extends Object>  type;
	
	public EmployeeProfileRepository(EntityManager entitimanager, Gson gson, Security security,
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

	@Override
	public EmployeeProfile getById(long id) {
		
		return null;
	}

	@Override
	public List<EmployeeProfile> getAll(long userId) {
		
		return null;
	}

	@Override
	public List<EmployeeProfile> getAllMaching() {
		
		return null;
	}

	@Override
	public EmployeeProfile save(EmployeeProfile t) {
		
		return null;
	}

	@Override
	public EmployeeProfile delete(EmployeeProfile t) {
		
		return null;
	}

	@Override
	public EmployeeProfile deleteMaching(EmployeeProfile t) {
		
		return null;
	}
}
