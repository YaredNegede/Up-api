package com.sira.api;

import com.google.gson.JsonElement;
import com.sira.api.error.APIException;

public interface DataStore {

	public void Add(JsonElement data) throws APIException;
	
	public void Update(JsonElement data) throws APIException;
	
	public void Delete(JsonElement data) throws APIException;
	
	public JsonElement View(JsonElement data) throws APIException;
	
	public JsonElement ViewAll(JsonElement data) throws APIException;
	
}
