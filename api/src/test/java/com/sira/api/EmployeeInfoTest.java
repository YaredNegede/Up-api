package com.sira.api;

import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.google.gson.Gson;
import com.sira.api.error.APIException;
import com.sira.model.stateschema.model.Account;
import com.sira.model.stateschema.model.Address;
import com.sira.model.stateschema.model.Employee;
import com.sira.model.stateschema.model.Employer;
import com.sira.model.stateschema.model.Profile;

public class EmployeeInfoTest {

	private static Logger logger = Logger.getLogger(EmployeeInfoTest.class);

	private static ApplicationContext appcont = new ClassPathXmlApplicationContext("/applicationContext.xml");

	Gson gson = new Gson();

	static EmployeeInfo employeeInfo = (EmployeeInfo) appcont.getBean("Employee");

	@Before
	public  void setup(){
		employeeInfo.getEntitimanager().getTransaction().begin();
	}

	@Test
	public void testAdd() throws APIException {

		logger.info("adding users");
		
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

		employeeInfo.Add(employee);

		Query query   = (Query) employeeInfo.getEntitimanager().createQuery("from Employee as emp where emp.firstName='Yared'");
		Employee emp = (Employee) query.getSingleResult();

		Assert.assertTrue(employee.equals(emp));

	}

	@Test
	public void testUpdate() throws APIException {

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

		employeeInfo.Add(employee);

		employee.setFirstName("Sarkis");

		employeeInfo.Update(employee);

		Query query   = (Query) employeeInfo.getEntitimanager().createQuery("from Employee as emp where emp.firstName='Sarkis'");
		
		Employee emp = (Employee) query.getSingleResult();

		Assert.assertTrue(employee.equals(emp));

	}

	@Test
	public void testDelete() throws APIException {

		Employee employee = new Employee();

		employee.setFirstName("Yared2");

		employee.setMiddleName("Negede2");

		employee.setLastName("Yeshitla2");

		Account account = new Account();

		account.setNumber("12312");

		account.setType("premium2");

		employee.setAccount(account );

		Address address = new Address();

		address.setCity("Addis Ababa2");

		employee.setAddress(address );

		employeeInfo.Delete(employee);

		Query query   = (Query) employeeInfo.getEntitimanager().createQuery("from Employee as emp where emp.firstName='"
		+employee.getFirstName()+"'");

		Assert.assertEquals(query.getResultList().size(),0);


	}

	@Test
	public void testView() throws APIException {

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

		employeeInfo.Add(employee);

		Employee emp = (Employee) employeeInfo.View(employee);

		Assert.assertTrue(employee.equals(emp));

	}

	boolean exp = false;

	@Test(expected=APIException.class)
	public void testError01() throws APIException {
		exp=true;
		employeeInfo.Add(null);
	}

	@Test(expected=APIException.class)
	public void testError02() throws APIException {
		exp=true;
		Employer empr = new  Employer();
		employeeInfo.View(empr );
	}

	@Test(expected=APIException.class)
	public void testError03() throws APIException {
		exp=true;
		employeeInfo.Update(null);
	}

	@Test(expected=APIException.class)
	public void testError04() throws APIException {
		exp=true;
		employeeInfo.Delete(null);
	}

	@After
	public  void tearDown(){
		if(!exp){
			employeeInfo.getEntitimanager().getTransaction().commit();;
		} else {
			employeeInfo.getEntitimanager().getTransaction().rollback();
		}
	}
}
