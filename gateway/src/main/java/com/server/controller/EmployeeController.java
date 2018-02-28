package com.server.controller;

import org.apache.log4j.Logger;

import com.google.gson.JsonElement;
import com.server.Server;
import com.server.error.GateException;
import com.sira.api.DataAccess;
import com.sira.api.request.RequestedEntity;
import com.sira.model.stateschema.model.UserBase;

public class EmployeeController extends Server   implements Controller{

	private static final long serialVersionUID = 1L;
	
	private static Logger logger = Logger.getLogger(EmployeeController.class);

	@Override
	public void add(UserBase userBase) throws GateException {
	
		DataAccess dataAccess = null;
		
		try {
			
			dataAccess = (DataAccess) this.getContext().getApplicationContext().getBean(RequestedEntity.Employee.name());

			dataAccess.Add(userBase);
			
		} catch (Exception e) {

			throw new GateException(e.getLocalizedMessage());
			
		}
		
	}

	@Override
	public JsonElement view(UserBase userBase) throws GateException {
	
		JsonElement je;

		try {

			DataAccess dataAccess = (DataAccess) this.getContext().getApplicationContext().getBean(RequestedEntity.Employee.name());
			
			UserBase base = dataAccess.View(userBase);
			
			je = this.getContext().getGson().toJsonTree(base);
			
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

			DataAccess dataAccess = (DataAccess) this.getContext().getApplicationContext().getBean(RequestedEntity.Employee.name());
			
			dataAccess.Update(userBase);
			
			
		} catch (Exception e) {

			logger.error(e);
			
			throw new GateException(e.getLocalizedMessage());
			
		}
		
	}

	@Override
	public void delete(UserBase userBase) throws GateException {
		
		try {

			DataAccess dataAccess = (DataAccess) this.getContext().getApplicationContext().getBean(RequestedEntity.Employee.name());
			
			dataAccess.Delete(userBase);
			
			
		} catch (Exception e) {

			logger.error(e);
			
			throw new GateException(e.getLocalizedMessage());
			
			
		}
		
	}
}
