package com.server.controller;

import com.google.gson.JsonElement;
import com.server.ResourceRequest;
import com.server.error.GateException;

public interface BaseController {

	public void add(ResourceRequest resourceRequest) throws GateException;

	public JsonElement view(ResourceRequest resourceRequest) throws GateException;

	public JsonElement viewAll(ResourceRequest resourceRequest)  throws GateException ;

	public void update(ResourceRequest resourceRequest) throws GateException;

	public void delete(ResourceRequest resourceRequest) throws GateException;

}
