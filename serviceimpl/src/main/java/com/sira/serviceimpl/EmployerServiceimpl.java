package com.sira.serviceimpl;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sira.api.repository.EmployerRepository;
import com.sira.model.stateschema.employer.Employer;
import com.sira.service.EmployerService;

@Service("employerServiceimpl")
public class EmployerServiceimpl implements EmployerService{
 
	@Autowired
	EmployerRepository employerRepository;
	
	@Override
	public Employer save(Employer employer) {

		Employer employee = this.employerRepository.save(employer);
		
		return employee;
	}

	@Override
	public Employer view(Long employeeId) {

		Employer employee = this.employerRepository.getOne(employeeId);
		
		return employee;
	}

	@Override
	public boolean delete(Long employeeId) {

		this.employerRepository.deleteById(employeeId);
		
		return true;
		
	}

}
