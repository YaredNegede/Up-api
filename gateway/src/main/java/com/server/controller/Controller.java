package com.server.controller;

import com.server.ResourceRequest;
import com.server.ResourceResponce;
import com.server.error.GateException;

public interface Controller {
	
	public ResourceResponce add(ResourceRequest resourceRequest) throws GateException;

	public ResourceResponce view(ResourceRequest resourceRequest) throws GateException;
	
	public ResourceResponce viewAll(ResourceRequest resourceRequest)  throws GateException ;
	
	public ResourceResponce update(ResourceRequest resourceRequest) throws GateException;
	
	public ResourceResponce delete(ResourceRequest resourceRequest) throws GateException;

}
