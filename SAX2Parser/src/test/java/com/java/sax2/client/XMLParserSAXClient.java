package com.java.sax2.client;

import java.io.File;
import java.io.IOException;
import java.util.List;
 


import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
 


import org.xml.sax.SAXException;
 


import com.java.sax2.parser.MyHandler;
import com.java.sax2.parser.dto.Employee;

 
public class XMLParserSAXClient {
 
    public static void main(String[] args) {
    SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
    try {
        SAXParser saxParser = saxParserFactory.newSAXParser();
        MyHandler handler = new MyHandler();
        saxParser.parse(new File("src/test/resources/sax-example.xml"), handler);
        //Get Employees list
        List<Employee> empList = handler.getEmpList();
        //print employee information
        for(Employee emp : empList)
            System.out.println(emp);
    } catch (ParserConfigurationException e) {
        e.printStackTrace();
    } catch (SAXException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    }
 
}