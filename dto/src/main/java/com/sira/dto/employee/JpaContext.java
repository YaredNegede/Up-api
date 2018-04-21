package com.sira.dto.employee;

import javax.persistence.EntityManager;

public class JpaContext {
	
	private EntityManager entityManager;

	public JpaContext(EntityManager entityManager) {

		this.entityManager = entityManager;
		
	}

	public EntityManager getEntityManager() {
		
		return entityManager;
		
	}
	
}
