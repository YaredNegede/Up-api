package com.sira.controller;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ControllerTest {

	ApplicationContext context = new ClassPathXmlApplicationContext("spring/dispacher-servlet.xml","spring/jpaContexts.xml");

	@Autowired
	EmployerController employerController;
	@Test
	public void test() {
		
		
		Assert.assertTrue(true);
		
	}

}
