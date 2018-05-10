package com.sira.service;

import org.springframework.stereotype.Service;

import com.sira.model.stateschema.employer.Employer;

@Service
public interface EmployerService {

	public Employer save(Employer employer);
	
	public Employer view(Long employerId);

	public boolean delete(Long employerId);

}
