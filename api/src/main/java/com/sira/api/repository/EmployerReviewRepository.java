package com.sira.api.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.sira.api.security.Security;
import com.sira.model.stateschema.model.EmployerReview;

public class EmployerReviewRepository implements Repository<EmployerReview>{

	private static Logger logger = Logger.getLogger(EmployerReviewRepository.class);
	
	private EntityManager entitimanager;

	private Gson gson = new Gson();

	private Security security;

	private Class<? extends Object>  type;

	public EmployerReviewRepository(EntityManager entitimanager, Gson gson, Security security, Class<? extends Object> type) {
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
	public EmployerReview getById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmployerReview> getAll(long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmployerReview> getAllMaching() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmployerReview save(EmployerReview t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmployerReview delete(EmployerReview t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmployerReview deleteMaching(EmployerReview t) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
