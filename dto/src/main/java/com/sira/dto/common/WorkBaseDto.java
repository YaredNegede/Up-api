package com.sira.dto.common;

import java.math.BigInteger;

import com.sira.model.stateschema.model.JobStatus;
import com.sira.model.stateschema.model.JobType;

public class WorkBaseDto {

	public JobType jobType;
	public BigInteger numberOfFreelancer;
	public JobStatus status;
}
