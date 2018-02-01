package com.sira.api;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import com.google.gson.JsonElement;
import com.sira.api.error.APIException;
import com.sira.api.security.Security;
import com.sira.model.stateschema.model.Project;

public class ProjectInfo  extends DataAccess{

	public ProjectInfo(EntityManagerFactory entitimanager, Security security, String type) throws ClassNotFoundException {
		super(entitimanager, security,type);
	}

	@Override
	public void Add(JsonElement data) throws APIException {

		Project project = this.getGson().fromJson(data, Project.class);

		try {

			this.getEntitimanager().persist(project);

		} catch (Exception e) {

			throw new APIException(e.getLocalizedMessage());
		}

	}

	@Override
	public void Update(JsonElement data) throws APIException {

		Project project = this.getGson().fromJson(data, Project.class);

		try {

			this.getEntitimanager().merge(project);

		} catch (Exception e) {

			throw new APIException(e.getLocalizedMessage());
		}

	}

	@Override
	public void Delete(JsonElement data) throws APIException {

		Project project = this.getGson().fromJson(data, Project.class);

		try {

			Query query = this.getEntitimanager().createQuery("delete from Project as emp where emp.name='"+project.getName()+"'");

			query.executeUpdate();

		} catch (Exception e) {

			throw new APIException(e.getLocalizedMessage());
		}

	}

	@Override
	public JsonElement View(JsonElement data) throws APIException {

		Project project = this.getGson().fromJson(data, Project.class);

		try {

			Query query = this.getEntitimanager().createQuery("from Project as emp where emp.name='"+project.getName()+"'");

			project = (Project) query.getResultList().get(0);
			
		} catch (Exception e) {

			throw new APIException(e.getLocalizedMessage());
		}
		
		return this.getGson().toJsonTree(project);

	}

	@Override
	public JsonElement ViewAll(JsonElement data) throws APIException {

		Project project = this.getGson().fromJson(data, Project.class);

		List<Project> projects;

		try {

			Query query = this.getEntitimanager().createQuery("from Project as p where "
					+ "p.name=:name"	
					+ " and p.id=:id");

			query.setParameter("name", project.getName());
			query.setParameter("id", project.getId());

			projects = query.getResultList();


		} catch (Exception e) {
e.printStackTrace();
			throw new APIException(e.getLocalizedMessage());

		}

		return this.getGson().toJsonTree(projects);

	}

}
