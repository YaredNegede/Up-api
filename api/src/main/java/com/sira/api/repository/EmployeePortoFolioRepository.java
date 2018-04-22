package com.sira.api.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.sira.api.security.Security;
import com.sira.model.stateschema.model.EmployeePortoFolio;

public class EmployeePortoFolioRepository implements Repository<EmployeePortoFolio>{

	private static Logger logger = Logger.getLogger(EmployeePortoFolioRepository.class);
	
	private EntityManager entitimanager;

	private Gson gson = new Gson();

	private Security security;

	private Class<? extends Object>  type;

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
	public EmployeePortoFolio getById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmployeePortoFolio> getAll(long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmployeePortoFolio> getAllMaching() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmployeePortoFolio save(EmployeePortoFolio t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmployeePortoFolio delete(EmployeePortoFolio t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmployeePortoFolio deleteMaching(EmployeePortoFolio t) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
