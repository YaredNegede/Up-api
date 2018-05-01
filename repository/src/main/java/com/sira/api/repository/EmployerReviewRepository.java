package com.sira.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sira.model.stateschema.employer.EmployerReview;

@Repository("employerReviewRepository")
public interface EmployerReviewRepository extends JpaRepository<EmployerReview, Long> {}
