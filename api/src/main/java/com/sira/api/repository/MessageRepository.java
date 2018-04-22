package com.sira.api.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.sira.api.security.Security;
import com.sira.model.stateschema.model.Message;

public class MessageRepository  implements Repository<Message>{
	
	private static Logger logger = Logger.getLogger(MessageRepository.class);
	
	private EntityManager entitimanager;

	private Gson gson = new Gson();

	private Security security;

	private Class<? extends Object>  type;

	public MessageRepository(EntityManager entitimanager, Gson gson, Security security, Class<? extends Object> type) {
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

	@Override
	public Message getById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Message> getAll(long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Message> getAllMaching() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Message save(Message t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Message delete(Message t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Message deleteMaching(Message t) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
