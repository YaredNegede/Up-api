package com.server;

import java.io.IOException;

import javax.servlet.ServletException;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.server.controller.EmployeeController;
import com.sira.api.request.Context;
import com.sira.model.stateschema.model.Employee;

public class ServerTest {

	private static Logger logger = Logger.getLogger(ServerTest.class);

	Gson gson = new Gson();

	@Test(expected=Exception.class)
	public void test001() throws ServletException, IOException {

		EmployeeController server = new EmployeeController();

		MockHttpServletResponse resp = new MockHttpServletResponse();

		MockHttpServletRequest req = new MockHttpServletRequest();

		server.doPost(req , resp);

	}

	@Test
	public void test002() throws ServletException, IOException {

		MockHttpServletResponse resp = new MockHttpServletResponse();

		MockHttpServletRequest req = new MockHttpServletRequest();

		Employee employee = new Employee();

		employee.setUsername("username");

		employee.setPassword("password");

		JsonElement element = gson.toJsonTree(employee);

		ResourceRequest resourceRequest = new ResourceRequest(element);

		String resres = gson.toJson(resourceRequest);
		
		logger.info("reuest is "+resres);
		
		byte[] content = resres.getBytes();

		req.setContent(content);

		Server server = new  EmployeeController();

		server.context = new Context(new ClassPathXmlApplicationContext("/applicationContext.xml"));
		
		server.doPost(req, resp);

	}

}
