package com.server;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import com.google.gson.Gson;
import com.server.controller.EmployeeController;
import com.sira.api.request.Request;

import mockit.Expectations;
import mockit.Mocked;

public class ServerTest {

	Gson gson = new Gson();

	@Test(expected=Exception.class)
	public void test001() throws ServletException, IOException {

		EmployeeController server = new EmployeeController();

		MockHttpServletResponse resp = new MockHttpServletResponse();

		MockHttpServletRequest req = new MockHttpServletRequest();

		server.doPost(req , resp);

	}

	@Test(expected=Exception.class)
	public void test002() throws ServletException, IOException {

		EmployeeController server = new EmployeeController();
		long id  = 12;

		Request request = new Request(id, "");

		MockHttpServletResponse resp = new MockHttpServletResponse();

		MockHttpServletRequest req = new MockHttpServletRequest();

		req.setContent(gson.toJson(request).getBytes());

		server.doPost(req , resp);

	}

//	@Test
	public void test003(@Mocked final HttpServletRequest req) throws ServletException, IOException {

		EmployeeController server = new EmployeeController();
		
		MockHttpServletResponse resp = new MockHttpServletResponse();

//		final MockHttpServletRequest req = new MockHttpServletRequest();
		
		String file = "src/test/resources/com/server/request/employee/AddEmployee.json";
		Reader in = new FileReader(file );
		final BufferedReader rd = new BufferedReader(in );

		new Expectations () {{
			req.getReader();this.result = rd;
		}};

		server.doPost(req , resp);

	}

}
