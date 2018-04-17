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
import com.sira.api.error.APIException;
import com.sira.api.request.Context;
import com.sira.model.stateschema.model.Account;
import com.sira.model.stateschema.model.Address;
import com.sira.model.stateschema.model.Employee;
import com.sira.model.stateschema.model.Employer;
import com.sira.model.stateschema.model.Profile;
import com.sira.model.stateschema.model.Skill;
import com.sira.model.stateschema.model.User;

public class EmployeeSkillControllerTest {

	private static Logger logger = Logger.getLogger(EmployeeSkillControllerTest.class);

	private static ApplicationContext appcont = new ClassPathXmlApplicationContext("/applicationContext.xml");

	Gson gson = new Gson();

	static EmployeeSkillInfo employeeSkillInfo = (EmployeeSkillInfo) appcont.getBean("Skill");

	EmployeeSkillController employeeSkillController = new EmployeeSkillController();
	
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
		
		employee.setFirstName("sarkis");
		
		employeeSkillInfo.getEntitimanager().persist(employee);
		
		Query qs = employeeSkillInfo.getEntitimanager().createQuery("from Employee as emplr where emplr.firstName='"+employee.getFirstName()+"'");

		Employee eee = (Employee) qs.getSingleResult();
		
		Assert.assertNotNull(eee);
		
		Assert.assertEquals(employee,eee);
		
		employeeSkillController.setContext(new Context(appcont));

		Employee employee2 = new Employee();
		
		employee2.setHjid(employee.getHjid());
		
		employee2.setFirstName(employee.getFirstName());
		
		List<Skill> skills = new ArrayList<Skill>();

		Skill skill = new Skill();

		skill.setName("javascript");
		
		skill.setDescription("very good in javacript");

		skills.add(skill );

		employee2.setSkills(skills );
		
		employeeSkillController.add(employee2);

		Query q = employeeSkillInfo.getEntitimanager().createQuery("from Employee as emplr where emplr.firstName='"+employee.getFirstName()+"'");

		Employee e = (Employee) q.getSingleResult();

		Assert.assertTrue(gson.toJson(e),e.getSkills().get(0).getName().equals(employee.getSkills().get(0).getName()));
	
		Employee employee3 = new Employee();
		
		employee3.setHjid(e.getHjid());
		
		employee3.setFirstName(employee.getFirstName());
		
		employee3 .getSkills().add(skill);
		
		employeeSkillController.update(employee3);
		
		Query qq = employeeSkillInfo.getEntitimanager().createQuery("from Employee as emplr where emplr.firstName='"+employee.getFirstName()+"'");

		Employee em = (Employee) qq.getSingleResult();
		
		Assert.assertTrue(gson.toJson(em),em.getSkills().get(0).getName().equals(employee.getSkills().get(0).getName()));
		
		JsonElement je = employeeSkillController.view(e);
		
		Employee employeeFound = gson.fromJson(je, Employee.class);
		
		Assert.assertTrue(e.getSkills().get(0).getName().equals(employeeFound.getSkills().get(0).getName()));
		
		employeeSkillController.delete(e);
		
		logger.info("\n____________________________________end___________________________________________________________\n");
		
	}

	@Test(expected=GateException.class)
	public void testError01() throws GateException {
		exp=true;
		employeeSkillController.add(null);
	}

	@Test(expected=GateException.class)
	public void testError02() throws GateException {
		exp=true;
		Employer empr = new  Employer();
		employeeSkillController.view(empr );
	}

	@Test(expected=GateException.class)
	public void testError03() throws GateException {
		exp=true;
		employeeSkillController.update(null);
	}

	@Test(expected=GateException.class)
	public void testError04() throws GateException {
		exp=true;
		employeeSkillController.delete(null);
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
