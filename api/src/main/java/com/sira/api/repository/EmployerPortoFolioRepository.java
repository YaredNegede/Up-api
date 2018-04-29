package com.sira.api.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.sira.api.repository.error.UplancerException;
import com.sira.api.security.Security;
import com.sira.model.stateschema.employer.EmployerPortoFolio;

public class EmployerPortoFolioRepository extends Repository<EmployerPortoFolio>{
	private static Logger logger = Logger.getLogger(EmployerPortoFolioRepository.class);

	@Override
	public EmployerPortoFolio getById(long id) throws UplancerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmployerPortoFolio> getAll() throws UplancerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmployerPortoFolio> getAllMaching(EmployerPortoFolio t) throws UplancerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(EmployerPortoFolio t) throws UplancerException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(EmployerPortoFolio t) throws UplancerException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteMaching(EmployerPortoFolio t) throws UplancerException {
		// TODO Auto-generated method stub
		
	}
	
}
