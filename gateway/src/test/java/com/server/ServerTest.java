package com.server;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;

import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.sira.api.request.APIFactory;
import com.sira.api.request.Operation;
import com.sira.api.request.Request;
import com.sira.api.request.RequestEntity;

public class ServerTest {

	Gson gson = new Gson();
	
	@Test(expected=Exception.class)
	public void test001() throws ServletException, IOException {

		Server server = new Server();
		
		MockHttpServletResponse resp = new MockHttpServletResponse();
		
		MockHttpServletRequest req = new MockHttpServletRequest();
		
		server.doGet(req , resp);
		
	}
	
	@Test(expected=Exception.class)
	public void test002() throws ServletException, IOException {

		Server server = new Server();
		long id  = 12;
		
		Request request = new Request(id, "");
		
		MockHttpServletResponse resp = new MockHttpServletResponse();
		
		MockHttpServletRequest req = new MockHttpServletRequest();
		
		req.setContent(gson.toJson(request).getBytes());
		
		server.doGet(req , resp);
		
	}
	
	@Test
	public void test003() throws ServletException, IOException {

		Server server = new Server();
		
		long id  = 12;
		
		Request request = new Request(id, "yared@negede.com");
		
		MockHttpServletResponse resp = new MockHttpServletResponse();
		
		MockHttpServletRequest req = new MockHttpServletRequest();
		
		req.setContent(gson.toJson(request).getBytes());
		
		server.doGet(req , resp);
		
	}
	
	@Test
	public void generateJson() throws InstantiationException, IllegalAccessException{
		
		Random r = new  Random();

		APIFactory aPIFactory = new APIFactory();
		
		aPIFactory.initAPI();
		
		aPIFactory.initModels();
		
		for (Operation Operation : Operation.values()) {
			
			Request request = new Request(Math.abs(r.nextLong()), "yared@sira.com");
			
			request.setOperation(Operation);

			for (RequestEntity RequestEntity : RequestEntity.values()) {

				Class<? extends Object> claszz = APIFactory.getEntityMapping().get(RequestEntity);
				
				request.setData(new Gson().toJson(claszz.newInstance() ));
				
				System.out.println(new Gson().toJson(request));
				
			}
			
		}
		
	}

}
