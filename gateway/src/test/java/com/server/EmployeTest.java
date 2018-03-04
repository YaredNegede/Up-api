package com.server;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mock.web.MockHttpServletRequest;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.server.controller.Controller;
import com.server.controller.EmployeeController;
import com.server.error.GateException;
import com.sira.api.request.Context;
import com.sira.model.stateschema.model.Account;
import com.sira.model.stateschema.model.Address;
import com.sira.model.stateschema.model.Employee;
import com.sira.model.stateschema.model.Profile;
import com.sira.model.stateschema.model.Skill;

public class EmployeTest {

	private static Logger logger = Logger.getLogger(EmployeTest.class);

	private ApplicationContext appcont = new ClassPathXmlApplicationContext("/applicationContext.xml");
	
	Gson gson = new Gson();

	@Test
	public void test001() throws ServletException, IOException, GateException {

		MockHttpServletRequest req = new MockHttpServletRequest();

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
		
		profile.setSkills(skills );
		
		List<Profile> profiles = new ArrayList<Profile>();
		profiles.add(profile);
		employee.setProfile(profiles );
		
		JsonElement element = gson.toJsonTree(employee);

		logger.info(element);
		

		EmployeeController controller = new  EmployeeController();

		controller.context = new Context(appcont );
		
		controller.add(employee);
		
	}

}
