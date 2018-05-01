package com.sira.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sira.model.stateschema.employer.EmployerProfile;
/**
 * 
 * @author Yared
 *
 */
@Repository("employerProfileRepository")
public interface EmployerProfileRepository  extends JpaRepository<EmployerProfile, Long> {}
