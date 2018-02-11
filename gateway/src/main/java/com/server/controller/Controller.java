package com.server.controller;

import com.google.gson.JsonElement;
import com.server.ResourceRequest;
import com.server.error.GateException;

public interface Controller extends BaseController{

	public void addSkill(ResourceRequest resourceRequest) throws GateException;

	public void addProfile(ResourceRequest resourceRequest) throws GateException;

	public JsonElement viewSkill(ResourceRequest resourceRequest) throws GateException;

	public JsonElement viewProfile(ResourceRequest resourceRequest) throws GateException;

	public JsonElement updateSkill(ResourceRequest resourceRequest) throws GateException;

	public JsonElement updateProfile(ResourceRequest resourceRequest) throws GateException;

	public void deleteSkill(ResourceRequest resourceRequest) throws GateException;

	public void deleteProfile(ResourceRequest resourceRequest) throws GateException;

}
