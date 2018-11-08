package com.sira.uplancer.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice(annotations=Controller.class)
public class GlobalControllerAdvice {

	private static Logger logger = Logger.getLogger(GlobalControllerAdvice.class);
	
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public String handleError(HttpServletRequest request){
		
		logger.info("**************************************");
		
		return "controller_error";
	
	}
}
