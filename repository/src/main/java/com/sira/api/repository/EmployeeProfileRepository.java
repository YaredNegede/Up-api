package com.sira.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sira.model.stateschema.employee.EmployeeProfile;

/**
 * 
 * @author Yared Negede
 *
 */
@Repository("employeeProfileRepository")
public interface EmployeeProfileRepository   extends JpaRepository<EmployeeProfile, Long> {}
