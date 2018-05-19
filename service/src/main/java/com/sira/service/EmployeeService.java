package com.sira.service;

import org.springframework.stereotype.Service;

import com.sira.model.stateschema.employee.Employee;

@Service
public interface EmployeeService {
	
	public Employee save(Employee employee);
	
	public Employee view(Long employeeId);

	public boolean delete(Long employeeId);

}