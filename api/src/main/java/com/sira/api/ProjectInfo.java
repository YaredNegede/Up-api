package com.sira.api;

import javax.persistence.EntityManager;

import com.sira.api.request.Request;
import com.sira.api.security.Security;

public class ProjectInfo  extends DataAccess{

	public ProjectInfo(EntityManager entitimanager, Security security, Request request) {

		super(entitimanager, security, request);
		
	}

}
