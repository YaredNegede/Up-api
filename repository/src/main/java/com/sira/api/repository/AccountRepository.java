package com.sira.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sira.model.stateschema.common.Users;

@Repository("accountRepository")
public interface AccountRepository extends JpaRepository<Users, Long> {
	
	
}