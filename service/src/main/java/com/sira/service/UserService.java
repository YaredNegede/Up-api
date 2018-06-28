package com.sira.service;

import org.springframework.stereotype.Service;

import com.sira.model.stateschema.common.Users;
@Service
public interface UserService {
	
	public void signup(Users user);
	
	public void login(Users user);
	
	public void logout(Users user);
	
	public void verify(Users user);
	
	public void update(Users user);
	
	public void deactivate(Users user);

}
