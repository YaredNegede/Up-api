package com.sira.api;

import java.util.List;

import com.sira.api.error.APIException;
import com.sira.model.stateschema.model.Skill;

public interface SkillAction {

	void Add(Skill skill) throws APIException;

	void Update(Skill skill) throws APIException;

	void Delete(Skill skill) throws APIException;

	Skill View(Skill skill) throws APIException;

	List<Skill> ViewAll(Skill skill) throws APIException;

}
