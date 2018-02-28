package com.sira.api;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import com.google.gson.Gson;
import com.sira.api.error.APIException;
import com.sira.api.security.Security;
import com.sira.model.stateschema.model.Employee;
import com.sira.model.stateschema.model.Employer;
import com.sira.model.stateschema.model.User;
import com.sira.model.stateschema.model.UserBase;

public abstract class DataAccess {

	private EntityManager entitimanager;

	private Gson gson = new Gson();

	private Security security;

	private Class<? extends Object>  type;

	public DataAccess(EntityManagerFactory entitimanager, Security security, String type) throws ClassNotFoundException {

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

	public abstract void Add(UserBase userBase) throws APIException ;

	public abstract void Update(UserBase userBase) throws APIException ;

	public abstract void Delete(UserBase userBase) throws APIException ;

	public abstract UserBase View(UserBase userBase) throws APIException;
	
	protected boolean isActive(UserBase userBase) throws APIException{
		
		Query query;
		
		try {
			
			query = this.getEntitimanager().createQuery("from User as user where user.email='"+ userBase.getUser().getEmail()+"'");
			
		} catch (Exception e) {

			throw new APIException(e.getLocalizedMessage());
			
		}
		
		User user = (User) query.getSingleResult();
		
		if(!user.getStatus()){
			
			throw new APIException("User Not activated");
			
		}
		
		return true;
		
		
	}

	protected Employer getEmployer(Employer employer)  throws APIException{

		Employer empFound;
		
		try {
		
			Query query = this.getEntitimanager().createQuery("form Employer as emp where emp.hjid=:hjid and emp.user.status=:status");
			
			query.setParameter("status", true);
			
			query.setParameter("hjid", employer.getHjid());
			
			empFound = (Employer) query.getSingleResult();
			
			empFound.setUser(null);
			
		} catch (Exception e) {

			throw new APIException(e.getLocalizedMessage());
			
		}
		
		return empFound;

	}
	
	protected Employee getEmployee(Employee employee) throws APIException {
		
		Employee empFound = null;
		
		try {
			Query query = this.getEntitimanager().createQuery("form Employee as emp where emp.firstName=:firstName "
					+ " and emp.user.status=:status"	
					+ " or emp.middleName=:middleName"
					+ " or emp.lastName=:lastName");
			
			query.setParameter("firstName", employee.getFirstName());
			query.setParameter("middleName", employee.getMiddleName());
			query.setParameter("lastName", employee.getLastName());
			query.setParameter("status", true);
			
			empFound = (Employee) query.getSingleResult();
			empFound.setUser(null);
			
		} catch (Exception e) {

			throw new  APIException(e.getLocalizedMessage());

		}
	
		return empFound;
				
	}
}
