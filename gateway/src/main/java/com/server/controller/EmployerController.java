package com.server.controller;

import org.apache.log4j.Logger;

import com.google.gson.JsonElement;
import com.server.ResourceRequest;
import com.server.ResourceResponce;
import com.server.Server;
import com.server.error.GateException;
import com.sira.api.DataAccess;
import com.sira.api.error.APIException;
import com.sira.api.request.RequestEntity;

public class EmployerController extends Server {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(EmployerController.class);

	public void add(ResourceRequest resourceRequest) throws GateException {

		try {

			DataAccess dataAccess = (DataAccess) this.getContext().getApplicationContext().getBean(RequestEntity.Employer.name());

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

			DataAccess dataAccess = (DataAccess) this.getContext().getApplicationContext().getBean(RequestEntity.Employer.name());

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

			DataAccess dataAccess = (DataAccess) this.getContext().getApplicationContext().getBean(RequestEntity.Employer.name());

			dataAccess.Update(resourceRequest.getJsonElement());

		} catch (APIException e) {

			logger.error(e);

			throw new GateException(e.getLocalizedMessage());
			
		}

	}

	@Override
	public void delete(ResourceRequest resourceRequest) throws GateException {

		try {

			DataAccess dataAccess = (DataAccess) this.getContext().getApplicationContext().getBean(RequestEntity.Employer.name());

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

			DataAccess dataAccess = (DataAccess) this.getContext().getApplicationContext().getBean(RequestEntity.Employer.name());

			je = dataAccess.ViewAll(resourceRequest.getJsonElement());

		} catch (APIException e) {

			logger.error(e);
			
			throw new GateException(e.getLocalizedMessage());

		}

		return je;
	}

}
