package com.sira.api.repository;

import java.util.List;

import org.apache.log4j.Logger;

import com.sira.api.repository.error.UplancerException;
import com.sira.model.stateschema.employee.EmployeeProfile;

/**
 * 
 * @author Yared Negede
 *
 */

public class EmployeeProfileRepository extends Repository<EmployeeProfile>{

	private static Logger logger = Logger.getLogger(EmployeeProfileRepository.class);

	@Override
	public EmployeeProfile getById(long id) throws UplancerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmployeeProfile> getAll() throws UplancerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmployeeProfile> getAllMaching(EmployeeProfile t) throws UplancerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(EmployeeProfile t) throws UplancerException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(EmployeeProfile t) throws UplancerException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteMaching(EmployeeProfile t) throws UplancerException {
		// TODO Auto-generated method stub
		
	}
	
}
