package com.server;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.google.gson.JsonElement;
import com.server.controller.Controller;
import com.server.error.GateException;
import com.sira.api.request.Context;
import com.sira.model.stateschema.model.UserBase;

/**
 * Servlet implementation class Sever.
 * 
 * @author Yared Negede
 */
public abstract class Server extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static Logger logger = Logger.getLogger(Server.class);

	public Context context;

	@Override
	public void init(){

		logger.debug("Initialization of server");

		try {

			this.context = new Context(WebApplicationContextUtils.getRequiredWebApplicationContext(this.getServletContext()));

		} catch (IllegalStateException e) {

			logger.error(e);

		}

		logger.debug("Initialization of server completed");

	}

	public Context getContext() {

		return this.context;

	}

}
