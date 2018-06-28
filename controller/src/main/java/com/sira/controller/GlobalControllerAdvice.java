package com.sira.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice(annotations=Controller.class)
public class GlobalControllerAdvice {
	
	

	@ExceptionHandler(Exception.class)
	@ResponseBody
	public String handleError(HttpServletRequest request){
		
		System.out.println("**************************************");
		
		return "controller_error";
	
	}
}
