package com.sira.api.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.sira.api.security.Security;
import com.sira.model.stateschema.model.Employer;
/**
 * 
 * @author Yared
 *
 */
public class EmployerRepository implements Repository<Employer>{

	private static Logger logger = Logger.getLogger(EmployerRepository.class);

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

	public EmployerRepository(EntityManager entitimanager, Gson gson, Security security, Class<? extends Object> type) {
		super();
		this.entitimanager = entitimanager;
		this.gson = gson;
		this.security = security;
		this.type = type;
	}

	@Override
	public Employer getById(long id) {
		
		return null;
	}

	@Override
	public List<Employer> getAll(long userId) {
		
		return null;
	}

	@Override
	public List<Employer> getAllMaching() {
		
		return null;
	}

	@Override
	public Employer save(Employer t) {
		
		return null;
	}

	@Override
	public Employer delete(Employer t) {
		
		return null;
	}

	@Override
	public Employer deleteMaching(Employer t) {
		
		return null;
	}

}
