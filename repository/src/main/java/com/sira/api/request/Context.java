package com.sira.api.request;

import org.springframework.context.ApplicationContext;

import com.google.gson.Gson;

public class Context {

	protected ApplicationContext applicationContext;

	public Context(ApplicationContext applicationContext) {

		this.applicationContext = applicationContext;

	}

	public Gson getGson() {

		return new Gson();

	}

	public ApplicationContext getApplicationContext() {

		return applicationContext;

	}

}
