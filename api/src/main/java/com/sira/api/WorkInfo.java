package com.sira.api;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.google.gson.Gson;
import com.sira.api.error.APIException;
import com.sira.api.security.Security;
import com.sira.model.stateschema.model.WorkBase;
/**
 * 
 * @author Yared
 *
 */
public class WorkInfo {

	private EntityManager entitimanager;

	private Gson gson = new Gson();

	private Security security;

	private Class<? extends Object>  type;

	public WorkInfo(EntityManagerFactory entitimanager,
			Security security,
			String type) 
					throws ClassNotFoundException {

		this.entitimanager=entitimanager.createEntityManager();

		this.security = security;

		this.type  = Class.forName(type);;

	}

	public void Add(WorkBase workBase) throws APIException {

		try {

			this.getEntitimanager().persist(workBase);

		} catch (Exception e) {

			throw new APIException(e.getLocalizedMessage());
		}

	}

	public void Update(WorkBase workBase) throws APIException {

		try {

			this.getEntitimanager().merge(workBase);

		} catch (Exception e) {

			throw new APIException(e.getLocalizedMessage());
		}
	}

	public void Delete(WorkBase workBase) throws APIException {

		try {

			this.getEntitimanager().remove(workBase);

		} catch (Exception e) {

			throw new APIException(e.getLocalizedMessage());

		}
	}

	public WorkBase View(WorkBase workBase) throws APIException {

		WorkBase workBase2;

		try {

			workBase2 = this.getEntitimanager().find(WorkBase.class, workBase.getHjid());

		} catch (Exception e) {

			throw new APIException(e.getLocalizedMessage());

		}

		return workBase2;
	}

	public EntityManager getEntitimanager() {
		return entitimanager;
	}

	public Gson getGson() {
		return gson;
	}

	public Security getSecurity() {
		return security;
	}

	public Class<? extends Object> getType() {
		return type;
	}

}
