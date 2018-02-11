package com.server.controller;

import org.apache.log4j.Logger;
import org.springframework.http.RequestEntity;

import com.google.gson.JsonElement;
import com.server.ResourceRequest;
import com.server.Server;
import com.server.error.GateException;
import com.sira.api.DataAccess;
import com.sira.api.error.APIException;
import com.sira.api.request.RequestedEntity;

public class ProjectController extends Server {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(ProjectController.class);

	public void add(ResourceRequest resourceRequest) throws GateException {

		try {

			DataAccess dataAccess = (DataAccess) this.getContext().getApplicationContext().getBean(RequestedEntity.Project.name());

			dataAccess.Add(resourceRequest.getJsonElement());

		} catch (APIException e) {

			logger.error(e);
			
			throw new GateException(e.getLocalizedMessage());

		}

	}

	@Override
	public JsonElement view(ResourceRequest resourceRequest) throws GateException {

		JsonElement je = null;

		try {

			DataAccess dataAccess = (DataAccess) this.getContext().getApplicationContext().getBean(RequestedEntity.Employer.name());

			je = dataAccess.View(resourceRequest.getJsonElement());

		} catch (APIException e) {

			logger.error(e);
			
			throw new GateException(e.getLocalizedMessage());

		}

		return je;
	}

	@Override
	public void update(ResourceRequest resourceRequest) throws GateException {

		try {

			DataAccess dataAccess = (DataAccess) this.getContext().getApplicationContext().getBean(RequestedEntity.Project.name());

			dataAccess.Update(resourceRequest.getJsonElement());

		} catch (APIException e) {

			logger.error(e);

			throw new GateException(e.getLocalizedMessage());
			
		}

	}

	@Override
	public void delete(ResourceRequest resourceRequest) throws GateException {


		try {

			DataAccess dataAccess = (DataAccess) this.getContext().getApplicationContext().getBean(RequestedEntity.Project.name());

			dataAccess.Delete(resourceRequest.getJsonElement());

		} catch (APIException e) {

			logger.error(e);

			throw new GateException(e.getLocalizedMessage());

		}


	}

	@Override
	public JsonElement viewAll(ResourceRequest resourceRequest) throws GateException {

		JsonElement je = null;

		try {

			DataAccess dataAccess = (DataAccess) this.getContext().getApplicationContext().getBean(RequestedEntity.Project.name());

			je = dataAccess.ViewAll(resourceRequest.getJsonElement());

		} catch (APIException e) {

			logger.error(e);

			throw new GateException(e.getLocalizedMessage());

		}

		return je;
	}


	@Override
	public void addSkill(ResourceRequest resourceRequest) throws GateException {
		
		
	}
	

	@Override
	public void addProfile(ResourceRequest resourceRequest) throws GateException {
		
		
	}
	

	@Override
	public JsonElement viewSkill(ResourceRequest resourceRequest) throws GateException {
		
		return null;
	}
	

	@Override
	public JsonElement viewProfile(ResourceRequest resourceRequest) throws GateException {
		
		return null;
	}
	

	@Override
	public JsonElement updateSkill(ResourceRequest resourceRequest) throws GateException {
		
		return null;
	}
	

	@Override
	public JsonElement updateProfile(ResourceRequest resourceRequest) throws GateException {
		
		return null;
	}
	

	@Override
	public void deleteSkill(ResourceRequest resourceRequest) throws GateException {
		
		
	}
	

	@Override
	public void deleteProfile(ResourceRequest resourceRequest) throws GateException {
		
		
	}

}
