package com.server;

import javax.servlet.http.HttpServlet;

import org.apache.log4j.Logger;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.sira.api.request.Context;

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

	protected Context context;

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
	
	public void setContext(Context context) {
		this.context = context;
	}

	
}
