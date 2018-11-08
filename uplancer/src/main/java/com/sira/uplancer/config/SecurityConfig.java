package com.sira.uplancer.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;

import com.sira.serviceimpl.util.UserDetail;
import com.sira.serviceimpl.util.UserServiceImpl;

@Configuration
@EnableWebSecurity
@ComponentScan(basePackages= {"com.sira.serviceimpl.util","com.sira.uplancer.security"})
@Import(value = UplancerDatastore.class)
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	

	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		SCryptPasswordEncoder passwordEncoder = new SCryptPasswordEncoder();
		auth
		.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder).init(auth);
	}

	 
	protected void configure(HttpSecurity http) throws Exception {
		http
		.antMatcher("/api/**")
		.authorizeRequests()
		.anyRequest().authenticated();
		/*.and()
		.formLogin().successHandler(authenticationSuccessHandler())
		.failureHandler(authenticationFailureHandler());*/
	}

	 
	@Bean
	public UserDetails UserDetails()  {

		return new UserDetail(null);

	}
	
	@Autowired
	UserServiceImpl  userDetailsService;

	
	@Bean 
	public UserDetailsService userDetailsService()  {

		return userDetailsService;

	}
	
}
