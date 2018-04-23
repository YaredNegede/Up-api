package com.sira.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.sira.api.security.Security;
import com.sira.dto.common.WorkBaseDto;
/**
 * 
 * @author Yared
 *
 */
public class WorkController implements Controller<WorkBaseDto>{

	private static Logger logger = Logger.getLogger(WorkController.class);
	
	private EntityManager entitimanager;

	private Gson gson = new Gson();

	private Security security;

	private Class<? extends Object>  type;

	public WorkController(EntityManagerFactory entitimanager,
			Security security,
			String type) 
					throws ClassNotFoundException {

		this.entitimanager=entitimanager.createEntityManager();

		this.security = security;

		this.type  = Class.forName(type);;

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


	public WorkBaseDto getById(long id) {
		// TODO Auto-generated method stub
		return null;
	}


	public List<WorkBaseDto> getAll(long userId) {
		// TODO Auto-generated method stub
		return null;
	}


	public List<WorkBaseDto> getAllMaching() {
		// TODO Auto-generated method stub
		return null;
	}


	public WorkBaseDto save(WorkBaseDto t) {
		// TODO Auto-generated method stub
		return null;
	}


	public WorkBaseDto delete(WorkBaseDto t) {
		// TODO Auto-generated method stub
		return null;
	}


	public WorkBaseDto deleteMaching(WorkBaseDto t) {
		// TODO Auto-generated method stub
		return null;
	}



}
