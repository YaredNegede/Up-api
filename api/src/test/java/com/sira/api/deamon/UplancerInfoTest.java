package com.sira.api.deamon;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.google.gson.Gson;
import com.sira.api.error.APIException;
import com.sira.model.stateschema.model.Uplancer;


public class UplancerInfoTest {

	private static Logger logger = Logger.getLogger(UplancerInfoTest.class);

	private static ApplicationContext appcont = new ClassPathXmlApplicationContext("/applicationContext.xml");

	Gson gson = new Gson();

	static UplancerInfo  uplancerInfo = (UplancerInfo) appcont.getBean("Uplancer");

	@Before
	public  void setup(){
		if(!uplancerInfo .getEntityManager().getTransaction().isActive())
		uplancerInfo .getEntityManager().getTransaction().begin();
	}
	
	@Test
	public void testUplancerInfo() throws APIException {

		logger.info("****************************"+this.getClass().getName()+"*********************************");
		
		Uplancer uplancer = new Uplancer();
		
		uplancer.setEmail("yared@uplancer.io");
		
		uplancerInfo.getEntityManager().persist(uplancer);
		
		Uplancer uplancer2 = uplancerInfo.getUplancer();
		
		Assert.assertTrue(uplancer.equals(uplancer2));
		
	}
	
	@Test
	public void testUplancerInfo002() throws APIException {

		logger.info("****************************"+this.getClass().getName()+"*********************************");
		
		Uplancer uplancer2 = uplancerInfo.getUplancer();
		
		
	}

}
