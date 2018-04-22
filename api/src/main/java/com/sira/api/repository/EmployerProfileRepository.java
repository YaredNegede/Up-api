package com.sira.api.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.sira.api.security.Security;
import com.sira.model.stateschema.model.EmployerProfile;
/**
 * 
 * @author Yared
 *
 */
public class EmployerProfileRepository implements Repository<EmployerProfile>{

	private static Logger logger = Logger.getLogger(EmployerProfileRepository.class);

	private EntityManager entitimanager;

	private Gson gson = new Gson();

	private Security security;

	private Class<? extends Object>  type;

	public EmployerProfileRepository(EntityManager entitimanager, Gson gson, Security security,
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
	
	@Override
	public EmployerProfile getById(long id) {
		
		return null;
	}

	@Override
	public List<EmployerProfile> getAll(long userId) {
		
		return null;
	}

	@Override
	public List<EmployerProfile> getAllMaching() {
		
		return null;
	}

	@Override
	public EmployerProfile save(EmployerProfile t) {
		
		return null;
	}

	@Override
	public EmployerProfile delete(EmployerProfile t) {
		
		return null;
	}

	@Override
	public EmployerProfile deleteMaching(EmployerProfile t) {
		
		return null;
	}

	
}
