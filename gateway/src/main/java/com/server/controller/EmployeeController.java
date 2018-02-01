package com.server.controller;

import org.apache.log4j.Logger;

import com.google.gson.JsonElement;
import com.server.ResourceRequest;
import com.server.ResourceResponce;
import com.server.Server;
import com.server.error.GateException;
import com.sira.api.DataAccess;
import com.sira.api.error.APIException;
import com.sira.api.request.RequestedEntity;

public class EmployeeController extends Server{

	private static final long serialVersionUID = 1L;
	
	private static Logger logger = Logger.getLogger(EmployeeController.class);

	@Override
	public void add(ResourceRequest resourceRequest) throws GateException {
	
		DataAccess dataAccess = null;
		
		try {
			
			dataAccess = (DataAccess) this.getContext().getApplicationContext().getBean(RequestedEntity.Employee.name());

			logger.info("recieved request [ "+resourceRequest.getJsonElement()+" ]");
			
			dataAccess.Add(resourceRequest.getJsonElement());
			
		} catch (APIException e) {

			throw new GateException(e.getLocalizedMessage());
			
		}
		
	}

	@Override
	public JsonElement view(ResourceRequest resourceRequest) throws GateException {
	
		JsonElement je;
		
		try {

			DataAccess dataAccess = (DataAccess) this.getContext().getApplicationContext().getBean(RequestedEntity.Employee.name());
			
			je = dataAccess.View(resourceRequest.getJsonElement());
			 
		} catch (APIException e) {

			logger.error(e);
			
			throw new GateException(e.getLocalizedMessage());
			
		}
		
		return je;
	}

	@Override
	public JsonElement viewAll(ResourceRequest resourceRequest) throws GateException {
	
		JsonElement je;
		
		ResourceResponce resourceResponce ;
		
		DataAccess dataAccess = null;
		
		try {

			dataAccess = (DataAccess) this.getContext().getApplicationContext().getBean(RequestedEntity.Employee.name());
			
			dataAccess.getEntitimanager().getTransaction().begin();
			
			je = dataAccess.ViewAll(resourceRequest.getJsonElement());
			
			resourceResponce = new ResourceResponce("", "OK", je);
			
			dataAccess.getEntitimanager().getTransaction().commit();
			
		} catch (APIException e) {

			logger.error(e);
			
			resourceResponce = new ResourceResponce("", "ERROR", null);
			
			dataAccess.getEntitimanager().getTransaction().rollback();
			
			throw new GateException(e.getLocalizedMessage());
			
			
		}
		
		return je;
	}

	@Override
	public void update(ResourceRequest resourceRequest) throws GateException {
		
		try {

			DataAccess dataAccess = (DataAccess) this.getContext().getApplicationContext().getBean(RequestedEntity.Employee.name());
			
			dataAccess.Update(resourceRequest.getJsonElement());
			
			
		} catch (APIException e) {

			logger.error(e);
			
			throw new GateException(e.getLocalizedMessage());
			
		}
		
	}

	@Override
	public void delete(ResourceRequest resourceRequest) throws GateException {
		
		try {

			DataAccess dataAccess = (DataAccess) this.getContext().getApplicationContext().getBean(RequestedEntity.Employee.name());
			
			dataAccess.Delete(resourceRequest.getJsonElement());
			
			
		} catch (APIException e) {

			logger.error(e);
			
			throw new GateException(e.getLocalizedMessage());
			
			
		}
		
	}

}
