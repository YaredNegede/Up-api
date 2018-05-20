package com.sira.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.sira.api.repository.EmployeeRepository;
import com.sira.model.stateschema.employee.Employee;
import com.sira.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public Employee save(Employee employee) {

		Employee employeeSaved =  this.getEmployeeRepository().save(employee);
		
		return employeeSaved;
	}
	
	@Override
	public Employee view(Long employeeId) {
		
		Employee employee = this.employeeRepository.getOne(employeeId);
		
		return employee;
	}

	@Override
	public boolean delete(Long employeeId) {

		this.employeeRepository.deleteById(employeeId);
		
		return true;
	}

	public EmployeeRepository getEmployeeRepository() {
		return employeeRepository;
	}

}
