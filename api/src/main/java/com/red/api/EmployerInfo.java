package com.red.api;

import javax.persistence.EntityManager;

import com.red.api.request.Request;
import com.red.api.security.Security;

public class EmployerInfo extends DataAccess{

	public EmployerInfo(EntityManager entitimanager, Security security, Request request) {
		
		super(entitimanager, security, request);
		
	}

}
