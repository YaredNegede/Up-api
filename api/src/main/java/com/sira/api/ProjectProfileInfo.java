package com.sira.api;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import com.google.gson.JsonElement;
import com.sira.api.error.APIException;
import com.sira.api.security.Security;
import com.sira.model.stateschema.model.Profile;
import com.sira.model.stateschema.model.Project;

public class ProjectProfileInfo  extends DataAccess{

	public ProjectProfileInfo(EntityManagerFactory entitimanager, Security security, String type) throws ClassNotFoundException {
		super(entitimanager, security,type);
	}

	@Override
	public void Add(JsonElement data) throws APIException {

		try {

			Project project = this.getGson().fromJson(data, Project.class);

			Query query = this.getEntitimanager().createQuery("from Project as pr where "
					+ "pr.name=:name");
			
			query.setParameter("name", project.getName());
			
			Project projectFound = (Project) query.getSingleResult();
			
			projectFound.getProfile().addAll(project.getProfile());
			
			this.getEntitimanager().merge(project);

		} catch (Exception e) {

			throw new APIException(e.getLocalizedMessage());
		}

	}

	@Override
	public void Update(JsonElement data) throws APIException {

		try {

			Project project = this.getGson().fromJson(data, Project.class);

			Query query = this.getEntitimanager().createQuery("from Project as pr where "
					+ "pr.name=:name");
			
			query.setParameter("name", project.getName());
			
			Project projectFound = (Project) query.getSingleResult();
			
			projectFound.getProfile().addAll(project.getProfile());
			
			this.getEntitimanager().merge(project);


		} catch (Exception e) {

			throw new APIException(e.getLocalizedMessage());
		}

	}

	@Override
	public void Delete(JsonElement data) throws APIException {

		try {

			Project project = this.getGson().fromJson(data, Project.class);

			Query query = this.getEntitimanager().createQuery("from Project as pr where "
					+ "pr.name=:name");
			
			query.setParameter("name", project.getName());
			
			Project projectFound = (Project) query.getSingleResult();
			
			projectFound.getProfile().removeAll(project.getProfile());
			
			this.getEntitimanager().merge(project);


		} catch (Exception e) {

			throw new APIException(e.getLocalizedMessage());
		}

	}

	@Override
	public JsonElement View(JsonElement data) throws APIException {

		Project project = this.getGson().fromJson(data, Project.class);

		try {

			Query query = this.getEntitimanager().createQuery("from Project as pr where "
					+ "pr.name=:name");
			
			query.setParameter("name", project.getName());
			
			project = (Project) query.getSingleResult();
			
			
		} catch (Exception e) {

			throw new APIException(e.getLocalizedMessage());
		}
		
		return this.getGson().toJsonTree(project);

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
