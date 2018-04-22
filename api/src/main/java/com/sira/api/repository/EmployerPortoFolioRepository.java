package com.sira.api.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.sira.api.security.Security;
import com.sira.model.stateschema.model.EmployerPortoFolio;

public class EmployerPortoFolioRepository implements Repository<EmployerPortoFolio>{

	private static Logger logger = Logger.getLogger(EmployerPortoFolioRepository.class);
	
	private EntityManager entitimanager;

	private Gson gson = new Gson();

	private Security security;

	private Class<? extends Object>  type;

	public EmployerPortoFolioRepository(EntityManager entitimanager, Gson gson, Security security, Class<? extends Object> type) {
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
	public EmployerPortoFolio getById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmployerPortoFolio> getAll(long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmployerPortoFolio> getAllMaching() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmployerPortoFolio save(EmployerPortoFolio t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmployerPortoFolio delete(EmployerPortoFolio t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmployerPortoFolio deleteMaching(EmployerPortoFolio t) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
