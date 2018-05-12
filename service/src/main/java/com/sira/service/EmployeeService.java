package com.sira.service;

import com.sira.model.stateschema.employee.Employee;

public interface EmployeeService {
	
	public Employee save(Employee employee);
	
	public Employee view(Long employeeId);

	public boolean delete(Long employeeId);

}