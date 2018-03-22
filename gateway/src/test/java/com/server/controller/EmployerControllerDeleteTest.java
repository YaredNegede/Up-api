package com.server.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.google.gson.Gson;
import com.server.error.GateException;
import com.sira.api.EmployerInfo;
import com.sira.api.error.APIException;
import com.sira.api.request.Context;
import com.sira.model.stateschema.model.Account;
import com.sira.model.stateschema.model.Address;
import com.sira.model.stateschema.model.Employer;
import com.sira.model.stateschema.model.Profile;
import com.sira.model.stateschema.model.Skill;

public class EmployerControllerDeleteTest {

	private static Logger logger = Logger.getLogger(EmployerControllerDeleteTest.class);

	private static ApplicationContext appcont = new ClassPathXmlApplicationContext("/applicationContext.xml");

	Gson gson = new Gson();

	static EmployerInfo employerInfo = (EmployerInfo) appcont.getBean("Employer");

	@Before
	public  void setup(){
		if(!employerInfo.getEntitimanager().getTransaction().isActive()){
			employerInfo.getEntitimanager().getTransaction().begin();
		}
	}

	@Test(expected=NoResultException.class)
	public void testDelete() throws GateException, APIException {

		logger.info("*************************Delete test************************");
		EmployerController server = new EmployerController();

		server.setContext(new Context(appcont ));

		Employer employer = new Employer();

		employer.setName("dVentus");
		Account account = new Account();
		account.setNumber("1234567");
		account.setType("premium");
		employer.setAccount(account );

		Address address = new Address();
		address.setCity("Addis ababa");

		employer.setAddress(address );

		Profile profile = new Profile();
		profile.setName("Language");

		List<Skill> skills = new ArrayList<Skill>();
		Skill skill = new Skill();
		skill.setDescription("Very good");
		skill.setName("javascript");
		skills.add(skill );

		profile.setSkills(skills );
		List<Profile> profiles = new ArrayList<Profile>();
		profiles.add(profile);
		employer.setProfile(profiles );

		employerInfo.getEntitimanager().persist(employer);
		
	  
		server.delete(employer );
		
		Query q = employerInfo.getEntitimanager().createQuery("from Employer as epr where epr.name='"+employer.getName()+"'");
		Employer epr = (Employer) q.getSingleResult();
		
		Assert.assertNull(epr);

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
