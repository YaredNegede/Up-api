package com.sira.api.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.sira.api.security.Security;
import com.sira.model.stateschema.model.EmployeeReview;

public class EmployeeReviewRepository implements Repository<EmployeeReview>{

	private static Logger logger = Logger.getLogger(EmployeeReviewRepository.class);

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

	public EmployeeReviewRepository(EntityManager entitimanager, Gson gson, Security security,
			Class<? extends Object> type) {
		super();
		this.entitimanager = entitimanager;
		this.gson = gson;
		this.security = security;
		this.type = type;
	}

	@Override
	public EmployeeReview getById(long id) {

		return null;
	}

	@Override
	public List<EmployeeReview> getAll(long userId) {

		return null;
	}

	@Override
	public List<EmployeeReview> getAllMaching() {

		return null;
	}

	@Override
	public EmployeeReview save(EmployeeReview t) {

		return null;
	}

	@Override
	public EmployeeReview delete(EmployeeReview t) {

		return null;
	}

	@Override
	public EmployeeReview deleteMaching(EmployeeReview t) {

		return null;
	}

}
