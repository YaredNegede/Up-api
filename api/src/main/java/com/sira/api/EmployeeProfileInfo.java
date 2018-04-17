package com.sira.api;

import java.util.List;

import javax.persistence.EntityManagerFactory;

import org.apache.log4j.Logger;

import com.sira.api.error.APIException;
import com.sira.api.security.Security;
import com.sira.model.stateschema.model.Profile;

/**
 * 
 * @author Yared Negede
 *
 */

public class EmployeeProfileInfo extends DataAccess implements EntityAction{

	private static Logger logger = Logger.getLogger(EmployeeProfileInfo.class);
	
	public EmployeeProfileInfo(EntityManagerFactory entitimanager,
			Security security, String type) 
			throws ClassNotFoundException {
		
		super(entitimanager, security,type);
	
	}

	@Override
	public void Add(Profile profile) throws APIException {

		logger.info("****************************"+this.getClass().getName()+"****************************");

		try {

			this.getEntitimanager().persist(profile);

		} catch (Exception e) {

			logger.error(e);
			
			throw new APIException(e.getLocalizedMessage());

		}

	}

	@Override
	public void Update(Profile profile) throws APIException {
		
		logger.info("****************************"+this.getClass().getName()+"****************************");
		
		try {

			this.getEntitimanager().merge(profile);

		} catch (Exception e) {

			logger.error(e);
			
			throw new APIException(e.getLocalizedMessage());
		}
	}

	@Override
	public void Delete(Profile profile) throws APIException {
		
		logger.info("****************************"+this.getClass().getName()+"****************************");
		
		try {

			this.getEntitimanager().remove(profile);

		} catch (Exception e) {

			logger.error(e);
			
			throw new APIException(e.getLocalizedMessage());
		}
	}

	@Override
	public Profile View(Profile profile) throws APIException {

		logger.info("****************************"+this.getClass().getName()+"****************************");
		
		Profile profileres = null;

		try {

			profileres = this.getEmployeeProfile(profile);

		} catch (Exception e) {

			logger.error(e);
			
			throw new APIException(e.getLocalizedMessage());

		}

		return profileres;
		
	}

	@Override
	public List<Profile> ViewAll(Profile profile) throws APIException {
		return null;
		
	}
	 
}
