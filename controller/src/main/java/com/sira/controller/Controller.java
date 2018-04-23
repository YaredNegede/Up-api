package com.sira.controller;

import java.util.List;

public interface Controller <T>{
	
	public T getById(long id);
	
	public List<T> getAll(long userId);
	
	public List<T> getAllMaching();
	
	public T save(T t);
	
	public T delete(T t) ;
	
	public T deleteMaching(T t) ;
	
}
