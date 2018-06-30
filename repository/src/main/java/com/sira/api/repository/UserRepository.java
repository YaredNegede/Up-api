package com.sira.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sira.model.stateschema.common.Users;
/**
 * 
 * @author Yared
 *
 */
@Repository("workRepository")
public interface UserRepository extends JpaRepository<Users, Long> {

	public Users findByUsername(String username);

}