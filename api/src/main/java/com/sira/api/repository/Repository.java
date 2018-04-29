package com.sira.api.repository;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.sira.api.repository.error.UplancerException;

public abstract class Repository <T> {

	@Transactional
	public abstract T getById(long id) throws UplancerException;
	
	@Transactional
	public abstract List<T> getAll()throws UplancerException;
	
	@Transactional
	public abstract List<T> getAllMaching(T t)throws UplancerException;
	
	@Transactional
	public abstract void save(T t)throws UplancerException;
	
	@Transactional
	public abstract void delete(T t)throws UplancerException;
	
	@Transactional
	public abstract void deleteMaching(T t)throws UplancerException;
	
}
