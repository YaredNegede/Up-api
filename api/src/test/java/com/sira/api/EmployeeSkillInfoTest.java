package com.sira.api;

import java.util.ArrayList;
import java.util.List;

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
import com.sira.model.stateschema.model.Profile;
import com.sira.model.stateschema.model.Skill;
import com.sira.model.stateschema.model.User;
import com.sira.model.stateschema.model.UserBase;

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

		Profile profile = new Profile();

		profile.setName("javascript");

		List<Profile> profiles = new ArrayList<Profile>();

		profiles.add(profile);

		employee.setProfile(profiles );

		employeeSkillInfo.getEntitimanager().getTransaction().begin();
		employeeSkillInfo.getEntitimanager().persist(employee);
		employeeSkillInfo.getEntitimanager().getTransaction().commit();
		logger.info("_____________________"+gson.toJson(employeeSkillInfo.getEntitimanager().createQuery("from Employee").getResultList()));
		logger.info("_____________________Setting up the databse completed_____________________");

	}

	@Test
	public void testSkill() throws APIException {

		logger.info("____________Testing employee skill api");

		Query qset = employeeSkillInfo.getEntitimanager().createQuery("from Employee as emp where emp.firstName='"+employee.getFirstName()+"'");

		Employee employeeSetUp  = (Employee) qset.getSingleResult();

		logger.info("____________set up data "+gson.toJson(employeeSetUp));
		
		Skill firstSkill = new Skill();

		firstSkill.setName("new name");

		firstSkill.setDescription("very good in javacript");

		employee.setHjid(employeeSetUp.getHjid());
		
		Assert.assertFalse(employee.getSkills().size()>1);
		
		Assert.assertFalse(employee.getSkills().contains(firstSkill));
		
		employee.getSkills().add(firstSkill);
		
		logger.info("____________ original "+gson.toJson(employee));
		
		employeeSkillInfo.Add(employee);

		Query qss = employeeSkillInfo.getEntitimanager().createQuery("from Employee as emp where emp.firstName='"+employee.getFirstName()+"'");

		Employee employeeupdatedFound  = (Employee) qss.getSingleResult();

		Assert.assertTrue(employeeupdatedFound.getSkills().contains(firstSkill));
		
		logger.info("____________ added skill "+gson.toJson(employeeupdatedFound));
		
		
		Skill thirdSkill = new Skill();
		
		thirdSkill.setName("thirdSkill");
		
		Employee employeeUpdate = new Employee();
		employeeUpdate.setHjid(employee.getHjid());
		employeeUpdate.getSkills().add(thirdSkill);
		
		employeeSkillInfo.Update(employeeUpdate );

		Query qss2 = employeeSkillInfo.getEntitimanager().createQuery("from Employee as emp where emp.firstName='"+employee.getFirstName()+"'");

		Employee employeeSKill2  = (Employee) qss2.getSingleResult();

		logger.info("updated skill "+gson.toJson(employeeSKill2));

		Assert.assertTrue(employeeSKill2.getSkills().contains(thirdSkill ));
		
		Employee employeethird = (Employee) employeeSkillInfo.View(employeeUpdate );
		
		Assert.assertTrue(employeethird.getSkills().equals(employeeSKill2.getSkills()));
		
		employeeSkillInfo.Delete(employeeUpdate );

		try {
			
			employeeSkillInfo.getEntitimanager().createQuery("from Employee as emp where emp.firstName='"+employee.getFirstName()+"'");
			
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
		Employee empr = new  Employee();
		employeeSkillInfo.View(empr );
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
