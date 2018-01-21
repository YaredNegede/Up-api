package com.sira.api;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.sira.api.error.APIException;
import com.sira.api.error.MSG;
import com.sira.api.security.Security;

public abstract class DataAccess extends Query{

	private EntityManager entitimanager;

	private Gson gson = new Gson();

	private Security security;

	private Class type;

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


	public void Add(JsonElement data) throws APIException {

		try {

			this.getSecurity().check();

			this.getEntitimanager().persist(this.getGson().fromJson(data, this.getType()));

		}catch (Exception e) {

			throw new APIException(MSG.ERROR_SAVING);

		}

	}

	private Class getType() {

		return this.type;
	
	}

	public void Update(JsonElement data) throws APIException {

		try {

			this.getSecurity().check();

			this.getEntitimanager().merge(this.getGson().fromJson(data, this.getType()));

		} catch (Exception e) {

			throw new APIException(MSG.ERROR_UPDATE);

		}

	}

	public void Delete(JsonElement data) throws APIException {

		try {

			this.getSecurity().check();

			Object entity = this.getEntitimanager().find(this.getType(),Long.parseLong(data.getAsString()));

			this.getEntitimanager().remove(entity);

		} catch (Exception e) {

			throw new APIException(MSG.ERROR_REMOVING);

		}	

	}

	public JsonElement View(JsonElement data) throws APIException {

		Object result;

		try {

			this.getSecurity().check();

			result = this.getEntitimanager().find(this.getType(),data.getAsLong());

		}catch (Exception e) {

			throw new APIException(MSG.ERROR_LOOKUP);

		}

		return this.getGson().toJsonTree(result);

	}

	public JsonElement ViewAll(JsonElement data) throws APIException {

		Object result;

		try {

			this.getSecurity().check();

			result = this.getEntitimanager().find(this.getType(),data.getAsLong());

		} catch (Exception e) {

			throw new APIException(MSG.ERROR_LOOKUP);

		}

		return this.getGson().toJsonTree(result);

	}

}
