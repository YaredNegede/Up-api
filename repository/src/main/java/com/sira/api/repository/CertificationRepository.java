package com.sira.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sira.model.stateschema.employee.Certefication;

@Repository("certificationRepository")
public interface CertificationRepository  extends JpaRepository<Certefication, Long> {}
