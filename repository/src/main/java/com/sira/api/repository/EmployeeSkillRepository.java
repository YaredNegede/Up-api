package com.sira.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sira.model.stateschema.common.Skill;
/**
 * 
 * @author Yared
 *
 */
@Repository("employeeSkillRepository")
public interface EmployeeSkillRepository  extends JpaRepository<Skill, Long> {}
