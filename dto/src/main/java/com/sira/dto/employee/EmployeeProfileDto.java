package com.sira.dto.employee;

import java.math.BigInteger;

import com.sira.dto.common.DTO;

public class EmployeeProfileDto  extends DTO{
	
	public Long id;
	public BigInteger onTime;
	public BigInteger onBudget;
	public BigInteger repeatHire;
	public BigInteger reviews;
	public Integer star;
	public String title;

}
