package com.sira.api.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.sira.api.security.Security;
import com.sira.model.stateschema.model.WorkBase;
/**
 * 
 * @author Yared
 *
 */
public class WorkRepository implements Repository<WorkBase>{

	private static Logger logger = Logger.getLogger(WorkRepository.class);
	
	private EntityManager entitimanager;

	private Gson gson = new Gson();

	private Security security;

	private Class<? extends Object>  type;

	public WorkRepository(EntityManagerFactory entitimanager,
			Security security,
			String type) 
					throws ClassNotFoundException {

		this.entitimanager=entitimanager.createEntityManager();

		this.security = security;

		this.type  = Class.forName(type);;

	}

	@Override
	public WorkBase getById(long id) {
		
		return null;
	}

	@Override
	public List<WorkBase> getAll(long userId) {
		
		return null;
	}

	@Override
	public List<WorkBase> getAllMaching() {
		
		return null;
	}

	@Override
	public WorkBase save(WorkBase t) {
		
		return null;
	}

	@Override
	public WorkBase delete(WorkBase t) {
		
		return null;
	}

	@Override
	public WorkBase deleteMaching(WorkBase t) {
		
		return null;
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



}
