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
import com.sira.model.stateschema.model.Profile;
import com.sira.model.stateschema.model.User;

import javassist.NotFoundException;

public class EmployeeProfilenfoTest {

	private static Logger logger = Logger.getLogger(EmployeeProfilenfoTest.class);

	private static ApplicationContext appcont = new ClassPathXmlApplicationContext("/applicationContext.xml");

	static Gson gson = new Gson();

	static EmployeeProfileInfo employeeProfileInfo = (EmployeeProfileInfo) appcont.getBean("Profile");

	static EmployeeInfo employeeInfo = (EmployeeInfo) appcont.getBean("Employee");

	static Employee employee = new Employee();

	@BeforeClass
	public static void setup() throws APIException{

		logger.info("_________________________Setting up the database_________________________");

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

		employeeProfileInfo.getEntitimanager().getTransaction().begin();
		employeeProfileInfo.getEntitimanager().persist(employee);
		employeeProfileInfo.getEntitimanager().getTransaction().commit();
		
		logger.info("_____________________"+gson.toJson(employeeProfileInfo.getEntitimanager().createQuery("from Employee").getResultList()));
		
		logger.info("_____________________Setting up the databse completed_____________________");

	}

	@Test
	public void testProfile() throws APIException {

		Profile profile = new Profile();
		profile.setName("firstname");
		profile.setDescription("first description");
		
		employeeProfileInfo.Add(profile );

		Query qss = employeeProfileInfo.getEntitimanager().createQuery("from Profile as emp where emp.name='"+profile.getName()+"'");

		Profile ProfileUpdatedFound  = (Profile) qss.getSingleResult();

		Assert.assertTrue(ProfileUpdatedFound.equals(profile));
		
		logger.info("____________ added Profile "+gson.toJson(ProfileUpdatedFound));
		
		Profile newProfileEmployee = new Profile();

		newProfileEmployee.setDescription("secondProfile");
		employeeProfileInfo.Update(newProfileEmployee );
		
		Query qssUpdate = employeeProfileInfo.getEntitimanager().createQuery("from Profile as emp where emp.name='"+profile.getName()+"'");

		Profile profileNewupdatedFound  = (Profile) qssUpdate.getSingleResult();
		Assert.assertTrue(profileNewupdatedFound.equals(newProfileEmployee));

		Profile veiwProfile = (Profile) employeeProfileInfo.View(profileNewupdatedFound);
		
		Assert.assertEquals(veiwProfile, profileNewupdatedFound);
		
		employeeProfileInfo.Delete(veiwProfile);
		
		Query qssDelete = employeeProfileInfo.getEntitimanager().createQuery("from Profile as emp where emp.name='"+profile.getName()+"'");
		
		try {
			
			qssDelete.getSingleResult();
			
		} catch (Exception e) {
			
			Assert.assertTrue(e instanceof NotFoundException);
		
		}
		
	}

	static boolean exp = false;

	@Test(expected=APIException.class)
	public void testError01() throws APIException {
		exp=true;
		employeeProfileInfo.Add(null);
	}

	@Test(expected=APIException.class)
	public void testError02() throws APIException {
		exp=true;
		employeeProfileInfo.View(null);
	}

	@Test(expected=APIException.class)
	public void testError03() throws APIException {
		exp=true;
		employeeProfileInfo.Update(null);
	}

	@Test(expected=APIException.class)
	public void testError04() throws APIException {
		exp=true;
		employeeProfileInfo.Delete(null);
	}


}
