package com.csse.pipeline;

import javax.xml.xpath.XPathFactory;
import java.util.HashMap;
import java.util.Map;
import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import org.w3c.dom.Document;

import com.csse.util.ApplicationConstants;

import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.transform.TransformerFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;

public class XMLTransfrom {
	
	private static final ArrayList<Map<String, String>> employeeDataSet= new ArrayList<Map<String, String>>();
	
	private static Map<String, String> employeeDetails = null;
	
	/**
	 * 
	 * This method converts request XML file into response XML file
	 * @return void
	 */
	
	public static void  requestTransform() throws Exception {

		Source requestSource = new StreamSource(new File(ApplicationConstants.XMLTransfrom.EMPLOYEE_REQUEST_PATH_STRING));
		Source modifiedSource = new StreamSource(new File(ApplicationConstants.XMLTransfrom.EMPLOYEE_MODIFIED_PATH_STRING));
		Result responseResult = new StreamResult(new File(ApplicationConstants.XMLTransfrom.EMPLOYEE_RESPONSE_PATH_STRING));

		TransformerFactory.newInstance().newTransformer(modifiedSource).transform(requestSource, responseResult);
	}
	
	/**
	 * 
	 * This method converts XML inputs into an ArrayList of Employee Objects 
	 * @return ArrayList<Map<String, String>>
	 */
	
	public static ArrayList<Map<String, String>> xmlPaths() throws RuntimeException,ParserConfigurationException,NullPointerException,XPathExpressionException,IllegalArgumentException,Exception {

		Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder()
				.parse(ApplicationConstants.XMLTransfrom.EMPLOYEE_RESPONSE_PATH_STRING);
		
		XPath xPath = XPathFactory.newInstance().newXPath();
		int counter = Integer.parseInt((String) xPath.compile(ApplicationConstants.XMLTransfrom.COUNTER_PATH).evaluate(document, XPathConstants.STRING));
		for (int index = 1; index <= counter; index++) {
			
			employeeDetails = new HashMap<String, String>();
			
			employeeDetails.put(
					ApplicationConstants.XMLTransfrom.XPATH_EMPLOYEE_ID_KEY, 
					(String) xPath.compile(
							ApplicationConstants.XMLTransfrom.BASE_PATH + index + ApplicationConstants.XMLTransfrom.PATH_EMPLOYEE_ID)
					.evaluate(document, XPathConstants.STRING
					));
			
			employeeDetails.put(
					ApplicationConstants.XMLTransfrom.XPATH_EMPLOYEE_NAME_KEY, 
					(String) xPath.compile(
							ApplicationConstants.XMLTransfrom.BASE_PATH + index + ApplicationConstants.XMLTransfrom.PATH_EMPLOYEE_FULL_NAME)
					.evaluate(document, XPathConstants.STRING
					));
			
			
			employeeDetails.put(
					ApplicationConstants.XMLTransfrom.XPATH_EMPLOYEE_ADDRESS_KEY, 
					(String) xPath.compile(
							ApplicationConstants.XMLTransfrom.BASE_PATH + index + ApplicationConstants.XMLTransfrom.PATH_EMPLOYEE_ADDRESS)
					.evaluate(document, XPathConstants.STRING
					));
			
			
			employeeDetails.put(
					ApplicationConstants.XMLTransfrom.XPATH_EMPLOYEE_FACULTY_KEY,
					(String) xPath.compile(
							ApplicationConstants.XMLTransfrom.BASE_PATH + index + ApplicationConstants.XMLTransfrom.PATH_EMPLOYEE_FACULTY_NAME)
					.evaluate(document, XPathConstants.STRING
					));
			
			
			employeeDetails.put(
					ApplicationConstants.XMLTransfrom.XPATH_EMPLOYEE_DEPARTMENT_KEY,
					(String) xPath.compile(
							ApplicationConstants.XMLTransfrom.BASE_PATH + index + ApplicationConstants.XMLTransfrom.PATH_EMPLOYEE_DEPARTMENT)
					.evaluate(document, XPathConstants.STRING
					));
			
			
			employeeDetails.put(ApplicationConstants.XMLTransfrom.XPATH_EMPLOYEE_DESIGNATION_KEY, 
					(String) xPath.compile(ApplicationConstants.XMLTransfrom.BASE_PATH  + index + ApplicationConstants.XMLTransfrom.PATH_EMPLOYEE_DESIGNATION )
					.evaluate(document, XPathConstants.STRING
					));
			
			employeeDataSet.add(employeeDetails);
		}
		
		return employeeDataSet;
		
		
	}
}
