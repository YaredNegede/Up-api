package com.sira.api;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import com.google.gson.JsonElement;
import com.sira.api.error.APIException;
import com.sira.api.security.Security;
import com.sira.model.stateschema.model.Employee;
import com.sira.model.stateschema.model.Skill;

public class EmployeeSkillInfo extends DataAccess{

	public EmployeeSkillInfo(EntityManagerFactory entitimanager, Security security, String type) throws ClassNotFoundException {
		super(entitimanager, security,type);
	}

	@Override
	public void Add(JsonElement data) throws APIException {

		try {

			Employee employee = this.getGson().fromJson(data, Employee.class);

			Employee empFound = (Employee) this.getEntitimanager().createQuery("form Employee as emp where emp.firstName='"+employee.getFirstName()+"' or emp.username='"+employee.getUsername()+"'");

			empFound.getSkills().addAll(employee.getSkills());

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

			empFound.getSkills().addAll(employee.getSkills());

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
			
			empFound.getSkills().removeAll(employee.getSkills());
			
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
			
			employee.setSkills(employee.getSkills());
			

		} catch (Exception e) {

			throw new APIException(e.getLocalizedMessage());

		}

		return this.getGson().toJsonTree(employee);
	}

	@Override
	public JsonElement ViewAll(JsonElement data) throws APIException {

		List<Skill> skills;

		try {

			Skill skill = this.getGson().fromJson(data, Skill.class);

			Query query = this.getEntitimanager().createQuery("from Skill as sk where "
					+ "sk.name=:name"	
					+ " or sk.description=:description");

			query.setParameter("name", skill.getName());
			query.setParameter("description", skill.getDescription());

			skills = query.getResultList();


		} catch (Exception e) {

			throw new APIException(e.getLocalizedMessage());

		}

		return this.getGson().toJsonTree(skills);

	}

}
