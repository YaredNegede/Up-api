package com.sira.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sira.model.stateschema.employee.EmployeeReview;

@Repository("employeeReviewRepository")
public interface EmployeeReviewRepository extends JpaRepository<EmployeeReview, Long> {}
 