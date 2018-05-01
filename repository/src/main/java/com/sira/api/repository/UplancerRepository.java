package com.sira.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sira.model.stateschema.uplancer.Uplancer;

@Repository("uplancerRepository")
public interface UplancerRepository extends JpaRepository<Uplancer, Long> {}
