package com.server.controller;

import com.google.gson.JsonElement;
import com.server.error.GateException;
import com.sira.model.stateschema.model.UserBase;

public interface Controller  {

	public void add(UserBase userBase) throws GateException;

	public JsonElement view(UserBase userBase) throws GateException;

	public void update(UserBase userBase) throws GateException;

	public void delete(UserBase userBase) throws GateException;
	
}
