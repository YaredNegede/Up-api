package com.server.controller;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.server.error.GateException;
import com.sira.api.EmployerProfileInfo;
import com.sira.api.request.Context;
import com.sira.model.stateschema.model.Employee;
import com.sira.model.stateschema.model.Profile;

public class EmployeeProfileControllerTest {

	private static Logger logger = Logger.getLogger(EmployeeProfileControllerTest.class);

	private static ApplicationContext appcont = new ClassPathXmlApplicationContext("/applicationContext.xml");

	Gson gson = new Gson();

	static EmployerProfileInfo employerProfileInfo = (EmployerProfileInfo) appcont.getBean("EmployerProfile");
	
	EmployeeProfileController profileController = new EmployeeProfileController();
	
	@Before
	public  void setup(){
		
		logger.info("********************"+this.getClass().getName()+"********************");
		
		if(!employerProfileInfo.getEntitimanager().getTransaction().isActive()){
			employerProfileInfo.getEntitimanager().getTransaction().begin();
		}
		
		Employee employee = new Employee();

		employee.setFirstName("uplancer");

		employee.setStatus(true);
		
		employerProfileInfo.getEntitimanager().persist(employee);
		
		Context context = new Context(appcont);
		
		profileController.setContext(context );
		
	}
	
	@Test
	public void testAdd() throws GateException {
		
		Employee employee2 = (Employee) employerProfileInfo.getEntitimanager().createQuery("from Employee").getSingleResult();
	
		logger.info("\n\n"+gson.toJson(employee2)+"\n\n");
		
		Assert.assertTrue(employerProfileInfo.getEntitimanager().getTransaction().isActive());
		
		Assert.assertNotNull(employee2);
		
		Assert.assertTrue(employee2.getHjid()>0);
		
		Profile profile = new Profile();

		profile.setName("javascript");
		
		Employee employee3 = new Employee();
		employee3.setHjid(employee2.getHjid());
		employee3.setFirstName(employee2.getFirstName());
		employee3 .getProfile().add(profile);
		
		profileController.add(employee3);
		
		Employee employeefound = (Employee) employerProfileInfo.getEntitimanager().createQuery("from Employee").getSingleResult();
		
		Assert.assertTrue(employee3.getProfile().equals(employeefound.getProfile()));
		
	}

	@Test
	public void testView() throws GateException {
		
		Employee employee2 = (Employee) employerProfileInfo.getEntitimanager().createQuery("from Employee").getSingleResult();
		
		Assert.assertTrue(employee2.getHjid()>0);
		
		Assert.assertTrue(employerProfileInfo.getEntitimanager().getTransaction().isActive());
		
		JsonElement employeeJsonView = profileController.view(employee2);
		
		Employee employeeFound = gson.fromJson(employeeJsonView, Employee.class);

		Assert.assertTrue(employeeFound.getProfile().size()>0);
		
	}

	@Test
	public void testUpdate() {
		
	}

	@Test
	public void testDelete() {
		
	}

}
