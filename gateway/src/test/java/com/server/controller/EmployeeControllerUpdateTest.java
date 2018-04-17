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
import com.server.error.GateException;
import com.sira.api.EmployeeInfo;
import com.sira.api.error.APIException;
import com.sira.api.request.Context;
import com.sira.model.stateschema.model.Account;
import com.sira.model.stateschema.model.Address;
import com.sira.model.stateschema.model.Employee;
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

		EmployeeController server = new EmployeeController();

		server.setContext(new Context(appcont));

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
		
		employee.setFirstName("Daniel");
		JsonElement element = gson.toJsonTree(employee);

		
		server.update(employee );

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
