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
import com.sira.model.stateschema.model.Employer;
import com.sira.model.stateschema.model.Profile;
import com.sira.model.stateschema.model.UserBase;


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

		Employer employer = new Employer();

		employer.setName("uplancer");

		employer.setStatus(true);

		employerProfileInfo.getEntitimanager().persist(employer);

		Query querySaved   = (Query) employerProfileInfo.getEntitimanager().createQuery("from Employer as emp where emp.name='"+employer.getName()+"'");

		Employer empSaved = (Employer) querySaved.getSingleResult();

		Assert.assertNotNull(empSaved);

		Assert.assertTrue(empSaved.equals(employer));

		Profile profile = new Profile();

		profile.setName("javascript");

		Query query   = (Query) employerProfileInfo.getEntitimanager().createQuery("from Employer as emp where emp.name='"+employer.getName()+"'");

		Employer emp = (Employer) query.getSingleResult();

		Assert.assertNotNull(emp);

		Assert.assertTrue(emp.getProfile().equals(employer.getProfile()));

		Employer emp2 = new Employer();

		emp2.setHjid(employer.getHjid());

		emp2.setName(employer.getName());

		emp2.getProfile().add(profile);

		employerProfileInfo.Add(emp2);

		Employer emp3 = new Employer();

		emp3.setHjid(employer.getHjid());

		emp3.setName(employer.getName());

		Profile profile2 = new Profile();
		profile2.setName("newname");
		profile2.setDescription("new description");
		emp3.getProfile().add(profile2 );
		
		employerProfileInfo.Update(emp3);
		
		Query query3   = (Query) employerProfileInfo.getEntitimanager().createQuery("from Employer as emp where emp.name='"+employer.getName()+"'");

		Employer empupdate = (Employer) query3.getSingleResult();
		
		Assert.assertNotNull(empupdate);

		Assert.assertTrue(empupdate.getProfile().get(0).equals(profile2));
		
		Employer viewemployee = (Employer) employerProfileInfo.View(emp3);
		
		Assert.assertNotNull(viewemployee);

		Assert.assertTrue(viewemployee.getProfile().get(0).equals(profile2));

		employerProfileInfo.Delete(viewemployee);
		
		Employer empdelete = (Employer) employerProfileInfo.getEntitimanager().createQuery("from Employer as emp where emp.name='"+viewemployee.getName()+"'").getSingleResult();
		
		Assert.assertTrue(empdelete.getProfile().size()==0);

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
		Employer empr = new  Employer();
		employerProfileInfo.View(empr );
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
