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

/**
 * Servlet implementation class Sever.
 * 
 * @author Yared Negede
 */
public abstract class Server extends HttpServlet  implements Controller{

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

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,  IOException{

		ResourceRequest resourceRequest = null;

		ResourceResponce resourceResponce ;

		JsonElement js = null;

		try {

			 resourceRequest = this.getContext().getGson().fromJson(req.getReader(), ResourceRequest.class);

			 this.add(resourceRequest);

			 resourceResponce = new ResourceResponce("", "OK", js);
			 
		} catch (Exception e) {

			logger.error(e);

			resourceResponce = new ResourceResponce(e.getLocalizedMessage(), "ERROR", null);

		} 

		resp.getWriter().write(this.getContext().getGson().toJson(resourceResponce));

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		ResourceRequest resourceRequest = null;

		ResourceResponce resourceResponce = null ;

		try {

			resourceRequest = this.getContext().getGson().fromJson(req.getReader(), ResourceRequest.class);

			JsonElement je = this.view(resourceRequest);
			
			resourceResponce = new ResourceResponce("", "OK", je);

		}  catch (Exception e) {

			logger.error(e);

			resourceResponce = new ResourceResponce(e.getLocalizedMessage(), "ERROR", null);

		} 

		resp.getWriter().write(this.getContext().getGson().toJson(resourceResponce));

	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		ResourceRequest resourceRequest = null;

		ResourceResponce resourceResponce = null ;

		try {

			resourceRequest = this.getContext().getGson().fromJson(req.getReader(), ResourceRequest.class);

			this.update(resourceRequest);
			
			resourceResponce = new ResourceResponce("", "OK", null);

		}  catch (Exception e) {

			logger.error(e);

			resourceResponce = new ResourceResponce(e.getLocalizedMessage(), "ERROR", null);

		} 

		resp.getWriter().write(this.getContext().getGson().toJson(resourceResponce));


	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		ResourceRequest resourceRequest = null;

		ResourceResponce resourceResponce = null ;

		try {

			resourceRequest = this.getContext().getGson().fromJson(req.getReader(), ResourceRequest.class);

			this.delete(resourceRequest);
			
			resourceResponce = new ResourceResponce("", "OK", null);

		}  catch (Exception e) {

			logger.error(e);

			resourceResponce = new ResourceResponce(e.getLocalizedMessage(), "ERROR", null);

		} 

		resp.getWriter().write(this.getContext().getGson().toJson(resourceResponce));

	}

	@Override
	protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		ResourceRequest resourceRequest = null;

		ResourceResponce resourceResponce = null ;

		JsonElement je;
		
		try {

			resourceRequest = this.getContext().getGson().fromJson(req.getReader(), ResourceRequest.class);

			 je = this.viewAll(resourceRequest);
			
			resourceResponce = new ResourceResponce("", "OK", je);

		}  catch (Exception e) {

			logger.error(e);

			resourceResponce = new ResourceResponce(e.getLocalizedMessage(), "ERROR", null);

		} 
		
		resp.getWriter().write(this.getContext().getGson().toJson(resourceResponce));


	}

	public abstract JsonElement viewAll(ResourceRequest resourceRequest)  throws GateException ;

	public abstract void add(ResourceRequest resourceRequest) throws GateException ;

	public abstract JsonElement view(ResourceRequest resourceRequest) throws GateException ;

	public abstract void update(ResourceRequest resourceRequest) throws GateException ;

	public abstract void delete(ResourceRequest resourceRequest) throws GateException ;

	public Context getContext() {

		return this.context;

	}

}
