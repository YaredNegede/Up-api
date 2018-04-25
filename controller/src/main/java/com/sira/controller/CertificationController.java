package com.sira.controller;

import java.util.List;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.sira.api.security.Security;
import com.sira.dto.employee.CerteficationDto;

public class CertificationController implements RequestController<CerteficationDto> {
	
	private static Logger logger = Logger.getLogger(CertificationController.class);
	
	private EntityManager entitimanager;

	private Gson gson = new Gson();

	private Security security;

	private Class<? extends Object>  type;

	public CertificationController(EntityManager entitimanager, Gson gson, Security security, Class<? extends Object> type) {
		super();
		this.entitimanager = entitimanager;
		this.gson = gson;
		this.security = security;
		this.type = type;
	}

	public EntityManager getEntitimanager() {
		return entitimanager;
	}

	public Gson getGson() {
		return gson;
	}

	public Security getSecurity() {
		return security;
	}

	public Class<? extends Object> getType() {
		return type;
	}

	public CerteficationDto getById(long id) {
		
		return null;
	}

	public List<CerteficationDto> getAll(long userId) {
		
		return null;
	}

	public List<CerteficationDto> getAllMaching() {
		
		return null;
	}

	public CerteficationDto save(CerteficationDto t) {
		
		return null;
	}

	public CerteficationDto delete(CerteficationDto t) {
		
		return null;
	}

	public CerteficationDto deleteMaching(CerteficationDto t) {
		
		return null;
	}
	
	
}
