package com.sira.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sira.model.stateschema.employee.Employee;
/**
 * 
 * @author Yared Negede - 
 *
 */
@Repository("employeeRepository")
public interface EmployeeRepository  extends JpaRepository<Employee, Long> {}
