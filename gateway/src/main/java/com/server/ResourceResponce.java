package com.server;

import com.google.gson.JsonElement;

public class ResourceResponce {

	private String message;
	
	private String status;
	
	private JsonElement data; 
	
	public ResourceResponce(String message, String status, JsonElement data) {
		super();
		this.message = message;
		this.status = status;
		this.data = data;
	}


	public JsonElement getData() {
		return data;
	}


	public String getMessage() {
		return message;
	}


	public String getStatus() {
		return status;
	}

}
