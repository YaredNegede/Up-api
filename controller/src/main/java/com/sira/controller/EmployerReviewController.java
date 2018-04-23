package com.sira.controller;

import java.util.List;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.sira.api.security.Security;
import com.sira.dto.employer.EmployerReviewDto;

public class EmployerReviewController implements Controller<EmployerReviewDto>{

	private static Logger logger = Logger.getLogger(EmployerReviewController.class);
	
	private EntityManager entitimanager;

	private Gson gson = new Gson();

	private Security security;

	private Class<? extends Object>  type;

	public EmployerReviewController(EntityManager entitimanager, Gson gson, Security security, Class<? extends Object> type) {
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

	public EmployerReviewDto getById(long id) {
		
		return null;
	}

	public List<EmployerReviewDto> getAll(long userId) {
		
		return null;
	}

	public List<EmployerReviewDto> getAllMaching() {
		
		return null;
	}

	public EmployerReviewDto save(EmployerReviewDto t) {
		
		return null;
	}

	public EmployerReviewDto delete(EmployerReviewDto t) {
		
		return null;
	}

	public EmployerReviewDto deleteMaching(EmployerReviewDto t) {
		
		return null;
	}

	
}
