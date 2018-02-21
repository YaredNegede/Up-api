package com.sira.api;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import com.google.gson.JsonElement;
import com.sira.api.error.APIException;
import com.sira.api.security.Security;
import com.sira.model.stateschema.model.Employer;
import com.sira.model.stateschema.model.Skill;

public class EmployerSkillInfo extends DataAccess{

	public EmployerSkillInfo(EntityManagerFactory entitimanager, Security security, String type) throws ClassNotFoundException {
		super(entitimanager, security,type);
	}

	@Override
	public void Add(JsonElement data) throws APIException {

		try {

			Employer employer = this.getGson().fromJson(data, Employer.class);

			Employer empFound = (Employer) this.getEntitimanager().createQuery("form Employer as emp where emp.firstName='"+employer.getName()+"' or emp.username='"+employer.getUserName()+"'");

			empFound.getSkills().addAll(employer.getSkills());

			this.getEntitimanager().merge(empFound);

		} catch (Exception e) {

			throw new APIException(e.getLocalizedMessage());
		}

	}

	@Override
	public void Update(JsonElement data) throws APIException {

		try {

			Employer employer = this.getGson().fromJson(data, Employer.class);

			Employer empFound = (Employer) this.getEntitimanager().createQuery("form Employer as emp where emp.firstName='"+employer.getName()+"' or emp.username='"+employer.getUserName()+"'");

			empFound.getSkills().addAll(employer.getSkills());

			this.getEntitimanager().merge(empFound);

		} catch (Exception e) {

			throw new APIException(e.getLocalizedMessage());
		}
	}

	@Override
	public void Delete(JsonElement data) throws APIException {

		try {

			Employer employer = this.getGson().fromJson(data, Employer.class);

			Employer empFound = (Employer) this.getEntitimanager().createQuery("form Employer as emp where emp.firstName='"+employer.getName()+"' or emp.username='"+employer.getUserName()+"'");
			
			empFound.getSkills().removeAll(employer.getSkills());
			
			this.getEntitimanager().merge(empFound);
			

		} catch (Exception e) {

			throw new APIException(e.getLocalizedMessage());
		}
	}

	@Override
	public JsonElement View(JsonElement data) throws APIException {

		Employer employer;

		try {

			employer = this.getGson().fromJson(data, Employer.class);

			Employer empFound = (Employer) this.getEntitimanager().createQuery("form employer as emp where emp.firstName='"+employer.getName()+"' or emp.username='"+employer.getUserName()+"'");
			
			employer.setSkills(employer.getSkills());
			

		} catch (Exception e) {

			throw new APIException(e.getLocalizedMessage());

		}

		return this.getGson().toJsonTree(employer);
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
