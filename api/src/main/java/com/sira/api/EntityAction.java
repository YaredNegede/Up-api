package com.sira.api;

import java.util.List;

import com.sira.api.error.APIException;
import com.sira.model.stateschema.model.Profile;

public interface EntityAction {

	void Add(Profile profile) throws APIException;

	void Update(Profile profile) throws APIException;

	void Delete(Profile profile) throws APIException;

	Profile View(Profile profile) throws APIException;

	List<Profile> ViewAll(Profile profile) throws APIException;

}
