package com.sira.api.repository;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

public interface Repository <T> {

	@Transactional
	public T getById(long id);
	
	@Transactional
	public List<T> getAll(long userId);
	
	@Transactional
	public List<T> getAllMaching();
	
	@Transactional
	public T save(T t);
	
	@Transactional
	public T delete(T t);
	
	@Transactional
	public T deleteMaching(T t);
	
}
