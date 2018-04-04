package com.server.controller.employee;

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
import com.server.controller.EmployeeSkillController;
import com.server.error.GateException;
import com.sira.api.EmployeeSkillInfo;
import com.sira.api.request.Context;
import com.sira.model.stateschema.model.Account;
import com.sira.model.stateschema.model.Address;
import com.sira.model.stateschema.model.Employee;
import com.sira.model.stateschema.model.Profile;
import com.sira.model.stateschema.model.Skill;
import com.sira.model.stateschema.model.User;

public class EmployeeSkillControllerTest {

	private static Logger logger = Logger.getLogger(EmployeeSkillControllerTest.class);

	private static ApplicationContext appcont = new ClassPathXmlApplicationContext("/applicationContext.xml");

	Gson gson = new Gson();

	static EmployeeSkillInfo employeeSkillInfo = (EmployeeSkillInfo) appcont.getBean("Skill");

	@Before
	public  void setup(){
		if(!employeeSkillInfo.getEntitimanager().getTransaction().isActive()){
			employeeSkillInfo.getEntitimanager().getTransaction().begin();
		}
	}

	@Test
	public void testSkill() throws GateException {

		logger.info("****************************************skill test****************************************1");
		
		Employee employee = new Employee();

		employee.setStatus(true);
		
		User user = new User();
		user.setStatus(true);
		employee.setUser(user );
		
		employee.setFirstName("sarkis");

		employee.setMiddleName("dejene");

		employee.setLastName("grana");
		
		Account account = new Account();

		account.setNumber("123167");

		account.setType("premium");

		employee.setAccount(account );

		Address address = new Address();

		address.setCity("Addis Ababa");

		employee.setAddress(address );

		Profile profile = new Profile();

		profile.setName("javascript");

		List<Skill> skills = new ArrayList<Skill>();

		Skill skill = new Skill();

		skill.setName("javascript");
		
		skill.setDescription("very good in javacript");

		skills.add(skill );

		employee.setSkills(skills );
		
		employeeSkillInfo.getEntitimanager().persist(employee);
		
		Query qs = employeeSkillInfo.getEntitimanager().createQuery("from Employee as emplr where emplr.firstName='"+employee.getFirstName()+"'");

		Employee eee = (Employee) qs.getSingleResult();
		
		Assert.assertNotNull(eee);
		
		Assert.assertEquals(employee,eee);
		
		EmployeeSkillController employeeSkillController = new EmployeeSkillController();

		employeeSkillController.setContext(new Context(appcont));

		employeeSkillController.add(eee);

		Query q = employeeSkillInfo.getEntitimanager().createQuery("from Employee as emplr where emplr.firstName='"+employee.getFirstName()+"'");

		Employee e = (Employee) q.getSingleResult();

		logger.info("\n_______________________________________________________________________________________________");
		
		Assert.assertTrue(gson.toJson(e),e.getSkills().get(0).getName().equals(employee.getSkills().get(0).getName()));
	
		employee.getSkills().get(0).setName("newName");
		
		employeeSkillController.update(employee);
		
		q = employeeSkillInfo.getEntitimanager().createQuery("from Employee as emplr where emplr.firstName='"+employee.getFirstName()+"'");

		Employee em = (Employee) q.getSingleResult();
		
		Assert.assertTrue(gson.toJson(em),em.getSkills().get(0).getName().equals(employee.getSkills().get(0).getName()));
		
		JsonElement je = employeeSkillController.view(e);
		
		Employee employeeFound = gson.fromJson(je, Employee.class);
		
		Assert.assertTrue(e.getSkills().get(0).getName().equals(employeeFound.getSkills().get(0).getName()));
		
		employeeSkillController.delete(e);
		
		logger.info("\\n_______________________________________________________________________________________________");
		
	}

	boolean exp = false;
	
	@After
	public  void tearDown(){
		if(!exp){
			employeeSkillInfo.getEntitimanager().getTransaction().commit();;
		} else {
			employeeSkillInfo.getEntitimanager().getTransaction().rollback();
		}
	}

}
