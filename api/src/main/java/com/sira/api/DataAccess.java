package com.sira.api;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.sira.api.error.APIException;
import com.sira.api.security.Security;
import com.sira.model.stateschema.model.Employee;
import com.sira.model.stateschema.model.Employer;
import com.sira.model.stateschema.model.Profile;
import com.sira.model.stateschema.model.User;
import com.sira.model.stateschema.model.UserBase;

/**
 * 
 * @author Yared Negede
 *
 */

public abstract class DataAccess{

	private static Logger logger = Logger.getLogger(DataAccess.class);

	private EntityManager entitimanager;

	private Gson gson = new Gson();

	private Security security;

	private Class<? extends Object>  type;

	public DataAccess(EntityManagerFactory entitimanager,
			Security security, String type) throws ClassNotFoundException {

		this.entitimanager = entitimanager.createEntityManager();

		this.security = security;

		this.type = Class.forName(type);

	}

	public EntityManager getEntitimanager() {

		return this.entitimanager;

	}

	public Security getSecurity() {

		return this.security;

	}

	public Gson getGson() {

		return gson;

	}

	private Class<? extends Object> getType() {

		return this.type;

	}

	protected boolean isActive(UserBase userBase) throws APIException{

		Query query;

		try {

			query = this.getEntitimanager().createQuery("from User as user where user.email='"+ userBase.getUser().getEmail()+"'");

		} catch (Exception e) {

			throw new APIException(e.getLocalizedMessage());

		}

		User user = (User) query.getSingleResult();

		if(!user.isStatus()){

			throw new APIException("User Not activated");

		}

		return true;


	}

	protected Employer getEmployer(Employer employer)  throws APIException{

		Employer empFound;

		try {

			Query query = this.getEntitimanager().createQuery("from Employer as emp where emp.hjid=:hjid and emp.status=:status");

			query.setParameter("status", true);

			query.setParameter("hjid", employer.getHjid());

			empFound = (Employer) query.getSingleResult();

			empFound.setUser(null);

		} catch (Exception e) {

			logger.error(e);

			throw new APIException(e.getMessage());

		}

		return empFound;

	}

	protected Employee getEmployee(Employee employee) throws APIException {

		Employee empFound = null;

		try {

			if(employee == null) {

				throw new APIException("No User set");

			}

			if(employee.getHjid() == null) {

				throw new APIException("No User found");

			}
			
			logger.info("\n\n\n\n"+this.getGson().toJsonTree(this.getEntitimanager().createQuery("from Employee").getResultList())+"\n\n\n\n");
			
			Query query = this.getEntitimanager().createQuery("from Employee as emp where emp.hjid=:hjid and emp.status=:status");

			query.setParameter("status", true);

			query.setParameter("hjid", employee.getHjid());

			empFound = (Employee) query.getSingleResult();

			empFound.setUser(null);

		} catch (Exception e) {

			logger.error(e);

			throw new  APIException(e.getMessage());

		}

		return empFound;

	}
	
	protected Profile getEmployeeProfile(Profile profile) {

		return null;
	
	}

}
