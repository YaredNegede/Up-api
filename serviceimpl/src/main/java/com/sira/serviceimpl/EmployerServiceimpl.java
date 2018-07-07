package com.sira.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sira.api.repository.EmployerRepository;
import com.sira.model.stateschema.employer.Employer;
import com.sira.service.EmployerService;

@Service
public class EmployerServiceimpl implements EmployerService{
 
	@Autowired(required=true)
	private EmployerRepository employerRepository;
	
	@Override
	public Employer save(Employer employer) {

		Employer employee = this.getEmployerRepository().save(employer);
		
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

	
	public EmployerRepository getEmployerRepository() {
		return this.employerRepository;
	}


	public void setEmployerRepository(EmployerRepository employerRepository) {
		this.employerRepository = employerRepository;
	}

	@Override
	public Page<Employer> viewAll(Pageable pageable) {
		return this.getEmployerRepository().findAll(pageable);
	}

}
