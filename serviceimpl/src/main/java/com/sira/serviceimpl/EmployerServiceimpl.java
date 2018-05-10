package com.sira.serviceimpl;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Service;

import com.sira.model.stateschema.employer.Employer;
import com.sira.service.EmployerService;

@Service("employerServiceimpl")
public class EmployerServiceimpl implements EmployerService{
 
	public Employer save(Employer employer) {
		// TODO Auto-generated method stub
		return null;
	}

	public Employer view(Long employeeId) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean delete(Long employeeId) {
		// TODO Auto-generated method stub
		return false;
	}

}
