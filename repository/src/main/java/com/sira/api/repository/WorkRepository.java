package com.sira.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sira.model.stateschema.workbase.WorkBase;
/**
 * 
 * @author Yared
 *
 */
@Repository("workRepository")
public interface WorkRepository extends JpaRepository<WorkBase, Long> {}