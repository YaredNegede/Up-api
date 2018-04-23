package com.sira.controller;

import java.util.List;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.sira.api.security.Security;
import com.sira.dto.employee.AccountVerificationDto;

public class AccountVerificationController implements Controller<AccountVerificationDto> {
	
	private static Logger logger = Logger.getLogger(AccountVerificationController.class);
	
	private EntityManager entitimanager;

	private Gson gson = new Gson();

	private Security security;

	private Class<? extends Object>  type;

	public AccountVerificationController(EntityManager entitimanager, Gson gson, Security security,
			Class<? extends Object> type) {
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

	public AccountVerificationDto getById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<AccountVerificationDto> getAll(long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<AccountVerificationDto> getAllMaching() {
		// TODO Auto-generated method stub
		return null;
	}

	public AccountVerificationDto save(AccountVerificationDto t) {
		// TODO Auto-generated method stub
		return null;
	}

	public AccountVerificationDto delete(AccountVerificationDto t) {
		// TODO Auto-generated method stub
		return null;
	}

	public AccountVerificationDto deleteMaching(AccountVerificationDto t) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
