package com.sira.api.repository;

import javax.persistence.EntityManager;

import com.sira.model.stateschema.common.UserBase;

public class RepositoryContext {

	private EntityManager entityManager;
	
	private UserBase userBase;

	public RepositoryContext(EntityManager entityManager, UserBase userBase) {

		this.entityManager = entityManager;
		
		this.userBase = userBase;
	
	}

	public EntityManager getEntityManager() {
	
		return this.entityManager;
	
	}

	public UserBase getUserBase() {

		return this.userBase;
	
	}

}
