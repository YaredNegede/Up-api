package com.sira.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sira.model.stateschema.employer.Employer;
/**
 * 
 * @author Yared
 *
 */
@Repository("employerRepository")
public interface EmployerRepository  extends JpaRepository<Employer, Long> {}
