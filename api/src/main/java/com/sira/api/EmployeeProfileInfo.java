package com.sira.api;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import com.google.gson.JsonElement;
import com.sira.api.error.APIException;
import com.sira.api.security.Security;
import com.sira.model.stateschema.model.Employee;
import com.sira.model.stateschema.model.Profile;

public class EmployeeProfileInfo extends DataAccess{

	public EmployeeProfileInfo(EntityManagerFactory entitimanager, Security security, String type) throws ClassNotFoundException {
		super(entitimanager, security,type);
	}

	@Override
	public void Add(JsonElement data) throws APIException {

		try {

			Employee employee = this.getGson().fromJson(data, Employee.class);

			Employee empFound = (Employee) this.getEntitimanager().createQuery("form Employee as emp where emp.firstName='"+employee.getFirstName()+"' or emp.username='"+employee.getUsername()+"'");

			empFound.getProfile().addAll(employee.getProfile());

			this.getEntitimanager().merge(empFound);

		} catch (Exception e) {

			throw new APIException(e.getLocalizedMessage());
		}

	}

	@Override
	public void Update(JsonElement data) throws APIException {

		try {

			Employee employee = this.getGson().fromJson(data, Employee.class);

			Employee empFound = (Employee) this.getEntitimanager().createQuery("form Employee as emp where emp.firstName='"+employee.getFirstName()+"' or emp.username='"+employee.getUsername()+"'");

			empFound.getProfile().addAll(employee.getProfile());

			this.getEntitimanager().merge(empFound);

		} catch (Exception e) {

			throw new APIException(e.getLocalizedMessage());
		}
	}

	@Override
	public void Delete(JsonElement data) throws APIException {

		try {

			Employee employee = this.getGson().fromJson(data, Employee.class);

			Employee empFound = (Employee) this.getEntitimanager().createQuery("form Employee as emp where emp.firstName='"+employee.getFirstName()+"' or emp.username='"+employee.getUsername()+"'");
			
			empFound.getProfile().removeAll(employee.getProfile());
			
			this.getEntitimanager().merge(empFound);
			

		} catch (Exception e) {

			throw new APIException(e.getLocalizedMessage());
		}
	}

	@Override
	public JsonElement View(JsonElement data) throws APIException {

		Employee employee;

		try {

			employee = this.getGson().fromJson(data, Employee.class);

			Employee empFound = (Employee) this.getEntitimanager().createQuery("form Employee as emp where emp.firstName='"+employee.getFirstName()+"' or emp.username='"+employee.getUsername()+"'");
			
			employee.setProfile(employee.getProfile());
			

		} catch (Exception e) {

			throw new APIException(e.getLocalizedMessage());

		}

		return this.getGson().toJsonTree(employee);
	}

	@Override
	public JsonElement ViewAll(JsonElement data) throws APIException {

		List<Profile> profiles;

		try {

			Profile profile = this.getGson().fromJson(data, Profile.class);

			Query query = this.getEntitimanager().createQuery("from Profile as pr where "
					+ "pr.name=:name");

			query.setParameter("name", profile.getName());

			profiles = query.getResultList();


		} catch (Exception e) {

			throw new APIException(e.getLocalizedMessage());

		}

		return this.getGson().toJsonTree(profiles);

	}

}
