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
import com.sira.model.stateschema.model.Project;
import com.sira.model.stateschema.model.Skill;

public class ProjectInfoTest {

	private static Logger logger = Logger.getLogger(ProjectInfoTest.class);

	private static ApplicationContext appcont = new ClassPathXmlApplicationContext("/applicationContext.xml");

	Gson gson = new Gson();

	static ProjectInfo projectInfo = (ProjectInfo) appcont.getBean("Project");

	@Before
	public  void setup(){
		projectInfo.getEntitimanager().getTransaction().begin();
	}

	@Test
	public void testAdd() throws APIException {

		Project project = new Project();

		project.setId("projectId");
		
		project.setName("siras");

		JsonElement data = gson.toJsonTree(project);

		logger.info(data);

		projectInfo.Add(data );

		Query query   = (Query) projectInfo.getEntitimanager().createQuery("from Project as p where p.name='siras'");
	
		Project emp = (Project) query.getSingleResult();

		Assert.assertTrue(project.equals(emp));

	}

	@Test
	public void testUpdate() throws APIException {

		Project project = new Project();

		project.setId("projectId");
		project.setName("siras");

		JsonElement data = gson.toJsonTree(project);
		
		projectInfo.Add(data );

		project.setName("Sarkis");

		JsonElement data2 = gson.toJsonTree(project);
		
		projectInfo.Update(data2 );

		Query query   = (Query) projectInfo.getEntitimanager().createQuery("from Project as p where p.name='Sarkis'");
		Project emp = (Project) query.getSingleResult();

		Assert.assertTrue(project.equals(emp));

	}

	@Test
	public void testDelete() throws APIException {

		Project project = new Project();

		project.setId("projectId");
		project.setName("siras");

		JsonElement data = gson.toJsonTree(project);
		
		projectInfo.Add(data );

		project.setName("Sarkis");

		projectInfo.Delete(data );

		Query query   = (Query) projectInfo.getEntitimanager().createQuery("from Project as p where p.name='siras'");

		Assert.assertEquals(query.getResultList().size(),0);


	}

	@Test
	public void testView() throws APIException {

		Project project = new Project();

		project.setName("username");
		project.setId("projectId");
		project.setName("siras");

		JsonElement data = gson.toJsonTree(project);
		
		projectInfo.Add(data );

		projectInfo.Add(data );

		JsonElement emp = projectInfo.View(data );

		Project e = this.gson.fromJson(emp, Project.class);

		Assert.assertTrue(project.equals(e));

	}

	@Test
	public void testViewAll() throws APIException {
		Project project = new Project();

		project.setName("username");

		project.setId("projectId");
		
		project.setName("siras");

		JsonElement data = gson.toJsonTree(project);
		
		projectInfo.Add(data );

		JsonElement emp = projectInfo.ViewAll(data );

		logger.info(emp);

		Assert.assertNotNull(emp);

	}

	boolean exp = false;

	@Test(expected=APIException.class)
	public void testError01() throws APIException {
		exp=true;
		projectInfo.Add(null);
	}

	@Test(expected=APIException.class)
	public void testError02() throws APIException {
		exp=true;
		Employer empr = new  Employer();
		JsonElement data = gson.toJsonTree(empr);
		projectInfo.View(data );
	}

	@Test(expected=APIException.class)
	public void testError03() throws APIException {
		exp=true;
		projectInfo.Update(null);
	}

	@Test(expected=APIException.class)
	public void testError04() throws APIException {
		exp=true;
		projectInfo.Delete(null);
	}

	@Test(expected=APIException.class)
	public void testError05() throws APIException {
		exp=true;
		projectInfo.ViewAll(null );
	}

	@After
	public  void tearDown(){
		if(!exp){
			projectInfo.getEntitimanager().getTransaction().commit();;
		} else {
			projectInfo.getEntitimanager().getTransaction().rollback();
		}
	}
}
