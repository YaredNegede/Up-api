package com.sira.controller.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public class RestAuthenticationEntryPoint  implements AuthenticationEntryPoint{

	private static Logger logger = Logger.getLogger(AuthenticationEntryPoint.class);
	
	@Override
	public void commence(HttpServletRequest request,
			HttpServletResponse response,
			AuthenticationException authException) 
					throws IOException, ServletException {
		
		logger.info("____________________________________________________________");
		
//		response.sendError( HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized" );
		
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		
		response.getWriter().write("HTTP Error 401 :" +authException.getMessage());
	}

}