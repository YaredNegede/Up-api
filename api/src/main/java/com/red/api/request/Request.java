package com.red.api.request;

public class Request {

	private long Id;
	
	private String userId;
	
	private Class<Object> type; // this should not be infered from request, there has to be lookup
	
	private String data;

	public long getId() {
		
		return this.Id;
		
	}

	public Class<Object> getType() {

		return this.type;
		
	}

	public String getData() {

		return this.data;
		
	}

	public String getUserId() {
		return userId;
	}
	
}
