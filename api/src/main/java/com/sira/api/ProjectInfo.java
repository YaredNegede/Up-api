package com.sira.api;

import javax.persistence.EntityManagerFactory;

import com.sira.api.security.Security;

public class ProjectInfo  extends DataAccess{

	public ProjectInfo(EntityManagerFactory entitimanager, Security security, String type) throws ClassNotFoundException {
		super(entitimanager, security,type);
	}

}
