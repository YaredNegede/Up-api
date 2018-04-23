package com.sira.controller;

import java.util.List;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.sira.api.security.Security;
import com.sira.dto.employer.EmployerPortoFolioDto;

public class EmployerPortoFolioController implements Controller<EmployerPortoFolioDto>{

	private static Logger logger = Logger.getLogger(EmployerPortoFolioController.class);
	
	private EntityManager entitimanager;

	private Gson gson = new Gson();

	private Security security;

	private Class<? extends Object>  type;

	public EmployerPortoFolioController(EntityManager entitimanager, Gson gson, Security security, Class<? extends Object> type) {
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

	public EmployerPortoFolioDto getById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<EmployerPortoFolioDto> getAll(long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<EmployerPortoFolioDto> getAllMaching() {
		// TODO Auto-generated method stub
		return null;
	}

	public EmployerPortoFolioDto save(EmployerPortoFolioDto t) {
		// TODO Auto-generated method stub
		return null;
	}

	public EmployerPortoFolioDto delete(EmployerPortoFolioDto t) {
		// TODO Auto-generated method stub
		return null;
	}

	public EmployerPortoFolioDto deleteMaching(EmployerPortoFolioDto t) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
