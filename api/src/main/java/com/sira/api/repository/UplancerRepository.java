package com.sira.api.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.apache.log4j.Logger;

import com.sira.api.repository.error.UplancerException;
import com.sira.model.stateschema.uplancer.Uplancer;

public class UplancerRepository extends Repository<Uplancer>{

	private static Logger logger = Logger.getLogger(UplancerRepository.class);

	@Override
	public Uplancer getById(long id) throws UplancerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Uplancer> getAll() throws UplancerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Uplancer> getAllMaching(Uplancer t) throws UplancerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Uplancer t) throws UplancerException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Uplancer t) throws UplancerException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteMaching(Uplancer t) throws UplancerException {
		// TODO Auto-generated method stub
		
	}
	
	
}
