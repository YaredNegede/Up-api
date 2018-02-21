package com.sira.api;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import com.google.gson.JsonElement;
import com.sira.api.error.APIException;
import com.sira.api.security.Security;
import com.sira.model.stateschema.model.Employer;
import com.sira.model.stateschema.model.Profile;

public class EmployerProfileInfo extends DataAccess{

	public EmployerProfileInfo(EntityManagerFactory entitimanager, Security security, String type) throws ClassNotFoundException {
		super(entitimanager, security,type);
	}

	@Override
	public void Add(JsonElement data) throws APIException {

		try {

			Employer Employer= this.getGson().fromJson(data, Employer.class);

			Employer empFound = (Employer) this.getEntitimanager().createQuery("form Employer as emp where emp.firstName='"+Employer.getName()+"' or emp.username='"+Employer.getUserName()+"'");

			empFound.getProfile().addAll(Employer.getProfile());

			this.getEntitimanager().merge(empFound);

		} catch (Exception e) {

			throw new APIException(e.getLocalizedMessage());
		}

	}

	@Override
	public void Update(JsonElement data) throws APIException {

		try {

			Employer Employer = this.getGson().fromJson(data, Employer.class);

			Employer empFound = (Employer) this.getEntitimanager().createQuery("form Employer as emp where emp.firstName='"+Employer.getName()+"' or emp.username='"+Employer.getUserName()+"'");

			empFound.getProfile().addAll(Employer.getProfile());

			this.getEntitimanager().merge(empFound);

		} catch (Exception e) {

			throw new APIException(e.getLocalizedMessage());
		}
	}

	@Override
	public void Delete(JsonElement data) throws APIException {

		try {

			Employer Employer = this.getGson().fromJson(data, Employer.class);

			Employer empFound = (Employer) this.getEntitimanager().createQuery("form Employer as emp where emp.firstName='"+Employer.getName()+"' or emp.username='"+Employer.getUserName()+"'");
			
			empFound.getProfile().removeAll(Employer.getProfile());
			
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

			Employer empFound = (Employer) this.getEntitimanager().createQuery("form Employer as emp where emp.firstName='"+employer.getName()+"' or emp.username='"+employer.getUserName()+"'");
			
			employer.setProfile(empFound.getProfile());
			

		} catch (Exception e) {

			throw new APIException(e.getLocalizedMessage());

		}

		return this.getGson().toJsonTree(employer);
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
