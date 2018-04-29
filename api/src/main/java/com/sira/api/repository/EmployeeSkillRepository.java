package com.sira.api.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.sira.api.repository.error.UplancerException;
import com.sira.api.security.Security;
import com.sira.model.stateschema.common.Skill;
/**
 * 
 * @author Yared
 *
 */
public class EmployeeSkillRepository  extends Repository<Skill>{
	private static Logger logger = Logger.getLogger(EmployeeSkillRepository.class);

	@Override
	public Skill getById(long id) throws UplancerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Skill> getAll() throws UplancerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Skill> getAllMaching(Skill t) throws UplancerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Skill t) throws UplancerException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Skill t) throws UplancerException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteMaching(Skill t) throws UplancerException {
		// TODO Auto-generated method stub
		
	}
}
