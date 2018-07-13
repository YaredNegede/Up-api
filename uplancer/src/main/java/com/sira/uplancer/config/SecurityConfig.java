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
import org.springframework.security.data.repository.query.SecurityEvaluationContextExtension;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sira.serviceimpl.util.UserDetail;
import com.sira.serviceimpl.util.UserServiceImpl;
import com.sira.uplancer.security.AuthenticationFailureHandler;
import com.sira.uplancer.security.AuthenticationSuccessHandler;
import com.sira.uplancer.security.TokenHelper;

@Configuration
@EnableWebSecurity
@ComponentScan(basePackages= {"com.sira.serviceimpl.util","com.sira.uplancer.security"})
@Import(value = UplancerDatastore.class)
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	UserServiceImpl  userDetailsService;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth
		.inMemoryAuthentication()
		.withUser("user")
		.password("password")
		.roles("USER");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.antMatcher("/services/**")
		.authorizeRequests()
		.anyRequest().authenticated()
		.and()
		.formLogin().successHandler(authenticationSuccessHandler())
		.failureHandler(authenticationFailureHandler());
	}


	@Bean
	public SecurityEvaluationContextExtension securityEvaluationContextExtension() {
		return new SecurityEvaluationContextExtension();
	}

	@Override 
	public UserDetailsService userDetailsService()  {

		return userDetailsService;

	}
	
	@Bean
	public AuthenticationFailureHandler authenticationFailureHandler()  {

		return new AuthenticationFailureHandler();

	}
	
	@Bean
	public AuthenticationSuccessHandler authenticationSuccessHandler()  {

		return new AuthenticationSuccessHandler();

	}
	
	@Bean
	public TokenHelper TokenHelper()  {

		return new TokenHelper();

	}
	
	@Bean
	public ObjectMapper ObjectMapper()  {

		return new ObjectMapper();

	}
	
	@Bean
	public UserDetails UserDetails()  {

		return new UserDetail(null);

	}
}
