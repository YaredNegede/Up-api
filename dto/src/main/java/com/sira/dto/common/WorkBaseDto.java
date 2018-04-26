package com.sira.dto.common;

import java.math.BigInteger;

import com.sira.model.stateschema.workbase.JobStatus;
import com.sira.model.stateschema.workbase.JobType;

public class WorkBaseDto  extends DTO{

	public JobType jobType;
	public BigInteger numberOfFreelancer;
	public JobStatus status;
}
