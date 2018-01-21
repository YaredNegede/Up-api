package com.server.error;

public class GateException extends Exception {

	private String message;

	public GateException(String localizedMessage) {

		this.message=localizedMessage;
		
	}

	
	public String getMessage() {
		return message;
	}


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	

}
