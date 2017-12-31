package com.server;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.google.gson.JsonElement;
import com.red.api.request.Context;

/**
 * Servlet implementation class Sever.
 * 
 * @author Yared Negede
 */
public class Server extends HttpServlet {

	private static final long serialVersionUID = -158170587774263107L;

	private static Logger logger = Logger.getLogger(Server.class);

	private ApplicationContext applicationContext;

	private Context context;

	@Override
	public void init(){

		this.context = new Context(WebApplicationContextUtils.getRequiredWebApplicationContext(this.getServletContext()));

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, 
			IOException{
		
		JsonElement responce = null;
		
		String request = req.getReader().readLine();
		
		try {
			
			responce = this.dispach(request);
			
		} catch (Exception e) {

			responce = this.getContext().getGson().toJsonTree(responce);
			
		}
		
	}

	protected JsonElement dispach(String jeElement){

		return this.getContext().process();
		
	}

	public Context getContext() {

		return this.context;

	}

	public void setContext(Context context) {

		this.context = context;

	}

}
