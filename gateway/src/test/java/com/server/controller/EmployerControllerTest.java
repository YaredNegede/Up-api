package com.server.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.server.ResourceRequest;
import com.server.Server;
import com.server.error.GateException;
import com.sira.api.EmployerInfo;
import com.sira.api.error.APIException;
import com.sira.api.request.Context;
import com.sira.model.stateschema.model.Account;
import com.sira.model.stateschema.model.Address;
import com.sira.model.stateschema.model.Country;
import com.sira.model.stateschema.model.Employer;
import com.sira.model.stateschema.model.Profile;
import com.sira.model.stateschema.model.Skill;

public class EmployerControllerTest {

	private static Logger logger = Logger.getLogger(EmployerControllerTest.class);
	
	private ApplicationContext appcont = new ClassPathXmlApplicationContext("/applicationContext.xml");
	
	Gson gson = new Gson();
	
	@Test
	public void testAdd() throws GateException, APIException {
		
		Server server = new EmployerController();
		
		server.context = new Context(appcont );
		
		Employer employer = new Employer();
		
		employer.setName("sira");
		Account account = new Account();
		account.setNumber("123");
		account.setType("premium");
		employer.setAccount(account );
		
		Address address = new Address();
		address.setCity("Addis ababa");
		
		Country ethiopia = new Country();
		ethiopia.setCode("ET");
		ethiopia.setName("Ethiopia");
		address.setCountry(ethiopia );
		employer.setAddress(address );
		
		Profile profile = new Profile();
		profile.setName("Language");
		
		List<Skill> skills = new ArrayList<Skill>();
		Skill skill = new Skill();
		skill.setDescription("Very good");
		skill.setName("javascript");
		skills.add(skill );
		
		profile.setSkills(skills );
		employer.setProfile(profile );
		JsonElement element = gson.toJsonTree(employer);
		
		logger.info(element.toString());
		ResourceRequest resourceRequest = new ResourceRequest(element);
		server.add(resourceRequest );

		
	}

}
