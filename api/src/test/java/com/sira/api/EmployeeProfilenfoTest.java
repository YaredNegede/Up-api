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
import com.sira.api.EmployeeProfileInfo;
import com.sira.model.stateschema.model.Account;
import com.sira.model.stateschema.model.Address;
import com.sira.model.stateschema.model.Employee;
import com.sira.model.stateschema.model.Profile;
import com.sira.model.stateschema.model.User;
import com.sira.model.stateschema.model.UserBase;

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

		Profile profile = new Profile();

		profile.setName("javascript");

		List<Profile> profiles = new ArrayList<Profile>();

		profiles.add(profile);

		employee.setProfile(profiles );

		employeeProfileInfo.getEntitimanager().getTransaction().begin();
		employeeProfileInfo.getEntitimanager().persist(employee);
		employeeProfileInfo.getEntitimanager().getTransaction().commit();
		
		logger.info("_____________________"+gson.toJson(employeeProfileInfo.getEntitimanager().createQuery("from Employee").getResultList()));
		
		logger.info("_____________________Setting up the databse completed_____________________");

	}

	@Test
	public void testProfile() throws APIException {

		logger.info("____________Testing employee profile api");

		Query qset = employeeProfileInfo.getEntitimanager().createQuery("from Employee as emp where emp.firstName='"+employee.getFirstName()+"'");

		Employee employeeSetUp  = (Employee) qset.getSingleResult();

		logger.info("____________set up data "+gson.toJson(employeeSetUp));
		
		Profile profile = new Profile();

		profile.setName("new name");

		employee.setHjid(employeeSetUp.getHjid());
		
		Assert.assertFalse(employee.getProfile().size()>1);
		
		employee.getProfile().add(profile);
		
		logger.info("____________ original "+gson.toJson(employee));
		
		employeeProfileInfo.Add(employee);

		Query qss = employeeProfileInfo.getEntitimanager().createQuery("from Employee as emp where emp.firstName='"+employee.getFirstName()+"'");

		Employee employeeupdatedFound  = (Employee) qss.getSingleResult();

		Assert.assertTrue(employeeupdatedFound.getProfile().contains(profile));
		
		logger.info("____________ added Profile "+gson.toJson(employeeupdatedFound));
		
		Employee newProfileEmployee = new Employee();
		newProfileEmployee.setHjid(employee.getHjid());
		Profile newProfile = new Profile();
		newProfile.setName("newProfile");
		newProfileEmployee.getProfile().add(newProfile );
		employeeProfileInfo.Update(newProfileEmployee );
		
		Query qssUpdate = employeeProfileInfo.getEntitimanager().createQuery("from Employee as emp where emp.firstName='"+employee.getFirstName()+"'");

		Employee employeeNewupdatedFound  = (Employee) qssUpdate.getSingleResult();

		Assert.assertTrue(gson.toJson(employeeNewupdatedFound),employeeNewupdatedFound.getProfile().contains(newProfile));

		Employee veiwEmployee = (Employee) employeeProfileInfo.View(employeeNewupdatedFound);
		
		Assert.assertEquals(veiwEmployee.getProfile(), employeeNewupdatedFound.getProfile());
		
		employeeProfileInfo.Delete(veiwEmployee);
		
		Query qssDelete = employeeProfileInfo.getEntitimanager().createQuery("from Employee as emp where emp.firstName='"+employee.getFirstName()+"'");
		
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
		Employee empr = new  Employee();
		employeeProfileInfo.View(empr );
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
