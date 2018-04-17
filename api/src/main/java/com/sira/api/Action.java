package com.sira.api;

import com.sira.api.error.APIException;
import com.sira.model.stateschema.model.UserBase;

public interface Action {
	
	public abstract void Add(UserBase userBase) throws APIException ;

	public abstract void Update(UserBase userBase) throws APIException ;

	public abstract void Delete(UserBase userBase) throws APIException ;

	public abstract UserBase View(UserBase userBase) throws APIException;
}
