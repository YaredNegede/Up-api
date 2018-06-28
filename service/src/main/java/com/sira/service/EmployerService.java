package com.sira.service;


import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sira.model.stateschema.employer.Employer;

@Service("employerService")
public interface EmployerService {

	@Transactional
	public Employer save(Employer employer);
	
	@Transactional
	public Employer view(Long employerId);
	
	@Transactional
	public Page<Employer> viewAll(Pageable pageable);

	@Transactional
	public boolean delete(Long employerId);

}
