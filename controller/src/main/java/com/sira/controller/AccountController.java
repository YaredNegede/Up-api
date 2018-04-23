package com.sira.controller;

import java.util.List;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.sira.api.security.Security;
import com.sira.dto.employee.AccountDto;

public class AccountController implements Controller<AccountDto>{
	
	private static Logger logger = Logger.getLogger(AccountController.class);
	
	private EntityManager entitimanager;

	private Gson gson = new Gson();

	private Security security;

	private Class<? extends Object>  type;

	public AccountController(EntityManager entitimanager, Gson gson, Security security, Class<? extends Object> type) {
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

	public AccountDto getById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<AccountDto> getAll(long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<AccountDto> getAllMaching() {
		// TODO Auto-generated method stub
		return null;
	}

	public AccountDto save(AccountDto t) {
		// TODO Auto-generated method stub
		return null;
	}

	public AccountDto delete(AccountDto t) {
		// TODO Auto-generated method stub
		return null;
	}

	public AccountDto deleteMaching(AccountDto t) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
