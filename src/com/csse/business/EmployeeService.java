package com.csse.business;

import java.util.ArrayList;
import java.io.IOException;
import java.sql.Connection;
import java.util.logging.Logger;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.xml.sax.SAXException;

import com.csse.domain.Employee;
import com.csse.pipeline.XMLTransfrom;
import com.csse.util.ApplicationConstants;
import com.csse.util.EmployeeDatabaseContext;
import com.csse.util.QueryCommand;

import java.sql.PreparedStatement;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.sql.Statement;

import java.util.Map;

public class EmployeeService extends EmployeeTemplate {
	
	private final ArrayList<Employee> employeeList= new ArrayList<Employee>();
	
	private static final Logger logger = Logger.getLogger(EmployeeService.class.getName());
	
	private static Connection connection = null;
	private static Statement statement;
	private PreparedStatement preparedStatement;
	
	public EmployeeService() {
		
		connection = EmployeeDatabaseContext.databaseContextBuilder();
	}
	
	
	/**
	 * Includes Database Data Storage functions and XML Data retrieval functions
	 * 
	 * @throws NumberFormatException        -Thrown to indicate that the application
	 *                                      has attempted to convert a string to one
	 *                                      of the numeric types
	 * @throws XPathExpressionException     -indicate an error in an XPath
	 *                                      expression.
	 * @throws SQLException                 -Thrown when database access error
	 *                                      occurs or this method is called on a
	 *                                      closed connection
	 * @throws SAXException                 -Encapsulate a general SAX error or
	 *                                      warning
	 * @throws IOException                  -Exception produced by failed or
	 *                                      interrupted I/O operations
	 *
	 * @throws ParserConfigurationException -Indicate a serious configuration error
	 */

	@Override
	public void configureemployeeDetailsFromXml() {
		try {
			
			
			for (Map<String, String> item : XMLTransfrom.xmlPaths()) {
				
				Employee employee= new Employee();
				
				employee.setEmployeeId(item.get(ApplicationConstants.XMLTransfrom.XPATH_EMPLOYEE_ID_KEY));
				employee.setFullName(item.get(ApplicationConstants.XMLTransfrom.XPATH_EMPLOYEE_NAME_KEY));
				employee.setAddress(item.get(ApplicationConstants.XMLTransfrom.XPATH_EMPLOYEE_ADDRESS_KEY));
				employee.setFacultyName(item.get(ApplicationConstants.XMLTransfrom.XPATH_EMPLOYEE_FACULTY_KEY));
				employee.setDepartment(item.get(ApplicationConstants.XMLTransfrom.XPATH_EMPLOYEE_DEPARTMENT_KEY));
				employee.setDesignation(item.get(ApplicationConstants.XMLTransfrom.XPATH_EMPLOYEE_DESIGNATION_KEY));
				
				
				employeeList.add(employee);
				
				System.out.println(employee.getEmployeeId() + "\n" + employee.getFullName()+ "\n" + employee.getAddress() + "\n" + employee.getFacultyName() + "\n" + employee.getDepartment() + "/n" +  employee.getDesignation() + "/n");
				System.out.println();
				
			}
		} catch (NumberFormatException exception) {
			
			logger.log(Level.SEVERE, exception.getMessage());
			
		} catch (XPathExpressionException exception) {
			
			logger.log(Level.SEVERE, exception.getMessage());
			
		} catch (SAXException exception) {
			
			logger.log(Level.SEVERE, exception.getMessage());
			
		} catch (IOException exception) {
			
			logger.log(Level.SEVERE, exception.getMessage());
			
		} catch (ParserConfigurationException exception) {
			
			logger.log(Level.SEVERE, exception.getMessage());
		}
		catch (Exception e) {
			
			logger.log(Level.SEVERE,e.getMessage());
		}
		
	}
	
	/**
	 * This method create employee table in database(apply table configuration)
	 * 
	 * @throws SQLException                 -Thrown when database access error
	 *                                      occurs or this method is called on a
	 *                                      closed connection
	 * @throws SAXException                 -Encapsulate a general SAX error or
	 *                                      warning
	 * @throws IOException                  -Exception produced by failed or
	 *                                      interrupted I/O operations
	 *
	 * @throws ParserConfigurationException -Indicate a serious configuration error
	 */

	@Override
	public void applyConfigurationEmployeeEntity() {
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
	 * This method ADD employee
	 * 
	 * @throws SQLException                 -Thrown when database access error
	 *                                      occurs or this method is called on a
	 *                                      closed connection
	 * @throws SAXException                 -Encapsulate a general SAX error or
	 *                                      warning
	 * @throws IOException                  -Exception produced by failed or
	 *                                      interrupted I/O operations
	 *
	 * @throws ParserConfigurationException -Indicate a serious configuration error
	 */
	
	@Override
	public void saveEmployee() {
		try {
			
			preparedStatement = connection.prepareStatement(QueryCommand.query(ApplicationConstants.QueryCommandHandlers.QUERY_THREE));
			connection.setAutoCommit(false);
			
			for(Employee employee: employeeList) {
				
				preparedStatement.setString
				(
						ApplicationConstants.QueryCommandHandlers.COLUMN_INDEX_ONE, 
						employee.getEmployeeId()
				);
				
				preparedStatement.setString
				(
						ApplicationConstants.QueryCommandHandlers.COLUMN_INDEX_TWO, 
						employee.getFullName()
			    );
				
				preparedStatement.setString
				(
						ApplicationConstants.QueryCommandHandlers.COLUMN_INDEX_THREE, 
						employee.getAddress()
				);
				
				preparedStatement.setString
				(
						ApplicationConstants.QueryCommandHandlers.COLUMN_INDEX_FOUR, 
						employee.getFacultyName()
				);
				
				preparedStatement.setString
				(
						ApplicationConstants.QueryCommandHandlers.COLUMN_INDEX_FIVE, 
						employee.getDepartment()
				);
				
				preparedStatement.setString
				(
						ApplicationConstants.QueryCommandHandlers.COLUMN_INDEX_SIX, 
						employee.getDesignation()
				);
				
				preparedStatement.addBatch();
			}
			
			preparedStatement.executeBatch();
			connection.commit();
		
		}catch (SQLException ex) {
			
			logger.log(Level.SEVERE, ex.getMessage());
			
		} catch (SAXException ex) {
			
			logger.log(Level.SEVERE, ex.getMessage());
			
		} catch (IOException ex) {
			
			logger.log(Level.SEVERE, ex.getMessage());
			
		} catch (ParserConfigurationException ex) {
			
			logger.log(Level.SEVERE, ex.getMessage());
			
		}catch (Exception ex) {
			
			logger.log(Level.SEVERE, ex.getMessage());
			
		} 
		
		
	}
	
	/**
	 * This method GET a employee details
	 * 
	 * @param eid ID of employee to get details
	 * @throws SQLException                 -Thrown when database access error
	 *                                      occurs or this method is called on a
	 *                                      closed connection
	 * @throws SAXException                 -Encapsulate a general SAX error or
	 *                                      warning
	 * @throws IOException                  -Exception produced by failed or
	 *                                      interrupted I/O operations
	 *
	 * @throws ParserConfigurationException -Indicate a serious configuration error
	 */

	@Override
	public void employeeGetById(String employeeId) {
		
		Employee employee = new Employee();
		
		try {
			preparedStatement = connection.prepareStatement(QueryCommand.query(ApplicationConstants.QueryCommandHandlers.QUERY_FOUR));
			preparedStatement.setString(ApplicationConstants.QueryCommandHandlers.COLUMN_INDEX_ONE, employeeId);
			
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
			
			dispalyEmployeeDetails(employeeList);
			
		}catch (SQLException ex) {
			
			logger.log(Level.SEVERE, ex.getMessage());
			
		} catch (SAXException ex) {
			
			logger.log(Level.SEVERE, ex.getMessage());
			
		} catch (ParserConfigurationException ex) {
			
			logger.log(Level.SEVERE, ex.getMessage());
			
		} catch (IOException ex) {
			
			logger.log(Level.SEVERE, ex.getMessage());
			
		}catch (Exception ex) {
			
			logger.log(Level.SEVERE, ex.getMessage());
			
		}
		
	}
	
	/**
	 * This method DELETE a employee
	 * 
	 * @param eid ID of employee to delete
	 * @throws SQLException                 -Thrown when database access error
	 *                                      occurs or this method is called on a
	 *                                      closed connection
	 * @throws SAXException                 -Encapsulate a general SAX error or
	 *                                      warning
	 * @throws IOException                  -Exception produced by failed or
	 *                                      interrupted I/O operations
	 *
	 * @throws ParserConfigurationException -Indicate a serious configuration error
	 * 
	 * @param String
	 */

	@Override
	public void employeeDelete(String employeeId) {
		try {
			preparedStatement = connection.prepareStatement(QueryCommand.query(ApplicationConstants.QueryCommandHandlers.QUERY_SIX));
			preparedStatement.setString(1, employeeId);
			preparedStatement.executeUpdate();
			
		} catch (SQLException ex) {
			
			logger.log(Level.SEVERE, ex.getMessage());
			
		} catch (SAXException ex) {
			
			logger.log(Level.SEVERE, ex.getMessage());
			
		} catch (IOException ex) {
			
			logger.log(Level.SEVERE, ex.getMessage());
			
		} catch (ParserConfigurationException ex) {
			
			logger.log(Level.SEVERE, ex.getMessage());
			
		} catch (Exception ex) {
			
			logger.log(Level.SEVERE, ex.getMessage());
			
		}
		
	}

	@Override
	public void getEmployeeDetails() {
		
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
		}catch (SQLException ex) {
			
			logger.log(Level.SEVERE, ex.getMessage());
			
		} catch (SAXException ex) {
			
			logger.log(Level.SEVERE, ex.getMessage());
			
		} catch (IOException ex) {
			
			logger.log(Level.SEVERE, ex.getMessage());
			
		} catch (ParserConfigurationException ex) {
			
			logger.log(Level.SEVERE, ex.getMessage());
			
		} catch (Exception ex) {
			
			logger.log(Level.SEVERE, ex.getMessage());
		}
		
		dispalyEmployeeDetails(employees);
		
	}
	
	/**
	 * This method PRINT all employee details
	 * 
	 * @param employeeList ArrayList<Employee> Array of employee list to print
	 */
	
	@Override
	public void dispalyEmployeeDetails(ArrayList<Employee> employeeList) {
		
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

