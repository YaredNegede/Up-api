package com.sira.serviceimpl.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sira.api.repository.UserRepository;
import com.sira.model.stateschema.common.Users;

@Service
public class UserServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository UserRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Users us = new Users();
		us.setUsername("yared");
		us.setPassword("yared");
		
		this.getUserRepository().save(us);
		
		Users user = this.getUserRepository().findByUsername(username);
		
		return new UserDetail(user);
	}

	public UserRepository getUserRepository() {
		
		return UserRepository;
		
	}
	
}
