package com.sira.api;

import java.util.List;

import javax.persistence.EntityManagerFactory;

import com.sira.api.error.APIException;
import com.sira.api.security.Security;
import com.sira.model.stateschema.model.Employer;
import com.sira.model.stateschema.model.Profile;
import com.sira.model.stateschema.model.UserBase;
/**
 * 
 * @author Yared
 *
 */
public class EmployerProfileInfo extends DataAccess  implements EntityAction{

	public EmployerProfileInfo(EntityManagerFactory entitimanager, Security security, String type) throws ClassNotFoundException {
		super(entitimanager, security,type);
	}

	@Override
	public void Add(Profile profile) throws APIException {

		try {

			this.getEntitimanager().persist(profile);

		} catch (Exception e) {
			
			e.printStackTrace();
		
			throw new APIException(e.getLocalizedMessage());
		
		}

	}

	@Override
	public void Update(Profile profile) throws APIException {

		try {

			this.getEntitimanager().merge(profile);

		} catch (Exception e) {

			throw new APIException(e.getLocalizedMessage());
		}
	}

	@Override
	public void Delete(Profile profile) throws APIException {

		try {

			this.getEntitimanager().remove(profile);

		} catch (Exception e) {

			throw new APIException(e.getLocalizedMessage());
		}
	}

	@Override
	public Profile View(Profile profile) throws APIException {

		Profile profile2 = null;

		try {

			

		} catch (Exception e) {

			throw new APIException(e.getLocalizedMessage());

		}

		return profile2;
	}

	@Override
	public List<Profile> ViewAll(Profile profile) throws APIException {
		// TODO Auto-generated method stub
		return null;
	}


}
