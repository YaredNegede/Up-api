package com.sira.api.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.sira.api.repository.error.UplancerException;
import com.sira.api.security.Security;
import com.sira.model.stateschema.employee.EmployeeReview;

public class EmployeeReviewRepository extends Repository<EmployeeReview>{

	private static Logger logger = Logger.getLogger(EmployeeReviewRepository.class);

	@Override
	public EmployeeReview getById(long id) throws UplancerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmployeeReview> getAll() throws UplancerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmployeeReview> getAllMaching(EmployeeReview t) throws UplancerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(EmployeeReview t) throws UplancerException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(EmployeeReview t) throws UplancerException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteMaching(EmployeeReview t) throws UplancerException {
		// TODO Auto-generated method stub
		
	}
	
	
}
