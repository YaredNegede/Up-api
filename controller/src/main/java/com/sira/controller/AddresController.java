package com.sira.controller;

import java.util.List;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.sira.api.security.Security;
import com.sira.dto.employee.AddresDto;

public class AddresController implements Controller<AddresDto> {
	
	private static Logger logger = Logger.getLogger(AddresController.class);
	
	private EntityManager entitimanager;

	private Gson gson = new Gson();

	private Security security;

	private Class<? extends Object>  type;

	public AddresController(EntityManager entitimanager, Gson gson, Security security, Class<? extends Object> type) {
		super();
		this.entitimanager = entitimanager;
		this.gson = gson;
		this.security = security;
		this.type = type;
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

	public Class<? extends Object> getType() {
		return type;
	}

	public AddresDto getById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<AddresDto> getAll(long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<AddresDto> getAllMaching() {
		// TODO Auto-generated method stub
		return null;
	}

	public AddresDto save(AddresDto t) {
		// TODO Auto-generated method stub
		return null;
	}

	public AddresDto delete(AddresDto t) {
		// TODO Auto-generated method stub
		return null;
	}

	public AddresDto deleteMaching(AddresDto t) {
		// TODO Auto-generated method stub
		return null;
	}


	
}
