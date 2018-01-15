package com.server.controller;

import org.apache.log4j.Logger;

import com.server.ResourceRequest;
import com.server.ResourceResponce;
import com.server.Server;
import com.server.error.GateException;
import com.sira.api.DataAccess;
import com.sira.api.error.APIException;
import com.sira.api.request.RequestEntity;

public class ProjectController extends Server {

	private static final long serialVersionUID = 7963058373408515467L;

	private static Logger logger = Logger.getLogger(ProjectController.class);
	
	public ResourceResponce add(ResourceRequest resourceRequest) throws GateException {

		ResourceResponce resourceResponce = new ResourceResponce();

		try {

			DataAccess dataAccess = (DataAccess) this.getContext().getApplicationContext().getBean(RequestEntity.Project.name());

			dataAccess.Add(resourceRequest.getJsonElement());

		} catch (APIException e) {

			logger.error(e);

			resourceResponce.setMessage(e.getMessage());


		}

		return resourceResponce;
	}

	@Override
	public ResourceResponce view(ResourceRequest resourceRequest) throws GateException {

		ResourceResponce resourceResponce = new ResourceResponce();

		try {

			DataAccess dataAccess = (DataAccess) this.getContext().getApplicationContext().getBean(RequestEntity.Employer.name());

			dataAccess.View(resourceRequest.getJsonElement());

		} catch (APIException e) {

			logger.error(e);

			resourceResponce.setMessage(e.getMessage());


		}

		return resourceResponce;
	}

	@Override
	public ResourceResponce update(ResourceRequest resourceRequest) throws GateException {

		ResourceResponce resourceResponce = new ResourceResponce();

		try {

			DataAccess dataAccess = (DataAccess) this.getContext().getApplicationContext().getBean(RequestEntity.Project.name());

			dataAccess.Update(resourceRequest.getJsonElement());

		} catch (APIException e) {

			logger.error(e);

			resourceResponce.setMessage(e.getMessage());


		}

		return resourceResponce;

	}

	@Override
	public ResourceResponce delete(ResourceRequest resourceRequest) throws GateException {

		ResourceResponce resourceResponce = new ResourceResponce();

		try {

			DataAccess dataAccess = (DataAccess) this.getContext().getApplicationContext().getBean(RequestEntity.Project.name());

			dataAccess.Delete(resourceRequest.getJsonElement());

		} catch (APIException e) {

			logger.error(e);

			resourceResponce.setMessage(e.getMessage());


		}

		return resourceResponce;
		
	}

	@Override
	public ResourceResponce viewAll(ResourceRequest resourceRequest) throws GateException {

		ResourceResponce resourceResponce = new ResourceResponce();

		try {

			DataAccess dataAccess = (DataAccess) this.getContext().getApplicationContext().getBean(RequestEntity.Project.name());

			dataAccess.ViewAll(resourceRequest.getJsonElement());

		} catch (APIException e) {

			logger.error(e);

			resourceResponce.setMessage(e.getMessage());


		}

		return resourceResponce;
	}
	
}
