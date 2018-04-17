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
import com.sira.model.stateschema.model.Profile;


public class EmployerProfileInfoTest {

	private static Logger logger = Logger.getLogger(EmployerProfileInfoTest.class);

	private static ApplicationContext appcont = new ClassPathXmlApplicationContext("/applicationContext.xml");

	Gson gson = new Gson();

	static EmployerInfo employerInfo = (EmployerInfo) appcont.getBean("Employer");

	static EmployerProfileInfo employerProfileInfo = (EmployerProfileInfo) appcont.getBean("EmployerProfile");

	@Before
	public  void setup(){
		employerProfileInfo.getEntitimanager().getTransaction().begin();
	}


	@Test
	public void test() throws APIException {

		logger.info("****************************"+this.getClass().getName()+"*********************************");

		Profile profile = new Profile();

		profile.setName("javascript");
		
		employerProfileInfo.Add(profile);
		
		Query query   = (Query) employerProfileInfo.getEntitimanager().createQuery("from Profile as emp where emp.name='"+profile.getName()+"'");

		Profile profile2 = (Profile) query.getSingleResult();

		Assert.assertNotNull(profile2);

		Assert.assertTrue(profile.equals(profile2));


		profile2.setDescription("new description");
		
		employerProfileInfo.Update(profile2);
		
		Query query3   = (Query) employerProfileInfo.getEntitimanager().createQuery("from Profile as emp where emp.name='"+profile.getName()+"'");

		Profile profile3 = (Profile) query3.getSingleResult();
		
		Assert.assertNotNull(profile3);

		Assert.assertTrue(profile3.equals(profile2));
		
		Profile profile4 = (Profile) employerProfileInfo.View(profile3);
		
		Assert.assertNotNull(profile4);

		Assert.assertTrue(profile4.equals(profile2));

		employerProfileInfo.Delete(profile4);
		
		Profile profile5 = (Profile) employerProfileInfo.getEntitimanager().createQuery("from Profile as emp where emp.name='"+profile.getName()+"'").getSingleResult();
		
		Assert.assertNull(profile5);

	}
	boolean exp = false;

	@Test(expected=APIException.class)
	public void testError01() throws APIException {
		exp=true;
		employerProfileInfo.Add(null);
	}

	@Test(expected=APIException.class)
	public void testError02() throws APIException {
		exp=true;
		employerProfileInfo.View(null);
	}

	@Test(expected=APIException.class)
	public void testError03() throws APIException {
		exp=true;
		employerProfileInfo.Update(null);
	}

	@Test(expected=APIException.class)
	public void testError04() throws APIException {
		exp=true;
		employerProfileInfo.Delete(null);
	}

	@After
	public  void tearDown(){
		if(!exp){
			employerProfileInfo.getEntitimanager().getTransaction().commit();;
		} else {
			employerProfileInfo.getEntitimanager().getTransaction().rollback();
		}
	}
}
