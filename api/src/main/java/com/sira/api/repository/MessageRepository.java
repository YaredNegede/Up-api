package com.sira.api.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.sira.api.repository.error.UplancerException;
import com.sira.api.security.Security;
import com.sira.model.stateschema.common.Message;

public class MessageRepository  extends Repository<Message>{

	private static Logger logger = Logger.getLogger(MessageRepository.class);

	@Override
	public Message getById(long id) throws UplancerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Message> getAll() throws UplancerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Message> getAllMaching(Message t) throws UplancerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Message t) throws UplancerException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Message t) throws UplancerException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteMaching(Message t) throws UplancerException {
		// TODO Auto-generated method stub
		
	}
	
}
