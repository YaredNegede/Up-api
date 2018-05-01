package com.sira.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sira.model.stateschema.employer.EmployerPortoFolio;

@Repository("employerPortoFolioRepository")
public interface EmployerPortoFolioRepository  extends JpaRepository<EmployerPortoFolio, Long> {}
