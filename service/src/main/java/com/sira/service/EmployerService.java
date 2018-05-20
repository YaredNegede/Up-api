package com.sira.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.sira.model.stateschema.employer.Employer;

@Service("employerService")
public interface EmployerService {

	@Transactional
	public Employer save(Employer employer);
	
	@Transactional
	public Employer view(Long employerId);

	@Transactional
	public boolean delete(Long employerId);

}
