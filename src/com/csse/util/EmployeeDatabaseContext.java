package com.csse.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * 
 * This class is used to establish Java MYSQL database connectivity TCP/IP
 *  
 *
 */


public class EmployeeDatabaseContext extends Configuration  {
	
	
	private static Connection connection = null;
	public static final Logger logger = Logger.getLogger(EmployeeDatabaseContext.class.getName());
	private static String urlString = properties.getProperty("url");
	private static String userNameString = properties.getProperty("username");
	private static String passwordString = properties.getProperty("password");
	private static String driverNameString = properties.getProperty("driverName");
	
	public static  Connection databaseContextBuilder() {
		if (connection == null) {	
			
			try {
				
				Class.forName(driverNameString);
				connection = DriverManager.getConnection(urlString, userNameString,passwordString);
				
				return connection;
				
			} catch (ClassNotFoundException ex) {
				
				logger.log(Level.SEVERE, ex.getMessage());
				
			}catch (SQLTimeoutException ex) {
				
				logger.log(Level.SEVERE, ex.getMessage());
				
			}catch (SQLException  ex) {
				
				logger.log(Level.SEVERE, ex.getMessage());
				
			}catch (ExceptionInInitializerError   ex) {
				
				logger.log(Level.SEVERE, ex.getMessage());
				
			}catch (LinkageError  ex) {
				
				logger.log(Level.SEVERE, ex.getMessage());
				
			}catch (Exception  ex) {
				
				logger.log(Level.SEVERE, ex.getMessage());
			
			}finally {
				try {
					
					//if exception occurs, this will close the database connection 
					
					if(connection != null) {
						connection.close();
					}
				} catch (SQLException ex) {
					
					logger.log(Level.SEVERE,ex.getMessage());
				}
			}
		}
		
		return connection;
		
	}

}
