package com.sira.api;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import com.google.gson.JsonElement;
import com.server.ResourceResponce;
import com.sira.api.error.APIException;
import com.sira.api.security.Security;
import com.sira.model.stateschema.model.Employer;

public class EmployerInfo extends DataAccess{

	public EmployerInfo(EntityManagerFactory entitimanager, Security security, String type) throws ClassNotFoundException {
		super(entitimanager, security,type);
	}

	@Override
	public void Add(JsonElement data) throws APIException {

		Employer employer = this.getGson().fromJson(data, Employer.class);

		try {

			this.getEntitimanager().persist(employer);

		} catch (Exception e) {

			throw new APIException(e.getLocalizedMessage());
		}

	}

	@Override
	public void Update(JsonElement data) throws APIException {

		Employer employer = this.getGson().fromJson(data, Employer.class);

		try {

			this.getEntitimanager().merge(employer);

		} catch (Exception e) {

			throw new APIException(e.getLocalizedMessage());
		}
	}

	@Override
	public void Delete(JsonElement data) throws APIException {

		Employer employer = this.getGson().fromJson(data, Employer.class);

		try {

			Query query = this.getEntitimanager().createQuery("delete from Employer as emp where emp.name='"+employer.getName()+"'");

			query.executeUpdate();


		} catch (Exception e) {

			throw new APIException(e.getLocalizedMessage());
		}
	}

	@Override
	public JsonElement View(JsonElement data) throws APIException {

		Employer employer = this.getGson().fromJson(data, Employer.class);

		try {

			Query query = this.getEntitimanager().createQuery("from Employer as empr where empr.name='"+employer.getName()+"'");

			employer = (Employer) query.getSingleResult();

		} catch (Exception e) {

			throw new APIException(e.getLocalizedMessage());
		}

		return this.getGson().toJsonTree(employer);
	}

	@Override
	public JsonElement ViewAll(JsonElement data) throws APIException {

		Employer employer = this.getGson().fromJson(data, Employer.class);

		List<Employer> employers;

		try {

			Query query = this.getEntitimanager().createQuery("from Employer as empr where "
					+ "empr.name=:name");

			query.setParameter("name", employer.getName());

			employers = query.getResultList();


		} catch (Exception e) {

			throw new APIException(e.getLocalizedMessage());

		}

		return this.getGson().toJsonTree(employers);

	}

}
