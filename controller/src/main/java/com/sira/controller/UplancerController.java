package com.sira.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.apache.log4j.Logger;

import com.sira.dto.common.UplancerDto;

public class UplancerController implements Controller<UplancerDto>{

	private static Logger logger = Logger.getLogger(UplancerController.class);
	
	private EntityManager entityManager;

	public UplancerController(EntityManagerFactory entityManager) {

		logger.info("Reading global configuration");
		
		this.entityManager = entityManager.createEntityManager();
		
	}

	public EntityManager getEntityManager() {
		return this.entityManager;
	}

	public UplancerDto getById(long id) {
		
		return null;
	}

	public List<UplancerDto> getAll(long userId) {
		
		return null;
	}

	public List<UplancerDto> getAllMaching() {
		
		return null;
	}

	public UplancerDto save(UplancerDto t) {
		
		return null;
	}

	public UplancerDto delete(UplancerDto t) {
		
		return null;
	}

	public UplancerDto deleteMaching(UplancerDto t) {
		
		return null;
	}

	
}
