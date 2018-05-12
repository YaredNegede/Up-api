package com.sira.serviceimpl;

import com.sira.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sira.api.repository.EmployeeRepository;
import com.sira.model.stateschema.employee.Employee;

@Service("employeeServiceimpl")
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public Employee save(Employee employee) {

		Employee employeeSaved = this.employeeRepository.saveAndFlush(employee);
		
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

}
