package com.sira.api.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.sira.api.security.Security;
import com.sira.model.stateschema.common.AccountVerification;

public class AccountVerificationRepository implements Repository<AccountVerification> {
	
	private static Logger logger = Logger.getLogger(AccountVerificationRepository.class);
	
	private EntityManager entitimanager;

	private Gson gson = new Gson();

	private Security security;

	private Class<? extends Object>  type;

	public AccountVerificationRepository(EntityManager entitimanager, Gson gson, Security security,
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

	@Override
	public AccountVerification getById(long id) {
		
		return null;
	}

	@Override
	public List<AccountVerification> getAll(long userId) {
		
		return null;
	}

	@Override
	public List<AccountVerification> getAllMaching() {
		
		return null;
	}

	@Override
	public AccountVerification save(AccountVerification t) {
		
		return null;
	}

	@Override
	public AccountVerification delete(AccountVerification t) {
		
		return null;
	}

	@Override
	public AccountVerification deleteMaching(AccountVerification t) {
		
		return null;
	}
	
}
