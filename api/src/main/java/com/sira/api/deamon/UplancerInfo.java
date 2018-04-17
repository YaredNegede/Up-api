package com.sira.api.deamon;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import com.sira.api.error.APIException;
import com.sira.model.stateschema.model.Uplancer;

public class UplancerInfo {

	private static Logger logger = Logger.getLogger(UplancerInfo.class);
	
	private EntityManager entityManager;

	public UplancerInfo(EntityManagerFactory entityManager) {

		this.entityManager = entityManager.createEntityManager();
		
	}

	public EntityManager getEntityManager() {
		return this.entityManager;
	}

	public Uplancer getUplancer() throws APIException {
		
		try {
			Query q = this.getEntityManager().createQuery("from Uplancer");
			
			return (Uplancer) q.getResultList().get(0);
			
		} catch (Exception e) {

			logger.error(e);
			
			throw new APIException(e.getLocalizedMessage());

		}
		
	}
}
