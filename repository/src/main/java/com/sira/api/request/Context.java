package com.sira.api.request;

import org.springframework.context.ApplicationContext;

public class Context {

	protected ApplicationContext applicationContext;

	public Context(ApplicationContext applicationContext) {

		this.applicationContext = applicationContext;

	}


	public ApplicationContext getApplicationContext() {

		return applicationContext;

	}

}
