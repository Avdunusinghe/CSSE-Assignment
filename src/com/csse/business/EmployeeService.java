package com.csse.business;

import java.util.ArrayList;


import java.sql.Connection;
import java.util.logging.Logger;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import com.csse.domain.Employee;
import com.csse.pipeline.XMLTransfrom;

import java.sql.PreparedStatement;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.Map;

public class EmployeeService extends EmployeeTemplateMethod {
	private final ArrayList<Employee> employeeList= new ArrayList<Employee>();
	
	private static final Logger log = Logger.getLogger(EmployeeService.class.getName());
	private static Connection connection ;

	private static Statement statement ;

	private PreparedStatement preparedStatement;
	
	/**
	 * 
	 * Includes Database Data Storage functions and XML Data retrieval functions
	 * 
	 * XML data retrieval function : employeeFromXML 
	 *
	 */

	@Override
	/**
	 * Stores data collected from the XML file inside an global variable
	 * This information is accessible from any class
	 * 
	 *  @return void
	 */

	public void employeeFromXml() {
		try {
			for (Map<String, String> docMap : XMLTransfrom.xmlPaths()) {
				Employee employee= new Employee();
				employee.setEmployeeId(docMap.get("XpathEmployeeIDKey"));
				employee.setFullName(docMap.get("XpathEmployeeNameKey"));
				employee.setAddress(docMap.get("XpathEmployeeAddressKey"));
				employee.setFacultyName(docMap.get("XpathFacultyNameKey"));
				employee.setDepartment(docMap.get("XpathDepartmentKey"));
				employee.setDesignation(docMap.get("XpathDesignationKey"));
				employeeList.add(employee);
				System.out.println(employee.toString() + "\n");
			}
		} catch (IllegalArgumentException e) {
			log.log(Level.SEVERE,e.getMessage());
		}catch (NullPointerException e) {
			log.log(Level.SEVERE,e.getMessage());
		}catch (RuntimeException e) {
			log.log(Level.SEVERE,e.getMessage());
		}catch (ParserConfigurationException e) {
			log.log(Level.SEVERE,e.getMessage());
		}catch (XPathExpressionException e) {
			log.log(Level.SEVERE,e.getMessage());
		}
		catch (Exception e) {
			log.log(Level.SEVERE,e.getMessage());
		}
		
	}

	@Override
	public void employeeTableCreate() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void employeesAdd() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void employeeGetById(String employeeId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void employeeDelete(String employeeId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void employeeDisplay() {
		// TODO Auto-generated method stub
		
	}

}

