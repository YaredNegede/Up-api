package com.sira.serviceimpl.util;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.sira.model.stateschema.common.Users;

public class UserDetail implements UserDetails{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Users users;
	
	
	public UserDetail(Users users) {
		super();
		
		this.users = users;
	}

	@Override
	public boolean isEnabled() {
		return users.isEnabled();
	}
	
	@Override
	public boolean isCredentialsNonExpired() {

		return true;
	}
	
	@Override
	public boolean isAccountNonLocked() {
		return false;
	}
	
	@Override
	public boolean isAccountNonExpired() {
		
		return false;
	}
	
	@Override
	public String getUsername() {
		
		return users.getUsername();
	}
	
	@Override
	public String getPassword() {
		
		return users.getPassword();
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return null;
	}

	public Users getUsers() {
		return users;
	}
	
	
}
