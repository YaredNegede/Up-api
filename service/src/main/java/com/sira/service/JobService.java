package com.sira.service;

import org.springframework.stereotype.Service;

import com.sira.model.stateschema.workbase.WorkBase;

@Service
public interface JobService {


	public WorkBase save(WorkBase workBase);
	
	public WorkBase view(Long jobId);

	public boolean delete(Long jobId);


}
