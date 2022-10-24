package com.csse.util;

import com.mysql.jdbc.Connection;
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
	
	private static String databaseContextConnectionString = properties.getProperty(ApplicationConstants.Configuaration.CONNECTION_STRING.toString());
	private static String databaseContextUser = properties.getProperty(ApplicationConstants.Configuaration.DATABASE_CONTEXT_USER.toString());
	private static String databaseContextPassword = properties.getProperty(ApplicationConstants.Configuaration.DATABASE_CONTEXT_PASSWORD.toString());
	private static String databaseContextprovider = properties.getProperty(ApplicationConstants.Configuaration.DATABASE_CONTEXT_PROVIDER_NAME.toString());
	
	public EmployeeDatabaseContext() {
		

	}
	
	public static  Connection databaseContextBuilder() {
		if (connection == null) {	
			
			try {
				
				Class.forName(databaseContextprovider);
				
				connection = (Connection)DriverManager.getConnection
						(
								databaseContextConnectionString, 
								databaseContextUser,
								databaseContextPassword
						);
				
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
			
			}
			
		}
		
		return connection;
		
	}

}
