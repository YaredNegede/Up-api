package com.sira.api.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.sira.api.repository.error.UplancerException;
import com.sira.api.security.Security;
import com.sira.model.stateschema.employee.Employee;
/**
 * 
 * @author Yared
 *
 */
public class EmployeeRepository  extends Repository<Employee>{

	private static Logger logger = Logger.getLogger(EmployeeRepository.class);

	@Override
	public Employee getById(long id) throws UplancerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> getAll() throws UplancerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> getAllMaching(Employee t) throws UplancerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Employee t) throws UplancerException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Employee t) throws UplancerException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteMaching(Employee t) throws UplancerException {
		// TODO Auto-generated method stub
		
	}
	
	
}
