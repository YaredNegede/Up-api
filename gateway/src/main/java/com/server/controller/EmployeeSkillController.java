package com.server.controller;

import org.apache.log4j.Logger;

import com.google.gson.JsonElement;
import com.server.Server;
import com.server.controller.entities.RequestedEntity;
import com.server.error.GateException;
import com.sira.api.DataAccess;
import com.sira.model.stateschema.model.UserBase;

public class EmployeeSkillController extends Server  implements Controller{

	private static final long serialVersionUID = 1L;
	
	private static Logger logger = Logger.getLogger(EmployeeSkillController.class);

	@Override
	public void add(UserBase userBase) throws GateException {
	
		DataAccess dataAccess = null;
		
		try {
			
			dataAccess = (DataAccess) this.getContext().getApplicationContext().getBean(RequestedEntity.Skill.name());
			
			dataAccess.Add(userBase);
			
		} catch (Exception e) {

			logger.error(e);
			
			throw new GateException(e.getLocalizedMessage());
			
		}
		
	}

	@Override
	public JsonElement view(UserBase userBase) throws GateException {
	
		JsonElement je;

		try {

			DataAccess dataAccess = (DataAccess) this.getContext().getApplicationContext().getBean(RequestedEntity.Skill.name());
			
			
			UserBase uBase = dataAccess.View(userBase);
			
			je = this.getContext().getGson().toJsonTree(uBase);
			
			logger.debug(je);
			 
		} catch (Exception e) {

			logger.error(e);
			
			throw new GateException(e.getLocalizedMessage());
			
		}
		
		return je;
	}

	@Override
	public void update(UserBase userBase) throws GateException {
		
		try {

			DataAccess dataAccess = (DataAccess) this.getContext().getApplicationContext().getBean(RequestedEntity.Skill.name());
			
			dataAccess.Update(userBase);
			
			
		} catch (Exception e) {

			logger.error(e);
			
			throw new GateException(e.getLocalizedMessage());
			
		}
		
	}

	@Override
	public void delete(UserBase userBase) throws GateException {
		
		try {

			DataAccess dataAccess = (DataAccess) this.getContext().getApplicationContext().getBean(RequestedEntity.Skill.name());
			
			dataAccess.Delete(userBase);
			
			
		} catch (Exception e) {

			logger.error(e);
			
			throw new GateException(e.getLocalizedMessage());
			
			
		}
		
	}
	
}
