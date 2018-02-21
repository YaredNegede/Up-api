package com.server.controller;

import org.apache.log4j.Logger;

import com.google.gson.JsonElement;
import com.server.ResourceRequest;
import com.server.ResourceResponce;
import com.server.Server;
import com.server.error.GateException;
import com.sira.api.DataAccess;
import com.sira.api.request.RequestedEntity;

public class EmployeeProfileController extends Server{

	private static final long serialVersionUID = 1L;
	
	private static Logger logger = Logger.getLogger(EmployeeProfileController.class);

	@Override
	public void add(ResourceRequest resourceRequest) throws GateException {
	
		DataAccess dataAccess = null;
		
		try {
			
			dataAccess = (DataAccess) this.getContext().getApplicationContext().getBean(RequestedEntity.Employee.name());

			logger.info("recieved request [ "+resourceRequest.getJsonElement()+" ]");
			
			dataAccess.Add(resourceRequest.getJsonElement());
			
		} catch (Exception e) {

			throw new GateException(e.getLocalizedMessage());
			
		}
		
	}

	@Override
	public JsonElement view(ResourceRequest resourceRequest) throws GateException {
	
		JsonElement je;

		try {

			DataAccess dataAccess = (DataAccess) this.getContext().getApplicationContext().getBean(RequestedEntity.Employee.name());
			
			JsonElement jem = dataAccess.View(resourceRequest.getJsonElement());
			
			ResourceResponce resourceResponce = new ResourceResponce("Employee foound ", "OK", jem);
			
			je = this.getContext().getGson().toJsonTree(resourceResponce);
			
			logger.debug(jem);
			 
		} catch (Exception e) {

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
			
			je = dataAccess.ViewAll(resourceRequest.getJsonElement());
			
			resourceResponce = new ResourceResponce("", "OK", je);
			
			logger.debug(je);
			
		} catch (Exception e) {

			logger.error(e);
			
			resourceResponce = new ResourceResponce("", "ERROR", null);
			
			throw new GateException(e.getLocalizedMessage());
			
			
		}
		
		return je;
	}

	@Override
	public void update(ResourceRequest resourceRequest) throws GateException {
		
		try {

			DataAccess dataAccess = (DataAccess) this.getContext().getApplicationContext().getBean(RequestedEntity.Employee.name());
			
			logger.debug(resourceRequest.getJsonElement());
			
			dataAccess.Update(resourceRequest.getJsonElement());
			
			
		} catch (Exception e) {

			logger.error(e);
			
			throw new GateException(e.getLocalizedMessage());
			
		}
		
	}

	@Override
	public void delete(ResourceRequest resourceRequest) throws GateException {
		
		try {

			DataAccess dataAccess = (DataAccess) this.getContext().getApplicationContext().getBean(RequestedEntity.Employee.name());
			
			logger.debug(resourceRequest.getJsonElement());
			
			dataAccess.Delete(resourceRequest.getJsonElement());
			
			
		} catch (Exception e) {

			logger.error(e);
			
			throw new GateException(e.getLocalizedMessage());
			
			
		}
		
	}

	
}
