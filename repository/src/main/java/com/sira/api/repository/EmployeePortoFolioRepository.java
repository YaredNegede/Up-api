package com.sira.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sira.model.stateschema.employee.EmployeePortoFolio;

@Repository("employeePortoFolioRepository")
public interface EmployeePortoFolioRepository   extends JpaRepository<EmployeePortoFolio, Long> {}
