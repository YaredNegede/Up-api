package com.sira.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sira.api.repository.EmployeeRepository;
import com.sira.model.stateschema.employee.Employee;

@Service("employeeServiceImpl")
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository employeeRepository;

	public Employee save(Employee employee) {

		this.getEmployeeRepository().save(employee);

		return employee;
	}

	public Employee view(Long employerId) {
		
		return null;
	}

	public boolean delete(Long employerId) {
		
		return false;
	}

	public EmployeeRepository getEmployeeRepository() {
		return employeeRepository;
	}

	public void setEmployeeRepository(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	
}