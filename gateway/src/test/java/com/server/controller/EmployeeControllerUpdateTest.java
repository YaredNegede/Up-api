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
import com.server.Server;
import com.server.error.GateException;
import com.sira.api.EmployeeInfo;
import com.sira.api.error.APIException;
import com.sira.api.request.Context;
import com.sira.model.stateschema.model.Account;
import com.sira.model.stateschema.model.Address;
import com.sira.model.stateschema.model.Country;
import com.sira.model.stateschema.model.Employee;
import com.sira.model.stateschema.model.Employer;
import com.sira.model.stateschema.model.Profile;
import com.sira.model.stateschema.model.Skill;

public class EmployeeControllerUpdateTest {

	private static Logger logger = Logger.getLogger(EmployeeControllerUpdateTest.class);

	private static ApplicationContext appcont = new ClassPathXmlApplicationContext("/applicationContext.xml");

	Gson gson = new Gson();

	static EmployeeInfo employeeInfo = (EmployeeInfo) appcont.getBean("Employee");

	@Before
	public  void setup(){
		if(!employeeInfo.getEntitimanager().getTransaction().isActive()){
			employeeInfo.getEntitimanager().getTransaction().begin();
		}
	}

	@Test
	public void testUpdate() throws GateException, APIException {

		Server server = new EmployeeController();

		server.context = new Context(appcont );

		Employee employee = new Employee();

		employee.setUsername("username");

		employee.setPassword("password");

		employee.setFirstName("Yared");

		employee.setMiddleName("Negede");

		employee.setLastName("Yeshitla");

		Account account = new Account();

		account.setNumber("1231");

		account.setType("premium");

		employee.setAccount(account );

		Address address = new Address();

		address.setCity("Addis Ababa");

		Country country = new Country();

		country.setCode("123");

		country.setName("Ethiopia");

		address.setCountry(country );

		employee.setAddress(address );

		Profile profile = new Profile();

		profile.setName("javascript");

		List<Skill> skills = new ArrayList<Skill>();

		Skill skill = new Skill();

		skill.setDescription("very good in javacript");

		skills.add(skill );

		profile.setSkills(skills );

		employee.setProfile(profile );

		employeeInfo.getEntitimanager().persist(employee);
		
		employee.setFirstName("Daniel");
		JsonElement element = gson.toJsonTree(employee);

		logger.info(element.toString());
		ResourceRequest resourceRequest = new ResourceRequest(element);
		server.update(resourceRequest );

		Query q = employeeInfo.getEntitimanager().createQuery("from Employee as emplr where emplr.firstName='"+employee.getFirstName()+"'");
		Employee e = (Employee) q.getSingleResult();
		Assert.assertTrue(e.equals(employee));

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
