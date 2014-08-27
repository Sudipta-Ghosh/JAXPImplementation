package com.java.sax2.validator;

import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;
import java.io.File;

public class SAXValidator {

	public void validateSchema(String SchemaUrl, File xmlFile) {
		try {
			// Create SAXParserFactory
			SAXParserFactory factory = SAXParserFactory.newInstance();
			// Set factory to be a validating factory.
			factory.setNamespaceAware(true);
			factory.setValidating(true);
			// Set schema validation features
			factory.setFeature("http://xml.org/sax/features/validation", true);
			factory.setFeature("http://apache.org/xml/features/validation/schema", true);
			factory.setFeature("http://apache.org/xml/features/validation/schema-full-checking",true);
			// Create SAXParser
			SAXParser parser = factory.newSAXParser();

			// Set schema properties
			parser.setProperty("http://java.sun.com/xml/jaxp/properties/schemaLanguage","http://www.w3.org/2001/XMLSchema");
			parser.setProperty("http://java.sun.com/xml/jaxp/properties/schemaSource",SchemaUrl);

			// Create a ErrorHandler
			Validator handler = new Validator();
			// Parse XML Document
			parser.parse(xmlFile, handler);
			// Output Validation Errors

			if (handler.validationError == true)
				System.out.println("XML Document has Error:"+ handler.validationError + " "	+ handler.saxParseException.getMessage());
			else
				System.out.println("XML Document is valid");
		} catch (java.io.IOException ioe) {
			System.out.println("IOException " + ioe.getMessage());
		} catch (SAXException e) {
			System.out.println("SAXException" + e.getMessage());
		} catch (ParserConfigurationException e) {
			System.out
					.println("ParserConfigurationException " + e.getMessage());
		}
	}

	// ErrorHandler Class
	

	
}
