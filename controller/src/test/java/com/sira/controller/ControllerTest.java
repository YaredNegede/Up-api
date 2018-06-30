package com.sira.controller;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class ControllerTest {

	ApplicationContext context = new ClassPathXmlApplicationContext("spring/dispacher-servlet.xml", "spring/jpaContexts.xml");

//	@Test
	public void test() {
		
		String[] beans =  context.getBeanDefinitionNames();
		
		for (String b : beans) {
			System.out.println(b);
		}
		
		Assert.assertNotNull(beans);
		
	}

}
