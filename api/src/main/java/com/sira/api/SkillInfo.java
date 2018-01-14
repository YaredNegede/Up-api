package com.sira.api;

import javax.persistence.EntityManager;

import com.sira.api.request.Request;
import com.sira.api.security.Security;

public class SkillInfo extends DataAccess {

	public SkillInfo(EntityManager entitimanager, Security security, Request request) {

		super(entitimanager, security, request);

	}

}
