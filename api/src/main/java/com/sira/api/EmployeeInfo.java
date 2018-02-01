package com.sira.api;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import com.google.gson.JsonElement;
import com.sira.api.error.APIException;
import com.sira.api.security.Security;
import com.sira.model.stateschema.model.Employee;

public class EmployeeInfo extends DataAccess{

	public EmployeeInfo(EntityManagerFactory entitimanager, Security security, String type) throws ClassNotFoundException {
		super(entitimanager, security,type);
	}

	@Override
	public void Add(JsonElement data) throws APIException {

		try {

			Employee employee = this.getGson().fromJson(data, Employee.class);

			this.getEntitimanager().persist(employee);

		} catch (Exception e) {

			throw new APIException(e.getLocalizedMessage());
		}

	}

	@Override
	public void Update(JsonElement data) throws APIException {

		try {

			Employee employee = this.getGson().fromJson(data, Employee.class);
			
			this.getEntitimanager().merge(employee);

		} catch (Exception e) {

			throw new APIException(e.getLocalizedMessage());
		}
	}

	@Override
	public void Delete(JsonElement data) throws APIException {

		try {

			Employee employee = this.getGson().fromJson(data, Employee.class);

			Query query = this.getEntitimanager().createQuery("delete from Employee as emp where emp.username='"+employee.getUsername()+"'");
			
			query.executeUpdate();

		} catch (Exception e) {

			throw new APIException(e.getLocalizedMessage());
		}
	}

	@Override
	public JsonElement View(JsonElement data) throws APIException {
		
		Employee employee;
		
		try {

			employee = this.getGson().fromJson(data, Employee.class);

			Query query = this.getEntitimanager().createQuery("from Employee as emp where emp.username='"+employee.getUsername()+"'");
		
			employee = (Employee) query.getResultList().get(0);

		} catch (Exception e) {

			throw new APIException(e.getLocalizedMessage());
			
		}

		return this.getGson().toJsonTree(employee);
	}

	@Override
	public JsonElement ViewAll( JsonElement data) throws APIException {

		List<Employee> employees;

		try {

			Employee employee = this.getGson().fromJson(data, Employee.class);

			Query query = this.getEntitimanager().createQuery("from Employee as emp where "
					+ "emp.firstName=:firstName"	
					+ " or emp.middleName=:middleName"
					+ " or emp.lastName=:lastName"
					+ " or emp.username=:username");
			
			query.setParameter("firstName", employee.getFirstName());
			query.setParameter("middleName", employee.getMiddleName());
			query.setParameter("lastName", employee.getLastName());
			query.setParameter("username", employee.getUsername());

			employees = query.getResultList();


		} catch (Exception e) {
			
			throw new APIException(e.getLocalizedMessage());

		}

		return this.getGson().toJsonTree(employees);

	}

}
