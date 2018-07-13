package com.sira.uplancer.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

@Configuration
@ComponentScan({"com.sira.uplancer.controller"})
@EnableWebMvc
public class WebappConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		
		return new Class[] {SecurityConfig.class,UplancerDatastore.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		
		return new Class[] {SpringWebConfig.class};
		
	}

	@Override
	protected String[] getServletMappings() {
		
		return new String[] {"/"};
		
	}

}
