package com.sira.uplancer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.sira.service.EmployerService;
import com.sira.serviceimpl.EmployerServiceimpl;

@EnableWebMvc //<mvc:annotation-driven />
@Configuration
@ComponentScan({ "com.sira.uplancer.controller","com.sira.service" })
public class SpringWebConfig implements WebMvcConfigurer {
	 
	
	@Bean
	public EmployerService EmployerService()  {

		return new EmployerServiceimpl();

	}
}
