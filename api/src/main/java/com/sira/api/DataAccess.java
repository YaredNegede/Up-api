package com.sira.api;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.sira.api.error.APIException;
import com.sira.api.request.ViewAllquery;
import com.sira.api.security.Security;

public abstract class DataAccess {

	private EntityManager entitimanager;

	private Gson gson = new Gson();

	private Security security;

	private Class<? extends Object>  type;

	public DataAccess(EntityManagerFactory entitimanager, Security security, String type) throws ClassNotFoundException {

		this.entitimanager = entitimanager.createEntityManager();

		this.security = security;

		this.type = Class.forName(type);

	}

	public EntityManager getEntitimanager() {

		return this.entitimanager;

	}

	public Security getSecurity() {

		return this.security;

	}

	public Gson getGson() {
	
		return gson;
		
	}

	private Class<? extends Object> getType() {

		return this.type;

	}

	public abstract void Add(JsonElement data) throws APIException ;

	public abstract void Update(JsonElement data) throws APIException ;

	public abstract void Delete(JsonElement data) throws APIException ;

	public abstract JsonElement View(JsonElement data) throws APIException;

	public abstract JsonElement ViewAll(JsonElement data) throws APIException ;

}
