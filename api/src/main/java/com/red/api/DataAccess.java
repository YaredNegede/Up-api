package com.red.api;

import javax.persistence.EntityManager;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.red.api.error.APIException;
import com.red.api.error.MSG;
import com.red.api.request.Request;

public abstract class DataAccess extends Query{

	private static EntityManager entitimanager;
 
	private Gson gson = new Gson();
	
	public DataAccess(EntityManager entitimanager) {
		
		DataAccess.entitimanager = entitimanager;
		
	}

	public EntityManager getEntitimanager() {
		
		return DataAccess.entitimanager;
		
	}

	public Gson getGson() {
		return gson;
	}

	public void Add(JsonElement data) throws APIException {

		Request request = this.getGson().fromJson(data, Request.class);
		
		try {
		
			this.getEntitimanager().persist(this.getGson().fromJson(request.getData(), request.getType()));
		
		}catch (Exception e) {
			
			throw new APIException(MSG.ERROR_SAVING);
			
		}
		
	}

	public void Update(JsonElement data) throws APIException {

		Request request = this.getGson().fromJson(data, Request.class);
		
		try {
			
			this.getEntitimanager().merge(this.getGson().fromJson(request.getData(), request.getType()));
			
		} catch (Exception e) {
			
			throw new APIException(MSG.ERROR_UPDATE);
			
		}
		
	}

	public void Delete(JsonElement data) throws APIException {

		Request request = this.getGson().fromJson(data, Request.class);
		
		try {
			this.getEntitimanager().remove(request.getId());
		} catch (Exception e) {
			
			throw new APIException(MSG.ERROR_REMOVING);
			
		}	
		
	}

	public JsonElement View(JsonElement data) throws APIException {
		
		Request request = this.getGson().fromJson(data, Request.class);
		
		Object result;
		
		try {
			
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
			
			result = this.getEntitimanager().find(request.getType(),request.getId());
			
		} catch (Exception e) {
			
			throw new APIException(MSG.ERROR_LOOKUP);
			
		}
		
		return this.getGson().toJsonTree(result);
		
	}

}
