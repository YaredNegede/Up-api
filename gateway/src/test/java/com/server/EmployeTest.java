package com.server;

import java.io.IOException;

import javax.servlet.ServletException;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.server.controller.EmployeeController;
import com.server.error.GateException;
import com.sira.api.request.Context;
import com.sira.model.stateschema.model.Employee;

public class EmployeTest {

	private static Logger logger = Logger.getLogger(EmployeTest.class);

	private ApplicationContext appcont = new ClassPathXmlApplicationContext("/applicationContext.xml");
	
	Gson gson = new Gson();

	@Test
	public void test001() throws ServletException, IOException, GateException {

		MockHttpServletResponse resp = new MockHttpServletResponse();

		MockHttpServletRequest req = new MockHttpServletRequest();

		Employee employee = new Employee();

		employee.setUsername("username");

		employee.setPassword("password");

		JsonElement element = gson.toJsonTree(employee);

		ResourceRequest resourceRequest = new ResourceRequest(element);

		String reqRes = gson.toJson(resourceRequest);
		
		logger.info("reuest is "+ reqRes);
		
		byte[] content =  reqRes.getBytes();

		req.setContent(content);

		Server server = new  EmployeeController();

		server.context = new Context(appcont );
		
		server.add(resourceRequest);
		
	}
	

}
