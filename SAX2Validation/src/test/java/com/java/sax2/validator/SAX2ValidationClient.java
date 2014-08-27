package com.java.sax2.validator;

import java.io.File;

public class SAX2ValidationClient {
	
	public static void main(String[] argv) {
		String SchemaUrl = "sax-example.xsd";
		File xmlFile = new File("src/test/resources/sax-example.xml");
		SAXValidator validator = new SAXValidator();
		validator.validateSchema(SchemaUrl, xmlFile);
	}

}
