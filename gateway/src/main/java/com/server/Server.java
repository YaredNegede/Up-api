package com.server;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.sira.api.request.Context;

/**
 * Servlet implementation class Sever.
 * 
 * @author Yared Negede
 */
public class Server extends HttpServlet {

	private static final long serialVersionUID = -158170587774263107L;

	private static Logger logger = Logger.getLogger(Server.class);

	private Context context;

	@Override
	public void init(){
		
		logger.info("Initialization of server");

		this.context = new Context(WebApplicationContextUtils.getRequiredWebApplicationContext(this.getServletContext()));

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, 
			IOException{
		
		try {
			
			this.getContext().process(req.getReader());
			
		} catch (Exception e) {

			logger.error(e);
			
			resp.getWriter().write(this.getContext().getGson().toJsonTree(e).toString());
			
		}
		
		
	}

	public Context getContext() {

		return this.context;

	}

}
