package com.red.api.request;

import java.util.Map;

import org.springframework.context.ApplicationContext;

import com.google.gson.Gson;
import com.google.gson.JsonElement;

public class Context {

	private Map<API,String> dataAccess;

	private ApplicationContext applicationContext;
	
	public Context(ApplicationContext applicationContext) {

		this.applicationContext = applicationContext;
	
	}

	public JsonElement process() {
		return null;
	}

	public Gson getGson() {
		return new Gson();
	}

	public Map<API, String> getDataAccess() {
		return this.dataAccess;
	}

	public void setDataAccess(Map<API, String> dataAccess) {
		this.dataAccess = dataAccess;
	}

}
