package com.sira.api.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.sira.api.security.Security;
import com.sira.model.stateschema.common.*;

public class AddresRepository implements Repository<Addres> {
	
	private static Logger logger = Logger.getLogger(AddresRepository.class);
	
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
	public Addres getById(long id) {
		
		return null;
	}

	@Override
	public List<Addres> getAll(long userId) {
		
		return null;
	}

	@Override
	public List<Addres> getAllMaching() {
		
		return null;
	}

	@Override
	public Addres save(Addres t) {
		
		return null;
	}

	@Override
	public Addres delete(Addres t) {
		
		return null;
	}

	@Override
	public Addres deleteMaching(Addres t) {
		
		return null;
	}
	
}
