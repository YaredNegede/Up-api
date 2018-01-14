package com.sira.api;

import javax.persistence.EntityManager;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.sira.api.error.APIException;
import com.sira.api.error.MSG;
import com.sira.api.request.Request;
import com.sira.api.security.Security;

public abstract class DataAccess extends Query{

	private EntityManager entitimanager;

	private Gson gson = new Gson();

	private Security security;

	private Request request;	
	
	public DataAccess(EntityManager entitimanager, Security security,Request request) {

		this.entitimanager = entitimanager;

		this.security = security;
		
		this.request = request;

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

	public Request getRequest() {
		return request;
	}

	public void Add(JsonElement data) throws APIException {

		Request request = this.getGson().fromJson(data, Request.class);

		try {

			this.getSecurity().check(request);

			this.getEntitimanager().persist(this.getGson().fromJson(request.getData(), request.getType()));

		}catch (Exception e) {

			throw new APIException(MSG.ERROR_SAVING);

		}

	}

	public void Update(JsonElement data) throws APIException {

		Request request = this.getGson().fromJson(data, Request.class);

		try {

			this.getSecurity().check(request);

			this.getEntitimanager().merge(this.getGson().fromJson(request.getData(), request.getType()));

		} catch (Exception e) {

			throw new APIException(MSG.ERROR_UPDATE);

		}

	}

	public void Delete(JsonElement data) throws APIException {

		Request request = this.getGson().fromJson(data, Request.class);

		try {

			this.getSecurity().check(request);

			this.getEntitimanager().remove(request.getId());

		} catch (Exception e) {

			throw new APIException(MSG.ERROR_REMOVING);

		}	

	}

	public JsonElement View(JsonElement data) throws APIException {

		Request request = this.getGson().fromJson(data, Request.class);

		Object result;

		try {

			this.getSecurity().check(request);

			result = this.getEntitimanager().find(request.getType(),request.getId());

		}catch (Exception e) {

			throw new APIException(MSG.ERROR_LOOKUP);

		}

		return this.getGson().toJsonTree(result);

	}

	public JsonElement ViewAll(JsonElement data) throws APIException {

		Request request = this.getGson().fromJson(data, Request.class);

		Object result;

		try {

			this.getSecurity().check(request);

			result = this.getEntitimanager().find(request.getType(),request.getId());

		} catch (Exception e) {

			throw new APIException(MSG.ERROR_LOOKUP);

		}

		return this.getGson().toJsonTree(result);

	}

}
