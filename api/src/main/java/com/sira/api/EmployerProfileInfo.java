package com.sira.api;

import javax.persistence.EntityManagerFactory;

import com.sira.api.error.APIException;
import com.sira.api.security.Security;
import com.sira.model.stateschema.model.Employer;
import com.sira.model.stateschema.model.UserBase;

public class EmployerProfileInfo extends DataAccess{

	public EmployerProfileInfo(EntityManagerFactory entitimanager, Security security, String type) throws ClassNotFoundException {
		super(entitimanager, security,type);
	}

	@Override
	public void Add(UserBase userBase) throws APIException {

		try {
			
			

			Employer employer =  (Employer) userBase;

			Employer empFound = this.getEmployer(employer);

			empFound.setProfile(employer.getProfile());

			this.getEntitimanager().merge(empFound);

		} catch (Exception e) {

			throw new APIException(e.getLocalizedMessage());
		}

	}

	@Override
	public void Update(UserBase userBase) throws APIException {

		try {
			
			
			
			Employer employer =  (Employer) userBase;

			Employer empFound = this.getEmployer(employer);

			empFound.getProfile().clear();
			
			empFound.setProfile(employer.getProfile());

			this.getEntitimanager().merge(empFound);

		} catch (Exception e) {

			throw new APIException(e.getLocalizedMessage());
		}
	}

	@Override
	public void Delete(UserBase userBase) throws APIException {

		try {

			
			
			Employer employer = (Employer) userBase;

			Employer empFound = this.getEmployer(employer);

			empFound.getProfile().removeAll(employer.getProfile());

			this.getEntitimanager().merge(empFound);


		} catch (Exception e) {

			throw new APIException(e.getLocalizedMessage());
		}
	}

	@Override
	public UserBase View(UserBase userBase) throws APIException {

		Employer employer;

		try {

			
			
			employer = (Employer) userBase;

			Employer empFound = this.getEmployer(employer);

			employer.setProfile(empFound.getProfile());


		} catch (Exception e) {

			throw new APIException(e.getLocalizedMessage());

		}

		return employer;
	}


}
