package com.sira.controller;

import java.util.List;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.sira.api.security.Security;
import com.sira.dto.employee.EmployeeReviewDto;

public class EmployeeReviewController implements Controller<EmployeeReviewDto>{

	private static Logger logger = Logger.getLogger(EmployeeReviewController.class);

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

	public EmployeeReviewController(EntityManager entitimanager, Gson gson, Security security,
			Class<? extends Object> type) {
		super();
		this.entitimanager = entitimanager;
		this.gson = gson;
		this.security = security;
		this.type = type;
	}

	public EmployeeReviewDto getById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<EmployeeReviewDto> getAll(long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<EmployeeReviewDto> getAllMaching() {
		// TODO Auto-generated method stub
		return null;
	}

	public EmployeeReviewDto save(EmployeeReviewDto t) {
		// TODO Auto-generated method stub
		return null;
	}

	public EmployeeReviewDto delete(EmployeeReviewDto t) {
		// TODO Auto-generated method stub
		return null;
	}

	public EmployeeReviewDto deleteMaching(EmployeeReviewDto t) {
		// TODO Auto-generated method stub
		return null;
	}


}
