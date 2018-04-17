package com.sira.api;

import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.google.gson.Gson;
import com.sira.api.error.APIException;
import com.sira.model.stateschema.model.Account;
import com.sira.model.stateschema.model.Address;
import com.sira.model.stateschema.model.Employee;
import com.sira.model.stateschema.model.Skill;
import com.sira.model.stateschema.model.User;

public class EmployeeSkillInfoTest {

	private static Logger logger = Logger.getLogger(EmployeeSkillInfoTest.class);

	private static ApplicationContext appcont = new ClassPathXmlApplicationContext("/applicationContext.xml");

	static Gson gson = new Gson();

	static EmployeeSkillInfo employeeSkillInfo = (EmployeeSkillInfo) appcont.getBean("Skill");

	static EmployeeInfo employeeInfo = (EmployeeInfo) appcont.getBean("Employee");

	static Employee employee = new Employee();

	@BeforeClass
	public static void setup() throws APIException{

		logger.info("_________________________Setting up the databse_________________________");

		employee.setStatus(true);

		employee.setFirstName("Yared");

		employee.setMiddleName("Negede");

		employee.setLastName("Yeshitla");

		User user = new User();
		
		user.setUsername("yared");
		
		user.setEmail("yared@uplancer.io");
		
		employee.setUser(user);
		
		Account account = new Account();

		account.setNumber("1231");

		account.setType("premium");

		employee.setAccount(account );

		Address address = new Address();

		address.setCity("Addis Ababa");

		employee.setAddress(address );

		employeeSkillInfo.getEntitimanager().getTransaction().begin();
		employeeSkillInfo.getEntitimanager().persist(employee);
		employeeSkillInfo.getEntitimanager().getTransaction().commit();
		logger.info("_____________________"+gson.toJson(employeeSkillInfo.getEntitimanager().createQuery("from Employee").getResultList()));
		logger.info("_____________________Setting up the databse completed_____________________");

	}

	@Test
	public void testSkill() throws APIException {

		logger.info("____________Testing employee skill api");

		Skill firstSkill = new Skill();

		firstSkill.setName("new name");

		firstSkill.setDescription("very good in javacript");

		employeeSkillInfo.Add(firstSkill);

		Query qss = employeeSkillInfo.getEntitimanager().createQuery("from Skill as emp where emp.name='"+firstSkill.getName()+"'");

		Skill skillupdatedFound  = (Skill) qss.getSingleResult();

		Assert.assertTrue(skillupdatedFound.equals(firstSkill));
		
		logger.info("____________ added skill "+gson.toJson(skillupdatedFound));
		
		
		Skill thirdSkill = new Skill();
		
		skillupdatedFound.setDescription("thirdSkill desc");
		
		
		employeeSkillInfo.Update(skillupdatedFound );

		Query qss2 = employeeSkillInfo.getEntitimanager().createQuery("from Skill as emp where emp.name='"+firstSkill.getName()+"'");

		Skill sKill2  = (Skill) qss2.getSingleResult();

		logger.info("updated skill "+gson.toJson(sKill2));

		Assert.assertTrue(sKill2.equals(thirdSkill ));
		
		Skill skillthird = (Skill) employeeSkillInfo.View(sKill2 );
		
		Assert.assertTrue(skillthird.equals(sKill2));
		
		employeeSkillInfo.Delete(skillthird );

		try {
			
			employeeSkillInfo.getEntitimanager().createQuery("from Skill as emp where emp.name='"+firstSkill.getName()+"'");
			
		} catch (Exception e) {
			
			Assert.assertTrue(e instanceof APIException);
		
		}
	}

	@Test
	public void testUpdateSkill() throws APIException {
		
	}
	
	static boolean exp = false;

	@Test(expected=APIException.class)
	public void testError01() throws APIException {
		exp=true;
		employeeSkillInfo.Add(null);
	}

	@Test(expected=APIException.class)
	public void testError02() throws APIException {
		exp=true;
		employeeSkillInfo.View(null);
	}

	@Test(expected=APIException.class)
	public void testError03() throws APIException {
		exp=true;
		employeeSkillInfo.Update(null);
	}

	@Test(expected=APIException.class)
	public void testError04() throws APIException {
		exp=true;
		employeeSkillInfo.Delete(null);
	}


}
