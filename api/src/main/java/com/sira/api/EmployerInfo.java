package com.sira.api;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import com.sira.api.error.APIException;
import com.sira.api.security.Security;
import com.sira.model.stateschema.model.Employer;
import com.sira.model.stateschema.model.UserBase;

public class EmployerInfo extends DataAccess{

	public EmployerInfo(EntityManagerFactory entitimanager, Security security, String type) throws ClassNotFoundException {
		super(entitimanager, security,type);
	}

	@Override
	public void Add(UserBase userBase) throws APIException {

		Employer employer = (Employer) userBase;

		try {

			
			
			this.getEntitimanager().persist(employer);

		} catch (Exception e) {

			throw new APIException(e.getLocalizedMessage());
		}

	}

	@Override
	public void Update(UserBase userBase) throws APIException {

		Employer employer = (Employer) userBase;

		try {
			
			
			
			this.getEntitimanager().merge(employer);

		} catch (Exception e) {

			throw new APIException(e.getLocalizedMessage());
		}
	}

	@Override
	public void Delete(UserBase userBase) throws APIException {

		Employer employer = (Employer) userBase;

		try {

			
			
			this.getEntitimanager().remove(employer);

		} catch (Exception e) {

			throw new APIException(e.getLocalizedMessage());
		}
	}

	@Override
	public UserBase View(UserBase userBase) throws APIException {

		Employer employer = (Employer) userBase;

		try {

			
			
			employer = this.getEntitimanager().find(Employer.class,employer.getHjid());

		} catch (Exception e) {

			throw new APIException(e.getLocalizedMessage());
		}

		return employer;
		
	}

}
