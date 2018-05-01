package com.sira.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sira.model.stateschema.common.Addres;

@Repository("addresRepository")
public interface AddresRepository  extends JpaRepository<Addres, Long> {
	
}