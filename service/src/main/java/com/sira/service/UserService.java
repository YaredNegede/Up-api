package com.sira.service;

import com.sira.model.stateschema.common.User;

public interface UserService {
	
	public void signup(User user);
	
	public void login(User user);
	
	public void logout(User user);
	
	public void verify(User user);
	
	public void update(User user);
	
	public void deactivate(User user);

}
