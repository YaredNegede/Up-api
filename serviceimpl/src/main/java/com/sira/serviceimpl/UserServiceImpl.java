package com.sira.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sira.api.repository.UserRepository;
import com.sira.model.stateschema.common.Users;
import com.sira.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void signup(Users user) {
		
		
	}
	@Override
	public void login(Users user) {
		
		
	}
	@Override
	public void logout(Users user) {
		
		
	}
	@Override
	public void verify(Users user) {
		
		
	}
	@Override
	public void update(Users user) {
		
		
	}
	@Override
	public void deactivate(Users user) {
		
		
	}
	public UserRepository getUserRepository() {
	
		return userRepository;
		
	}
	
}
