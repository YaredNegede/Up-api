package com.server;

import java.io.Serializable;

import com.google.gson.JsonElement;

public class ResourceRequest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JsonElement element;

	public ResourceRequest(JsonElement element) {

		this.element = element;
		
	}

	public JsonElement getJsonElement() {
		
		return this.element;
	
	}

}
