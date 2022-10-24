package com.csse.business;

import java.util.ArrayList;


import java.sql.Connection;
import java.util.logging.Logger;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import com.csse.domain.Employee;
import com.csse.interfaces.IEmployeeDatabaseContext;
import com.csse.pipeline.XMLTransfrom;
import com.csse.util.ApplicationConstants;
import com.csse.util.EmployeeDatabaseContext;
import com.csse.util.QueryCommand;

import java.sql.PreparedStatement;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.Map;

public class EmployeeService extends EmployeeTemplateMethod {
	private final ArrayList<Employee> employeeList= new ArrayList<Employee>();
	
	private static final Logger logger = Logger.getLogger(EmployeeService.class.getName());
	private static Connection connection = null;
	private static Statement statement;

	private PreparedStatement preparedStatement;
	
	
	public EmployeeService() {
		
		connection = EmployeeDatabaseContext.databaseContextBuilder();
	}
	
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
				
				employee.setEmployeeId(docMap.get(ApplicationConstants.XMLTransfrom.XPATH_EMPLOYEE_ID_KEY));
				employee.setFullName(docMap.get(ApplicationConstants.XMLTransfrom.XPATH_EMPLOYEE_NAME_KEY));
				employee.setAddress(docMap.get(ApplicationConstants.XMLTransfrom.XPATH_EMPLOYEE_ADDRESS_KEY));
				employee.setFacultyName(docMap.get(ApplicationConstants.XMLTransfrom.XPATH_EMPLOYEE_FACULTY_KEY));
				employee.setDepartment(docMap.get(ApplicationConstants.XMLTransfrom.XPATH_EMPLOYEE_DEPARTMENT_KEY));
				employee.setDesignation(docMap.get(ApplicationConstants.XMLTransfrom.XPATH_EMPLOYEE_DESIGNATION_KEY));
				
				employeeList.add(employee);
				
				
			}
		} catch (IllegalArgumentException e) {
			
			logger.log(Level.SEVERE,e.getMessage());
			
		}catch (NullPointerException e) {
			
			logger.log(Level.SEVERE,e.getMessage());
			
		}catch (RuntimeException e) {
			
			logger.log(Level.SEVERE,e.getMessage());
			
		}catch (ParserConfigurationException e) {
			
			logger.log(Level.SEVERE,e.getMessage());
			
		}catch (XPathExpressionException e) {
			
			logger.log(Level.SEVERE,e.getMessage());
		}
		catch (Exception e) {
			
			logger.log(Level.SEVERE,e.getMessage());
		}
		
	}
	
	/**
	 * Creates Employee table inside SQL database
	 * @return void
	 * @exception java.sql.SQLException
	 */

	@Override
	public void employeeTableCreate() {
		try {
			
			statement = connection.createStatement();
			statement.executeUpdate(QueryCommand.query(ApplicationConstants.QueryCommandHandlers.QUERY_TWO));
			statement.executeUpdate(QueryCommand.query(ApplicationConstants.QueryCommandHandlers.QUERY_ONE));
			
		} catch (SQLException e) {
			
			logger.log(Level.SEVERE,e.getMessage());
		}
		catch (Exception e) {
			
			logger.log(Level.SEVERE,e.getMessage());
		}
		
	}
	
	/**
	 * Inserts a new employee to employee table in sql database
	 * @return void
	 * @exception java.sql.SQLException
	 */
	@Override
	public void employeesAdd() {
		try {
			
			preparedStatement = connection.prepareStatement(QueryCommand.query(ApplicationConstants.QueryCommandHandlers.QUERY_THREE));
			connection.setAutoCommit(false);
			
			for(Employee employee: employeeList) {
				
				preparedStatement.setString(1, employee.getEmployeeId());
				preparedStatement.setString(2, employee.getFullName());
				preparedStatement.setString(3, employee.getAddress());
				preparedStatement.setString(4, employee.getFacultyName());
				preparedStatement.setString(5, employee.getDepartment());
				preparedStatement.setString(6, employee.getDesignation());
				preparedStatement.addBatch();
			}
			preparedStatement.executeBatch();
			connection.commit();
		
		}catch (SQLException ex) {
			
			logger.log(Level.SEVERE, ex.getMessage());
			
		} catch (Exception ex) {
			
			logger.log(Level.SEVERE, ex.getMessage());
		}
		
		
	}
	
	/**
	 * provides employee information for given employee id
	 * @return void
	 * @param String
	 * @exception java.sql.SQLException
	 */

	@Override
	public void employeeGetById(String employeeId) {
		
		Employee employee = new Employee();
		
		try {
			preparedStatement = connection.prepareStatement(QueryCommand.query(ApplicationConstants.QueryCommandHandlers.QUERY_FOUR));
			preparedStatement.setString(1, employeeId);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				employee.setEmployeeId(resultSet.getString(1));
				employee.setFullName(resultSet.getString(2));
				employee.setAddress(resultSet.getString(3));
				employee.setFacultyName(resultSet.getString(4));
				employee.setDepartment(resultSet.getString(5));
				employee.setDesignation(resultSet.getString(6));
			}
			
			
			ArrayList<Employee> employeeList = new ArrayList<Employee>();
			
			employeeList.add(employee);
			
			employeeOutput(employeeList);
			
		}catch (SQLException ex) {
			
			logger.log(Level.SEVERE, ex.getMessage());
			
		} catch (Exception ex) {
			
			logger.log(Level.SEVERE, ex.getMessage());
		}
		
	}
	
	/**
	 * read employee table from sql database
	 * @return void
	 * @param String
	 * @exception java.sql.SQLException
	 */

	@Override
	public void employeeDelete(String employeeId) {
		try {
			preparedStatement = connection.prepareStatement(QueryCommand.query(ApplicationConstants.QueryCommandHandlers.QUERY_SIX));
			preparedStatement.setString(1, employeeId);
			preparedStatement.executeUpdate();
		}catch (SQLException e) {
			logger.log(Level.SEVERE,e.getMessage());
		} catch (Exception e) {
			logger.log(Level.SEVERE,e.getMessage());
		}
		
	}

	@Override
	public void employeeDisplay() {
		ArrayList<Employee> employees = new ArrayList<Employee>();
		try {
			preparedStatement = connection.prepareStatement(QueryCommand.query(ApplicationConstants.QueryCommandHandlers.QUERY_FIVE));
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				Employee employee = new Employee();
				employee.setEmployeeId(resultSet.getString(1));
				employee.setFullName(resultSet.getString(2));
				employee.setAddress(resultSet.getString(3));
				employee.setFacultyName(resultSet.getString(4));
				employee.setDepartment(resultSet.getString(5));
				employee.setDesignation(resultSet.getString(6));
				employees.add(employee);
				
			}
		}catch (SQLException e) {
			
			logger.log(Level.SEVERE,e.getMessage());
			
		} catch (Exception e) {
			
			logger.log(Level.SEVERE,e.getMessage());
		}
		
		employeeOutput(employees);
		
	}
	
	/**
	 * displays list of employees for given employees list
	 * @return void
	 * @param ArrayList<Employee>
	 * @exception java.sql.SQLException
	 */
	
	@Override
	public void employeeOutput(ArrayList<Employee> employeeList) {
		System.out.println("Employee ID" + "\t\t" + "Full Name" + "\t\t" + "Address" + "\t\t" + "Faculty Name" + "\t\t"
				+ "Department" + "\t\t" + "Designation" + "\n");
		System.out
				.println("================================================================================================================");
		
		
		for(Employee employee : employeeList) {
			System.out.println(employee.getEmployeeId() + "\t" + employee.getFullName() + "\t\t"
					+ employee.getAddress() + "\t" + employee.getFacultyName() + "\t" + employee.getDepartment() + "\t"
					+ employee.getDesignation() + "\n");
			System.out
			.println("----------------------------------------------------------------------------------------------------------------");
		}
		
	}

}

