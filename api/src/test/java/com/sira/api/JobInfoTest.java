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
import com.sira.model.stateschema.model.Employer;
import com.sira.model.stateschema.model.JobDetail;
import com.sira.model.stateschema.model.ProjectDetail;

public class JobInfoTest {

	private static Logger logger = Logger.getLogger(JobInfoTest.class);

	private static ApplicationContext appcont = new ClassPathXmlApplicationContext("/applicationContext.xml");

	Gson gson = new Gson();

	static WorkInfo jobInfo = (WorkInfo) appcont.getBean("Job");

	static WorkInfo projectInfo = (WorkInfo) appcont.getBean("Project");

	@Before
	public  void setup(){
		jobInfo.getEntitimanager().getTransaction().begin();
		if(!projectInfo.getEntitimanager().getTransaction().isActive())		{
			projectInfo.getEntitimanager().getTransaction().begin();
		}
	}

	@Test
	public void test001() throws APIException {

		logger.info("***********************************"+this.getClass().getSimpleName()+"***********************************");

		JobDetail jobDetail = new JobDetail();
		jobDetail.setDescription("description");
		jobDetail.setName("name");

		jobInfo.Add(jobDetail);

		Query query   = (Query) jobInfo.getEntitimanager().createQuery("from JobDetail as jd where jd.name='"+jobDetail.getName()+"'");

		JobDetail jobDetail2 = (JobDetail) query.getSingleResult();

		Assert.assertTrue(jobDetail2.equals(jobDetail));

		jobDetail.setDescription("newName");
		jobInfo.Update(jobDetail);

		Query query3   = (Query) jobInfo.getEntitimanager().createQuery("from JobDetail as jd where jd.name='"+jobDetail.getName()+"'");

		JobDetail jobDetail3 = (JobDetail) query3.getSingleResult();

		Assert.assertTrue(jobDetail3.equals(jobDetail));

		JobDetail detailFound = (JobDetail) jobInfo.View(jobDetail);

		Assert.assertTrue(jobDetail3.equals(detailFound));

	}

	@Test
	public void test002() throws APIException {

		logger.info("***********************************"+this.getClass().getSimpleName()+"***********************************");

		ProjectDetail projectDetail = new ProjectDetail();
		projectDetail.setDescription("description");
		projectDetail.setName("name");

		projectInfo.Add(projectDetail);

		Query query   = (Query) projectInfo.getEntitimanager().createQuery("from ProjectDetail as jd where jd.name='"+projectDetail.getName()+"'");

		ProjectDetail projectDetail2 = (ProjectDetail) query.getSingleResult();

		Assert.assertTrue(projectDetail2.equals(projectDetail));

		projectDetail.setDescription("newName");
		projectInfo.Update(projectDetail);

		Query query3   = (Query) projectInfo.getEntitimanager().createQuery("from ProjectDetail as jd where jd.name='"+projectDetail.getName()+"'");

		ProjectDetail projectDetail3 = (ProjectDetail) query3.getSingleResult();

		Assert.assertTrue(projectDetail3.equals(projectDetail));

		ProjectDetail detailFound = (ProjectDetail) projectInfo.View(projectDetail);

		Assert.assertTrue(projectDetail3.equals(detailFound));

	}

	boolean exp = false;

	@Test(expected=APIException.class)
	public void testError01() throws APIException {
		exp=true;
		projectInfo.Add(null);
	}
	
	@Test(expected=APIException.class)
	public void testError011() throws APIException {
		exp=true;
		jobInfo.Add(null);
	}

	@Test(expected=APIException.class)
	public void testError02() throws APIException {
		exp=true;
		jobInfo.View(null);
	}
	@Test(expected=APIException.class)
	public void testError021() throws APIException {
		exp=true;
		projectInfo.View(null);
	}

	@Test(expected=APIException.class)
	public void testError03() throws APIException {
		exp=true;
		jobInfo.Update(null);
	}

	@Test(expected=APIException.class)
	public void testError031() throws APIException {
		exp=true;
		projectInfo.Update(null);
	}
	
	@Test(expected=APIException.class)
	public void testError04() throws APIException {
		exp=true;
		projectInfo.Delete(null);
	}
	
	@Test(expected=APIException.class)
	public void testError041() throws APIException {
		exp=true;
		jobInfo.Delete(null);
	}


	@After
	public  void tearDown(){
		if(!exp){
			jobInfo.getEntitimanager().getTransaction().commit();
			projectInfo.getEntitimanager().getTransaction().commit();
		} else {
			jobInfo.getEntitimanager().getTransaction().rollback();
			projectInfo.getEntitimanager().getTransaction().rollback();
		}
	}
}
