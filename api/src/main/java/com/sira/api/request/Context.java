package com.sira.api.request;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.Map;

import org.springframework.context.ApplicationContext;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.sira.api.DataAccess;
import com.sira.api.error.APIException;

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
	 * @throws APIException 
	 */
	public JsonElement process(BufferedReader reader, PrintWriter writer) throws APIException {

		JsonElement ret = null;

		try {

			Request request = this.getGson().fromJson(reader, Request.class);
			
			Class<? extends Object> api = APIFactory.getMapping().get(request.getOperation());
			
			DataAccess da = (DataAccess) api.newInstance();
			
			da.process(this.getGson().toJsonTree(request));
			

		} catch (JsonSyntaxException e) {

			APIException ex = new APIException(e.getMessage());

			throw ex;

		} catch (JsonIOException e) {

			APIException ex = new APIException(e.getMessage());

			throw ex;

		} catch (InstantiationException e) {
			
			APIException ex = new APIException(e.getMessage());

			throw ex;
			
		} catch (IllegalAccessException e) {

			APIException ex = new APIException(e.getMessage());

			throw ex;
		}


		return ret;
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
