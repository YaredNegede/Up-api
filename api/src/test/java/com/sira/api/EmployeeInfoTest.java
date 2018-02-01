package com.sira.api;

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
import com.sira.api.error.APIException;
import com.sira.model.stateschema.model.Account;
import com.sira.model.stateschema.model.Address;
import com.sira.model.stateschema.model.Country;
import com.sira.model.stateschema.model.Employee;
import com.sira.model.stateschema.model.Employer;
import com.sira.model.stateschema.model.Profile;
import com.sira.model.stateschema.model.Skill;

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

		Employee employee = new Employee();

		employee.setUsername("username");

		employee.setPassword("password");

		employee.setFirstName("Yared");

		employee.setMiddleName("Negede");

		employee.setLastName("Yeshitla");

		Account account = new Account();

		account.setNumber("1231");

		account.setType("premium");

		employee.setAccount(account );

		Address address = new Address();

		address.setCity("Addis Ababa");

		Country country = new Country();

		country.setCode("123");

		country.setName("Ethiopia");

		address.setCountry(country );

		employee.setAddress(address );

		Profile profile = new Profile();

		profile.setName("javascript");

		List<Skill> skills = new ArrayList<Skill>();

		Skill skill = new Skill();

		skill.setDescription("very good in javacript");

		skills.add(skill );

		profile.setSkills(skills );

		employee.setProfile(profile );


		JsonElement data = gson.toJsonTree(employee);

		logger.info(data);

		employeeInfo.Add(data );

		Query query   = (Query) employeeInfo.getEntitimanager().createQuery("from Employee as emp where emp.username='username'");
		Employee emp = (Employee) query.getSingleResult();

		Assert.assertTrue(employee.equals(emp));

	}

	@Test
	public void testUpdate() throws APIException {

		Employee employee = new Employee();

		employee.setUsername("username");

		employee.setPassword("password");

		employee.setFirstName("Yared");

		employee.setMiddleName("Negede");

		employee.setLastName("Yeshitla");

		Account account = new Account();

		account.setNumber("1231");

		account.setType("premium");

		employee.setAccount(account );

		Address address = new Address();

		address.setCity("Addis Ababa");

		Country country = new Country();

		country.setCode("123");

		country.setName("Ethiopia");

		address.setCountry(country );

		employee.setAddress(address );

		Profile profile = new Profile();

		profile.setName("javascript");

		List<Skill> skills = new ArrayList<Skill>();

		Skill skill = new Skill();

		skill.setDescription("very good in javacript");

		skills.add(skill );

		profile.setSkills(skills );

		employee.setProfile(profile );


		JsonElement data = gson.toJsonTree(employee);
		employeeInfo.Add(data );

		employee.setFirstName("Sarkis");

		JsonElement data2 = gson.toJsonTree(employee);
		employeeInfo.Update(data2 );

		Query query   = (Query) employeeInfo.getEntitimanager().createQuery("from Employee as emp where emp.firstName='Sarkis'");
		Employee emp = (Employee) query.getSingleResult();

		Assert.assertTrue(employee.equals(emp));

	}

	@Test
	public void testDelete() throws APIException {

		Employee employee = new Employee();

		employee.setUsername("yared.negede");

		employee.setPassword("password");

		employee.setFirstName("Yared");

		employee.setMiddleName("Negede");

		employee.setLastName("Yeshitla");

		Account account = new Account();

		account.setNumber("1231");

		account.setType("premium");

		employee.setAccount(account );

		Address address = new Address();

		address.setCity("Addis Ababa");

		Country country = new Country();

		country.setCode("123");

		country.setName("Ethiopia");

		address.setCountry(country );

		employee.setAddress(address );

		Profile profile = new Profile();

		profile.setName("javascript");

		List<Skill> skills = new ArrayList<Skill>();

		Skill skill = new Skill();

		skill.setDescription("very good in javacript");

		skills.add(skill );

		profile.setSkills(skills );

		employee.setProfile(profile );

		JsonElement data = gson.toJsonTree(employee);

		logger.info(data);

		employeeInfo.Delete(data );

		Query query   = (Query) employeeInfo.getEntitimanager().createQuery("from Employee as emp where emp.username='"+employee.getUsername()+"'");

		Assert.assertEquals(query.getResultList().size(),0);


	}

	@Test
	public void testView() throws APIException {

		Employee employee = new Employee();

		employee.setUsername("yared.negede@sira.com");

		employee.setPassword("password");

		employee.setFirstName("Yared");

		employee.setMiddleName("Negede");

		employee.setLastName("Yeshitla");

		Account account = new Account();

		account.setNumber("1231");

		account.setType("premium");

		employee.setAccount(account );

		Address address = new Address();

		address.setCity("Addis Ababa");

		Country country = new Country();

		country.setCode("123");

		country.setName("Ethiopia");

		address.setCountry(country );

		employee.setAddress(address );

		Profile profile = new Profile();

		profile.setName("javascript");

		List<Skill> skills = new ArrayList<Skill>();

		Skill skill = new Skill();

		skill.setDescription("very good in javacript");

		skills.add(skill );

		profile.setSkills(skills );

		employee.setProfile(profile );

		JsonElement data = gson.toJsonTree(employee);

		logger.info(data);

		employeeInfo.Add(data );

		JsonElement emp = employeeInfo.View(data );

		Employee e = this.gson.fromJson(emp, Employee.class);

		Assert.assertTrue(employee.equals(e));

	}

	@Test
	public void testViewAll() throws APIException {
		Employee employee = new Employee();

		employee.setUsername("username");

		employee.setPassword("password");

		employee.setFirstName("Yared");

		employee.setMiddleName("Negede");

		employee.setLastName("Yeshitla");

		Account account = new Account();

		account.setNumber("1231");

		account.setType("premium");

		employee.setAccount(account );

		Address address = new Address();

		address.setCity("Addis Ababa");

		Country country = new Country();

		country.setCode("123");

		country.setName("Ethiopia");

		address.setCountry(country );

		employee.setAddress(address );

		Profile profile = new Profile();

		profile.setName("javascript");

		List<Skill> skills = new ArrayList<Skill>();

		Skill skill = new Skill();

		skill.setDescription("very good in javacript");

		skills.add(skill );

		profile.setSkills(skills );

		employee.setProfile(profile );

		JsonElement data = gson.toJsonTree(employee);

		logger.info(data);

		employeeInfo.Add(data );

		JsonElement emp = employeeInfo.ViewAll(data );

		logger.info(emp);

		Assert.assertNotNull(emp);

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
		JsonElement data = gson.toJsonTree(empr);
		employeeInfo.View(data );
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

	@Test(expected=APIException.class)
	public void testError05() throws APIException {
		exp=true;
		employeeInfo.ViewAll(null );
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
