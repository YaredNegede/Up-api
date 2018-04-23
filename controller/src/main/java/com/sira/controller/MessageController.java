package com.sira.controller;

import java.util.List;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.sira.api.security.Security;
import com.sira.dto.common.MessageDto;

public class MessageController  implements Controller<MessageDto>{
	
	private static Logger logger = Logger.getLogger(MessageController.class);
	
	private EntityManager entitimanager;

	private Gson gson = new Gson();

	private Security security;

	private Class<? extends Object>  type;

	public MessageController(EntityManager entitimanager, Gson gson, Security security, Class<? extends Object> type) {
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

	public MessageDto getById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<MessageDto> getAll(long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<MessageDto> getAllMaching() {
		// TODO Auto-generated method stub
		return null;
	}

	public MessageDto save(MessageDto t) {
		// TODO Auto-generated method stub
		return null;
	}

	public MessageDto delete(MessageDto t) {
		// TODO Auto-generated method stub
		return null;
	}

	public MessageDto deleteMaching(MessageDto t) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
