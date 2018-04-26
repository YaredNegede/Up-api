package com.sira.api.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.sira.api.security.Security;
import com.sira.model.stateschema.employee.Certefication;

public class CertificationRepository implements Repository<Certefication> {
	
	private static Logger logger = Logger.getLogger(CertificationRepository.class);
	
	private EntityManager entitimanager;

	private Gson gson = new Gson();

	private Security security;

	private Class<? extends Object>  type;

	public CertificationRepository(EntityManager entitimanager, Gson gson, Security security, Class<? extends Object> type) {
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
	public Certefication getById(long id) {
		
		return null;
	}

	@Override
	public List<Certefication> getAll(long userId) {
		
		return null;
	}

	@Override
	public List<Certefication> getAllMaching() {
		
		return null;
	}

	@Override
	public Certefication save(Certefication t) {
		
		return null;
	}

	@Override
	public Certefication delete(Certefication t) {
		
		return null;
	}

	@Override
	public Certefication deleteMaching(Certefication t) {
		
		return null;
	}

	
}
