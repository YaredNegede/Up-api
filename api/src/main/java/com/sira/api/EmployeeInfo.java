package com.sira.api;

import javax.persistence.EntityManagerFactory;

import com.sira.api.security.Security;

public class EmployeeInfo extends DataAccess{

	public EmployeeInfo(EntityManagerFactory entitimanager, Security security, String type) throws ClassNotFoundException {
		super(entitimanager, security,type);
	}

	
}
