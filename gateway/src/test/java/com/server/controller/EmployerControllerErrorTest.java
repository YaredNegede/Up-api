package com.server.controller;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.google.gson.Gson;
import com.server.Server;
import com.server.error.GateException;
import com.sira.api.EmployerInfo;
import com.sira.api.request.Context;

public class EmployerControllerErrorTest {

	private static Logger logger = Logger.getLogger(EmployerControllerErrorTest.class);

	private static ApplicationContext appcont = new ClassPathXmlApplicationContext("/applicationContext.xml");

	Gson gson = new Gson();

	static EmployerInfo employerInfo = (EmployerInfo) appcont.getBean("Employer");

	Server server = new EmployerController();
	@Before
	public  void setup(){
		if(!employerInfo.getEntitimanager().getTransaction().isActive()){
			employerInfo.getEntitimanager().getTransaction().begin();
		}

		server.context = new Context(appcont );
	}

	boolean exp = false;
	
	@Test(expected=GateException.class)
	public void testError01() throws GateException {
		exp=true;
		server.add(null);
	}

	@Test(expected=GateException.class)
	public void testError02() throws GateException {
		exp=true;
		server.view(null);
	}

	@Test(expected=GateException.class)
	public void testError03() throws GateException {
		exp=true;
		server.update(null);
	}

	@Test(expected=GateException.class)
	public void testError04() throws GateException {
		exp=true;
		server.delete(null);
	}

	@Test(expected=GateException.class)
	public void testError05() throws GateException {
		exp=true;
		server.viewAll(null );
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
