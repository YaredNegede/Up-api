package com.server;

import java.io.UnsupportedEncodingException;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.server.error.GateException;

public class ServerTest {

	private static Logger logger = Logger.getLogger(ServerTest.class);

	Gson gson = new Gson();

	@Test
	public void test001() throws  GateException, JsonSyntaxException, UnsupportedEncodingException {
		
		logger.info("***********************************");
		
	}

}
