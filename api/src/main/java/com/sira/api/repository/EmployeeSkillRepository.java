package com.sira.api.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.sira.api.security.Security;
import com.sira.model.stateschema.common.Skill;
/**
 * 
 * @author Yared
 *
 */
public class EmployeeSkillRepository  implements Repository<Skill>{

	private static Logger logger = Logger.getLogger(EmployeeSkillRepository.class);

	private EntityManager entitimanager;

	private Gson gson = new Gson();

	private Security security;

	private Class<? extends Object>  type;
	
	public EmployeeSkillRepository(EntityManager entitimanager, Gson gson, Security security,
			Class<? extends Object> type) {
		super();
		this.entitimanager = entitimanager;
		this.gson = gson;
		this.security = security;
		this.type = type;
	}
	
	

	public static Logger getLogger() {
		return logger;
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



	@Override
	public Skill getById(long id) {
		
		return null;
	}

	@Override
	public List<Skill> getAll(long userId) {
		
		return null;
	}

	@Override
	public List<Skill> getAllMaching() {
		
		return null;
	}

	@Override
	public Skill save(Skill t) {
		
		return null;
	}

	@Override
	public Skill delete(Skill t) {
		
		return null;
	}

	@Override
	public Skill deleteMaching(Skill t) {
		
		return null;
	}

}
