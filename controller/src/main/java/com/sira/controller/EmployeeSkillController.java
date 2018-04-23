package com.sira.controller;

import java.util.List;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.sira.api.security.Security;
import com.sira.dto.employee.SkillDto;
/**
 * 
 * @author Yared
 *
 */
public class EmployeeSkillController  implements Controller<SkillDto>{

	private static Logger logger = Logger.getLogger(EmployeeSkillController.class);

	private EntityManager entitimanager;

	private Gson gson = new Gson();

	private Security security;

	private Class<? extends Object>  type;
	
	public EmployeeSkillController(EntityManager entitimanager, Gson gson, Security security,
			Class<? extends Object> type) {
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

	public SkillDto getById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<SkillDto> getAll(long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<SkillDto> getAllMaching() {
		// TODO Auto-generated method stub
		return null;
	}

	public SkillDto save(SkillDto t) {
		// TODO Auto-generated method stub
		return null;
	}

	public SkillDto delete(SkillDto t) {
		// TODO Auto-generated method stub
		return null;
	}

	public SkillDto deleteMaching(SkillDto t) {
		// TODO Auto-generated method stub
		return null;
	}

}
