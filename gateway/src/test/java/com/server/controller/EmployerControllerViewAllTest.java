package com.server.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.server.ResourceRequest;
import com.server.ResourceResponce;
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

public class EmployerControllerViewAllTest {

	private static Logger logger = Logger.getLogger(EmployerControllerViewAllTest.class);

	private static ApplicationContext appcont = new ClassPathXmlApplicationContext("/applicationContext.xml");

	Gson gson = new Gson();

	static EmployerInfo employerInfo = (EmployerInfo) appcont.getBean("Employer");

	@Before
	public  void setup(){
		if(!employerInfo.getEntitimanager().getTransaction().isActive()){
			employerInfo.getEntitimanager().getTransaction().begin();
		}
	}

	@Test
	public void testViewAll() throws GateException, APIException {

		Server server = new EmployerController();

		server.context = new Context(appcont );

		Employer employer = new Employer();

		employer.setName("sira");
		Account account = new Account();
		account.setNumber("1234567");
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
		
		JsonElement je = server.viewAll(resourceRequest );

		Assert.assertNotNull(je);

		ResourceResponce resourceResponce = gson.fromJson(je, ResourceResponce.class);
		
		Assert.assertNotNull(resourceResponce.getData());
		
		Assert.assertEquals("OK",resourceResponce.getStatus());
		
		Assert.assertEquals("Found Employeers",resourceResponce.getMessage());
	}

	boolean exp = false;
		
	@After
	public  void tearDown(){
		if(!exp){
			employerInfo.getEntitimanager().getTransaction().commit();;
		} else {
			employerInfo.getEntitimanager().getTransaction().rollback();
		}
	}

}
