package com.sira.api.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.sira.api.repository.error.UplancerException;
import com.sira.api.security.Security;
import com.sira.model.stateschema.employer.EmployerReview;

public class EmployerReviewRepository extends Repository<EmployerReview>{

	private static Logger logger = Logger.getLogger(EmployerReviewRepository.class);

	@Override
	public EmployerReview getById(long id) throws UplancerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmployerReview> getAll() throws UplancerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmployerReview> getAllMaching(EmployerReview t) throws UplancerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(EmployerReview t) throws UplancerException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(EmployerReview t) throws UplancerException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteMaching(EmployerReview t) throws UplancerException {
		// TODO Auto-generated method stub
		
	}
	
}
