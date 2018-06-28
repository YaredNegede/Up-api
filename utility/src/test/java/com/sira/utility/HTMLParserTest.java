package com.sira.utility;


import java.io.IOException;

import org.junit.Test;


public class HTMLParserTest {

	@Test
	public void testParseFromString() throws IOException {
		
		HTMLParser hp = new HTMLParser();
		
		hp.parseFromStringFromFile("src/test/resources/vera.html");
		
		
	}

}
