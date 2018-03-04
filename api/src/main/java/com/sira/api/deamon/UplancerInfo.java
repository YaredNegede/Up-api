package com.sira.api.deamon;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.sira.api.error.APIException;
import com.sira.model.stateschema.model.Uplancer;

public class UplancerInfo {

	private EntityManager entityManager;

	public UplancerInfo(EntityManager entityManager) {

		this.entityManager = entityManager;
		
	}


	public EntityManager getEntityManager() {
		return this.entityManager;
	}


	public Uplancer getUplancer() throws APIException {
		
		try {
			Query q = this.getEntityManager().createQuery("from Uplancer");
			
			return (Uplancer) q.getSingleResult();
			
		} catch (Exception e) {

			throw new APIException(e.getLocalizedMessage());

		}
		
	}
}
