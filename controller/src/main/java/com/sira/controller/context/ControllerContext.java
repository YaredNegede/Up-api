package com.sira.controller.context;

import javax.persistence.EntityManager;

import com.google.gson.Gson;
import com.sira.api.security.Security;

public class ControllerContext {

	private EntityManager entitimanager;

	private Gson gson = new Gson();

	private Security security;

	public ControllerContext(EntityManager entitimanager, Gson gson, Security security) {
		this.entitimanager = entitimanager;
		this.gson = gson;
		this.security = security;
	}

	public EntityManager getEntitimanager() {
		return entitimanager;
	}

	public Gson getGson() {
		return gson;
	}

	public Security getSecurity() {
		return security;
	}
	
}
