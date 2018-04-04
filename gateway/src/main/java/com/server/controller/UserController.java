package com.server.controller;

import java.sql.Timestamp;
import java.time.Instant;

import org.apache.log4j.Logger;

import com.google.gson.JsonElement;
import com.server.Server;
import com.server.controller.email.Emailer;
import com.server.controller.entities.RequestedEntity;
import com.server.error.GateException;
import com.sira.api.DataAccess;
import com.sira.model.stateschema.model.UserBase;

public class UserController extends Server   implements Controller{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static Logger logger = Logger.getLogger(UserController.class);

	@Override
	public void add(UserBase userBase) throws GateException {

		try {

		
			
			Emailer emailer = (Emailer) this.getContext().getApplicationContext().getBean(RequestedEntity.User.name());
			
			emailer.sendTokenLint(userBase);
			

		} catch (Exception e) {

			logger.error(e);

			throw new GateException(e.getLocalizedMessage());

		}

	}

	@Override
	public JsonElement view(UserBase userBase) throws GateException {

		JsonElement je = null;
		
		try {

			DataAccess dataAccess = (DataAccess) this.getContext().getApplicationContext().getBean(RequestedEntity.User.name());

			UserBase uBase  = dataAccess.View(userBase);
			
			if(!uBase.getUser().getStatus()){
			
				throw new GateException("User not active");
				
			}
			
			je = this.getContext().getGson().toJsonTree(uBase);

		} catch (Exception e) {

			logger.error(e);
			
			throw new GateException(e.getLocalizedMessage());
			
		}
		
		return je;
		
	}

	@Override
	public void update(UserBase userBase) throws GateException {

		try {

			DataAccess dataAccess = (DataAccess) this.getContext().getApplicationContext().getBean(RequestedEntity.User.name());

			Timestamp now = Timestamp.from(Instant.now());
			
			UserBase foundUbase = dataAccess.View(userBase);
			
			if(userBase.getUser().getStatusToken().equals(foundUbase.getUser().getStatusToken())){
				
				userBase.getUser().setStatus(true);
				
				dataAccess.Update(userBase);

			} if (userBase.getUser().getExpireTime().before(now)) {
				
				dataAccess.Delete(userBase);
				
				throw new GateException("token expired, sign up again");
				
			} else {
				
				throw new GateException("Invalid Token");
				
			}

		} catch (Exception e) {

			logger.error(e);

			throw new GateException(e.getLocalizedMessage());
			
		}

	}

	@Override
	public void delete(UserBase userBase) throws GateException {

		try {

			DataAccess dataAccess = (DataAccess) this.getContext().getApplicationContext().getBean(RequestedEntity.User.name());

			dataAccess.Delete(userBase);

		} catch (Exception e) {

			logger.error(e);

			throw new GateException(e.getLocalizedMessage());
			
		}

	}

}
