package com.sira.api.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.sira.api.security.Security;
import com.sira.model.stateschema.model.Account;

public class AccountRepository implements Repository<Account>{
	
	private static Logger logger = Logger.getLogger(AccountRepository.class);
	
	private EntityManager entitimanager;

	private Gson gson = new Gson();

	private Security security;

	private Class<? extends Object>  type;

	public AccountRepository(EntityManager entitimanager, Gson gson, Security security, Class<? extends Object> type) {
		this.entitimanager = entitimanager;
		this.gson = gson;
		this.security = security;
		this.type = type;
	}
	
	@Override
	public Account getById(long id) {
		
		return null;
	}

	@Override
	public List<Account> getAll(long userId) {
		
		return null;
	}

	@Override
	public List<Account> getAllMaching() {
		
		return null;
	}

	@Override
	public Account save(Account t) {
		
		return null;
	}

	@Override
	public Account delete(Account t) {
		
		return null;
	}

	@Override
	public Account deleteMaching(Account t) {
		
		return null;
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
