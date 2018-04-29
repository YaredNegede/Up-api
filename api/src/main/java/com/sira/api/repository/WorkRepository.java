package com.sira.api.repository;

import java.util.List;

import org.apache.log4j.Logger;

import com.sira.api.repository.error.UplancerException;
import com.sira.model.stateschema.workbase.WorkBase;
/**
 * 
 * @author Yared
 *
 */
public class WorkRepository extends Repository<WorkBase>{

	private static Logger logger = Logger.getLogger(WorkRepository.class);

	@Override
	public WorkBase getById(long id) throws UplancerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<WorkBase> getAll() throws UplancerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<WorkBase> getAllMaching(WorkBase t) throws UplancerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(WorkBase t) throws UplancerException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(WorkBase t) throws UplancerException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteMaching(WorkBase t) throws UplancerException {
		// TODO Auto-generated method stub
		
	}
	
	
}
