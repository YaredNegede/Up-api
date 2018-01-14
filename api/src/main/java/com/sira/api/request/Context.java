package com.sira.api.request;

import java.io.BufferedReader;
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

	/**
	 * read from input stream and create responce
	 * @param in
	 * @return
	 */
	public JsonElement process(BufferedReader in) {
		return null;
	}

	public Gson getGson() {
		
		return new Gson();
		
	}

	public Map<API, String> getDataAccess() {
		
		return this.dataAccess;
		
	}

	public ApplicationContext getApplicationContext() {

		return applicationContext;
		
	}

}
