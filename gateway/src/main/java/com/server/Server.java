package com.server;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.server.controller.Controller;
import com.server.error.GateException;
import com.sira.api.request.Context;

/**
 * Servlet implementation class Sever.
 * 
 * @author Yared Negede
 */
public abstract class Server extends HttpServlet  implements Controller{

	private static final long serialVersionUID = 5983443603268366839L;

	private static Logger logger = Logger.getLogger(Server.class);

	private Context context;

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

		ResourceResponce resourceResponce = new ResourceResponce();

		try {

			resourceRequest = this.getContext().getGson().fromJson(req.getReader(), ResourceRequest.class);

			resourceResponce = this.add(resourceRequest);
			
		} catch (JsonSyntaxException e) {

			logger.error(e);
			
			resourceResponce.setMessage(e.getMessage());

		} catch (JsonIOException e) {
			
			logger.error(e);
			
			resourceResponce.setMessage(e.getMessage());

		} catch (GateException e) {

			logger.error(e);
			
			resourceResponce.setMessage(e.getMessage());
			
		}

		resp.getWriter().write(this.getContext().getGson().toJson(resourceResponce));

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		ResourceRequest resourceRequest = null;

		ResourceResponce resourceResponce = new ResourceResponce();

		try {

			resourceRequest = this.getContext().getGson().fromJson(req.getReader(), ResourceRequest.class);

			resourceResponce = this.view(resourceRequest);
			
		} catch (JsonSyntaxException e) {

			logger.error(e);
			
			resourceResponce.setMessage(e.getMessage());

		} catch (JsonIOException e) {
			
			logger.error(e);
			
			resourceResponce.setMessage(e.getMessage());

		} catch (GateException e) {

			logger.error(e);
			
			resourceResponce.setMessage(e.getMessage());
			
		}

		resp.getWriter().write(this.getContext().getGson().toJson(resourceResponce));

	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		ResourceRequest resourceRequest = null;

		ResourceResponce resourceResponce = new ResourceResponce();

		try {

			resourceRequest = this.getContext().getGson().fromJson(req.getReader(), ResourceRequest.class);

			resourceResponce = this.update(resourceRequest);
			
		} catch (JsonSyntaxException e) {

			logger.error(e);
			
			resourceResponce.setMessage(e.getMessage());

		} catch (JsonIOException e) {
			
			logger.error(e);
			
			resourceResponce.setMessage(e.getMessage());

		} catch (GateException e) {

			logger.error(e);
			
			resourceResponce.setMessage(e.getMessage());
			
		}

		resp.getWriter().write(this.getContext().getGson().toJson(resourceResponce));


	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		ResourceRequest resourceRequest = null;

		ResourceResponce resourceResponce = new ResourceResponce();

		try {

			resourceRequest = this.getContext().getGson().fromJson(req.getReader(), ResourceRequest.class);

			resourceResponce = this.delete(resourceRequest);
			
		} catch (JsonSyntaxException e) {

			logger.error(e);
			
			resourceResponce.setMessage(e.getMessage());

		} catch (JsonIOException e) {
			
			logger.error(e);
			
			resourceResponce.setMessage(e.getMessage());

		} catch (GateException e) {

			logger.error(e);
			
			resourceResponce.setMessage(e.getMessage());
			
		}

		resp.getWriter().write(this.getContext().getGson().toJson(resourceResponce));

	}

	@Override
	protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		ResourceRequest resourceRequest = null;

		ResourceResponce resourceResponce = new ResourceResponce();

		try {

			resourceRequest = this.getContext().getGson().fromJson(req.getReader(), ResourceRequest.class);

			resourceResponce = this.viewAll(resourceRequest);
			
		} catch (JsonSyntaxException e) {

			logger.error(e);
			
			resourceResponce.setMessage(e.getMessage());

		} catch (JsonIOException e) {
			
			logger.error(e);
			
			resourceResponce.setMessage(e.getMessage());

		} catch (GateException e) {

			logger.error(e);
			
			resourceResponce.setMessage(e.getMessage());
			
		}

		resp.getWriter().write(this.getContext().getGson().toJson(resourceResponce));


	}

	public abstract ResourceResponce viewAll(ResourceRequest resourceRequest)  throws GateException ;

	public abstract ResourceResponce add(ResourceRequest resourceRequest) throws GateException ;

	public abstract ResourceResponce view(ResourceRequest resourceRequest) throws GateException ;

	public abstract ResourceResponce update(ResourceRequest resourceRequest) throws GateException ;

	public abstract ResourceResponce delete(ResourceRequest resourceRequest) throws GateException ;

	public Context getContext() {

		return this.context;

	}

}
