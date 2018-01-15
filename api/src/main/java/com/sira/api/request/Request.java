package com.sira.api.request;

public class Request {

	private long Id;

	private String userId;

	private Operation operation;
	
	private Class<Object> type; // this should not be infered from request, there has to be lookup

	private String data;

	public Request(long id, String userId) {

		this.Id = id;

		this.userId = userId;


	}

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
	
	public Operation getOperation() {
	
		return operation;
		
	}

	public void setId(long id) {
		Id = id;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setOperation(Operation operation) {
		this.operation = operation;
	}

	public void setType(Class<Object> type) {
		this.type = type;
	}

	public void setData(String data) {
		this.data = data;
	}

	
}
