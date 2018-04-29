package com.sira.api.repository;

import java.util.List;

import org.apache.log4j.Logger;

import com.sira.api.repository.error.UplancerException;
import com.sira.model.stateschema.employer.EmployerProfile;
/**
 * 
 * @author Yared
 *
 */
public class EmployerProfileRepository extends Repository<EmployerProfile>{
	
	private static Logger logger = Logger.getLogger(EmployerProfileRepository.class);

	@Override
	public EmployerProfile getById(long id) throws UplancerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmployerProfile> getAll() throws UplancerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmployerProfile> getAllMaching(EmployerProfile t) throws UplancerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(EmployerProfile t) throws UplancerException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(EmployerProfile t) throws UplancerException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteMaching(EmployerProfile t) throws UplancerException {
		// TODO Auto-generated method stub
		
	}
	
}
