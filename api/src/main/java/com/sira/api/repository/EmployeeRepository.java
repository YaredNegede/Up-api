package com.sira.api.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.sira.api.security.Security;
import com.sira.model.stateschema.model.Employee;
/**
 * 
 * @author Yared
 *
 */
public class EmployeeRepository  implements Repository<Employee>{

	private static Logger logger = Logger.getLogger(EmployeeRepository.class);
	
	private EntityManager entitimanager;

	private Gson gson = new Gson();

	private Security security;

	private Class<? extends Object>  type;
	
	public EmployeeRepository(EntityManager entitimanager, Gson gson, Security security, Class<? extends Object> type) {
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
	public Employee getById(long id) {
		
		return null;
	}

	@Override
	public List<Employee> getAll(long userId) {
		
		return null;
	}

	@Override
	public List<Employee> getAllMaching() {
		
		return null;
	}

	@Override
	public Employee save(Employee t) {
		
		return null;
	}

	@Override
	public Employee delete(Employee t) {
		
		return null;
	}

	@Override
	public Employee deleteMaching(Employee t) {
		
		return null;
	}

}
