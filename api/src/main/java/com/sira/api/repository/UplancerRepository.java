package com.sira.api.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.apache.log4j.Logger;

import com.sira.model.stateschema.model.Uplancer;

public class UplancerRepository implements Repository<Uplancer>{

	private static Logger logger = Logger.getLogger(UplancerRepository.class);
	
	private EntityManager entityManager;

	public UplancerRepository(EntityManagerFactory entityManager) {

		logger.info("Reading global configuration");
		
		this.entityManager = entityManager.createEntityManager();
		
	}

	public EntityManager getEntityManager() {
		return this.entityManager;
	}

	@Override
	public Uplancer getById(long id) {
		
		return null;
	}

	@Override
	public List<Uplancer> getAll(long userId) {
		
		return null;
	}

	@Override
	public List<Uplancer> getAllMaching() {
		
		return null;
	}

	@Override
	public Uplancer save(Uplancer t) {
		
		return null;
	}

	@Override
	public Uplancer delete(Uplancer t) {
		
		return null;
	}

	@Override
	public Uplancer deleteMaching(Uplancer t) {
		
		return null;
		
	}
}
