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
import com.google.gson.JsonElement;
import com.server.error.GateException;
import com.sira.api.EmployeeInfo;
import com.sira.api.error.APIException;
import com.sira.api.request.Context;
import com.sira.model.stateschema.model.Account;
import com.sira.model.stateschema.model.Address;
import com.sira.model.stateschema.model.Employee;
import com.sira.model.stateschema.model.Employer;
import com.sira.model.stateschema.model.Profile;
import com.sira.model.stateschema.model.Skill;


public class EmployeeControllerDeleteTest {

	private static Logger logger = Logger.getLogger(EmployeeControllerDeleteTest.class);

	private static ApplicationContext appcont = new ClassPathXmlApplicationContext("/applicationContext.xml");

	Gson gson = new Gson();

	static EmployeeInfo employeeInfo = (EmployeeInfo) appcont.getBean("Employee");

	EmployeeController server = new EmployeeController();

	@Before
	public  void setup(){

		logger.info("***********************************"+this.getClass().getName()+"***********************************");

		if(!employeeInfo.getEntitimanager().getTransaction().isActive()){
			employeeInfo.getEntitimanager().getTransaction().begin();
		}
	}

	@Test(expected=NoResultException.class)
	public void testDelete() throws GateException, APIException {

		server.setContext(new Context(appcont ));

		Employee employee = new Employee();

		employee.setFirstName("Yared");

		employee.setMiddleName("Negede");

		employee.setLastName("Yeshitla");

		Account account = new Account();

		account.setNumber("1231");

		account.setType("premium");

		employee.setAccount(account );

		Address address = new Address();

		address.setCity("Addis Ababa");

		employee.setAddress(address );

		Profile profile = new Profile();

		profile.setName("javascript");

		List<Skill> skills = new ArrayList<Skill>();

		Skill skill = new Skill();

		skill.setDescription("very good in javacript");

		skills.add(skill );

		List<Profile> profiles = new ArrayList<Profile>();
		profiles.add(profile);
		employee.setProfile(profiles );

		employeeInfo.getEntitimanager().persist(employee);

		JsonElement element = gson.toJsonTree(employee);

		logger.info(element);

		server.delete(employee );

		Query q = employeeInfo.getEntitimanager().createQuery("from Employee as epr where epr.firstName='"+employee.getFirstName()+"'");


		Employer epr = (Employer) q.getSingleResult();

		Assert.assertNull(epr);

	}

	@Test(expected=GateException.class)
	public void testError01() throws GateException {
		exp=true;
		server.add(null);
	}

	@Test(expected=GateException.class)
	public void testError02() throws GateException {
		exp=true;
		Employer empr = new  Employer();
		server.view(empr );
	}

	@Test(expected=GateException.class)
	public void testError03() throws GateException {
		exp=true;
		server.update(null);
	}

	@Test(expected=GateException.class)
	public void testError04() throws GateException {
		exp=true;
		server.delete(null);
	}


	boolean exp = false;
	@After
	public  void tearDown(){
		if(!exp){
			employeeInfo.getEntitimanager().getTransaction().commit();;
		} else {
			employeeInfo.getEntitimanager().getTransaction().rollback();
		}
	}

}
