package com.sira.api.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.sira.api.repository.error.UplancerException;
import com.sira.api.security.Security;
import com.sira.model.stateschema.employer.Employer;
/**
 * 
 * @author Yared
 *
 */
public class EmployerRepository extends Repository<Employer>{

	private static Logger logger = Logger.getLogger(EmployerRepository.class);

	@Override
	public Employer getById(long id) throws UplancerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employer> getAll() throws UplancerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employer> getAllMaching(Employer t) throws UplancerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Employer t) throws UplancerException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Employer t) throws UplancerException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteMaching(Employer t) throws UplancerException {
		// TODO Auto-generated method stub
		
	}

	
}
