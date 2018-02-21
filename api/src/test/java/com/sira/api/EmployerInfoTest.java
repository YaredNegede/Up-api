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
import com.sira.model.stateschema.model.Employee;
import com.sira.model.stateschema.model.Employer;
import com.sira.model.stateschema.model.Profile;
import com.sira.model.stateschema.model.Skill;

public class EmployerInfoTest {

	private static Logger logger = Logger.getLogger(EmployeeInfoTest.class);

	private static ApplicationContext appcont = new ClassPathXmlApplicationContext("/applicationContext.xml");

	Gson gson = new Gson();

	static EmployerInfo employerInfo = (EmployerInfo) appcont.getBean("Employer");

	@Before
	public  void setup(){
		employerInfo.getEntitimanager().getTransaction().begin();
	}

	@Test
	public void testAdd() throws APIException {

		Employer employer = new Employer();

		employer.setName("username");

		Account account = new Account();

		account.setNumber("1231");

		account.setType("premium");

		employer.setAccount(account );

		Address address = new Address();

		address.setCity("Addis Ababa");

		employer.setAddress(address );

		Profile profile = new Profile();

		profile.setName("javascript");

		List<Skill> skills = new ArrayList<Skill>();

		Skill skill = new Skill();

		skill.setDescription("very good in javacript");

		skills.add(skill );

		profile.setSkills(skills );

		List<Profile> profiles = new ArrayList<Profile>();
		profiles.add(profile);
		
		employer.setProfile(profiles );


		JsonElement data = gson.toJsonTree(employer);

		logger.info(data);

		employerInfo.Add(data );

		Query query   = (Query) employerInfo.getEntitimanager().createQuery("from Employer as emp where emp.name='username'");
		Employer emp = (Employer) query.getSingleResult();

		Assert.assertTrue(employer.equals(emp));

	}

	@Test
	public void testUpdate() throws APIException {

		Employer employer = new Employer();

		employer.setName("username");

		Account account = new Account();

		account.setNumber("1231");

		account.setType("premium");

		employer.setAccount(account );

		Address address = new Address();

		address.setCity("Addis Ababa");

		employer.setAddress(address );

		Profile profile = new Profile();

		profile.setName("javascript");

		List<Skill> skills = new ArrayList<Skill>();

		Skill skill = new Skill();

		skill.setDescription("very good in javacript");

		skills.add(skill );

		profile.setSkills(skills );
		List<Profile> profiles = new ArrayList<Profile>();
		profiles.add(profile);
		
		employer.setProfile(profiles );


		JsonElement data = gson.toJsonTree(employer);
		
		employerInfo.Add(data );

		employer.setName("Sarkis");

		JsonElement data2 = gson.toJsonTree(employer);
		employerInfo.Update(data2 );

		Query query   = (Query) employerInfo.getEntitimanager().createQuery("from Employer as emp where emp.name='Sarkis'");
		Employer emp = (Employer) query.getSingleResult();

		Assert.assertTrue(employer.equals(emp));

	}

	@Test
	public void testDelete() throws APIException {

		Employer employer = new Employer();

		employer.setName("username");

		Account account = new Account();

		account.setNumber("1230001");

		account.setType("premium");

		employer.setAccount(account );

		Address address = new Address();

		address.setCity("Addis Ababa");

		employer.setAddress(address );

		Profile profile = new Profile();

		profile.setName("javascript");

		List<Skill> skills = new ArrayList<Skill>();

		Skill skill = new Skill();

		skill.setDescription("very good in javacript");

		skills.add(skill );

		profile.setSkills(skills );
		List<Profile> profiles = new ArrayList<Profile>();
		profiles.add(profile);
		
		employer.setProfile(profiles );

		JsonElement data = gson.toJsonTree(employer);

		employerInfo.Add(data );
		
		logger.info(data);

		employerInfo.Delete(data );

		Query query   = (Query) employerInfo.getEntitimanager().createQuery("from Employer as emp where emp.name='"+employer.getName()+"'");

		Assert.assertEquals(query.getResultList().size(),0);


	}

	@Test
	public void testView() throws APIException {

		Employer employer = new Employer();

		employer.setName("yared.negede@sira.com");

		Account account = new Account();

		account.setNumber("1231");

		account.setType("premium");

		employer.setAccount(account );

		Address address = new Address();

		address.setCity("Addis Ababa");

		employer.setAddress(address );

		Profile profile = new Profile();

		profile.setName("javascript");

		List<Skill> skills = new ArrayList<Skill>();

		Skill skill = new Skill();

		skill.setDescription("very good in javacript");

		skills.add(skill );

		profile.setSkills(skills );
		List<Profile> profiles = new ArrayList<Profile>();
		profiles.add(profile);
		
		employer.setProfile(profiles );

		JsonElement data = gson.toJsonTree(employer);

		logger.info(data);

		employerInfo.Add(data );

		JsonElement emp = employerInfo.View(data );

		Employer e = this.gson.fromJson(emp, Employer.class);

		Assert.assertTrue(employer.equals(e));

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

		JsonElement data = gson.toJsonTree(employee);

		logger.info(data);

		employerInfo.Add(data );

		JsonElement emp = employerInfo.ViewAll(data );

		logger.info(emp);

		Assert.assertNotNull(emp);

	}

	boolean exp = false;

	@Test(expected=APIException.class)
	public void testError01() throws APIException {
		exp=true;
		employerInfo.Add(null);
	}

	@Test(expected=APIException.class)
	public void testError02() throws APIException {
		exp=true;
		Employer empr = new  Employer();
		JsonElement data = gson.toJsonTree(empr);
		employerInfo.View(data );
	}

	@Test(expected=APIException.class)
	public void testError03() throws APIException {
		exp=true;
		employerInfo.Update(null);
	}

	@Test(expected=APIException.class)
	public void testError04() throws APIException {
		exp=true;
		employerInfo.Delete(null);
	}

	@Test(expected=APIException.class)
	public void testError05() throws APIException {
		exp=true;
		employerInfo.ViewAll(null );
	}

	@After
	public  void tearDown(){
		if(!exp){
			employerInfo.getEntitimanager().getTransaction().commit();;
		} else {
			employerInfo.getEntitimanager().getTransaction().rollback();
		}
	}
}
