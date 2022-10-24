package com.csse.util;
/**
 * 
 * This Class includes all the common constants used by the application
 */

public final class ApplicationConstants {
	
	/**
	 * This Class includes all the common constants used Configuaration Class 
	 */
	
	public static class Configuaration{
		
		/** constant for properties file */
		public static final String APPSETTING_CONFIG_PATH =  "../config/config.properties";
		
		/** constant for database connection string */
		public static final String CONNECTION_STRING =  "url";
		
		/** constant for database connection string */
		public static final String DATABASE_CONTEXT_USER =  "username";
		
		/** constant for database connection string */
		public static final String DATABASE_CONTEXT_PASSWORD =  "password";
		
		/** constant for database provider driver name */
		public static final String DATABASE_CONTEXT_PROVIDER_NAME =  "driverName";
	}
	

	/**
	 * This Class includes all the common constants used QueryCommand Class 
	 */
	
	public static class QueryCommand{
		
		/** constant for Query id TAG_NAME_STRING */
		public static final String TAG_NAME = "query";
		
		/** constant for Query id one */
		public static final String ATTRIBUTETAG = "id";
		
		/** constant for Query id one */
		public static final String EMPLOYEE_QUERY_PATH =  "src/com/csse/config/EmployeeQuery.xml";
	}
	
	/**
	 * This Class includes all the common constants used QueryCommands 
	 */
	public static class QueryCommandHandlers{
		
		/** constant for Query id one */
		public static final String QUERY_ONE = "q1";

		/** constant for Query id two */
		public static final String QUERY_TWO = "q2";

		/** constant for Query id three */
		public static final String QUERY_THREE = "q3";

		/** constant for Query id four */
		public static final String QUERY_FOUR = "q4";

		/** constant for Query id five */
		public static final String QUERY_FIVE = "q5";

		/** constant for Query id six */
		public static final String QUERY_SIX = "q6";
		
		
		/** constant for Column index one */
		public static final int COLUMN_INDEX_ONE = 1;

		/** constant for Column index two */
		public static final int COLUMN_INDEX_TWO = 2;

		/** constant for Column index three */
		public static final int COLUMN_INDEX_THREE = 3;

		/** constant for Column index four */
		public static final int COLUMN_INDEX_FOUR = 4;

		/** constant for Column index five */
		public static final int COLUMN_INDEX_FIVE = 5;

		/** constant for Column index six */
		public static final int COLUMN_INDEX_SIX = 6;

		/** constant for Column index seven */
		public static final int COLUMN_INDEX_SEVEN = 7;
	}

	/**
	 * This Class includes all the common constants used XMLTransfrom Class 
	 */
	
	public static class XMLTransfrom{
		
		/** constant for base path employee pipeline */
		public static final String BASE_PATH = "//Employees/Employee[";
		
		/** constant for base path employee id */
		public static final String PATH_EMPLOYEE_ID ="]/EmployeeID/text()";
		
		/** constant for base path employee full name */
		public static final String PATH_EMPLOYEE_FULL_NAME ="]/EmployeeFullName/text()";
		
		/** constant for base path employee address */
		public static final String PATH_EMPLOYEE_ADDRESS ="]/EmployeeFullAddress/text()";
		
		/** constant for base path employee name */
		public static final String PATH_EMPLOYEE_FACULTY_NAME ="]/FacultyName/text()";
		
		/** constant for base path employee department */
		public static final String PATH_EMPLOYEE_DEPARTMENT ="]/Department/text()";
		
		/** constant for base path employee designation */
		public static final String PATH_EMPLOYEE_DESIGNATION ="]/Designation/text()";
		
		/** constant for query path Employee ID of XpathEmployeeIDKey */
		public static final String XPATH_EMPLOYEE_ID_KEY = "XpathEmployeeIDKey";
		
		/** constant for query path Employee Name of XpathEmployeeNameKey */
		public static final String XPATH_EMPLOYEE_NAME_KEY = "XpathEmployeeNameKey";
		
		/** constant for query path Employee Address of XpathEmployeeAddressKey */
		public static final String XPATH_EMPLOYEE_ADDRESS_KEY = "XpathEmployeeAddressKey";
		
		/** constant for query path Employee Faculty of XpathFacultyNameKey */
		public static final String XPATH_EMPLOYEE_FACULTY_KEY = "XpathFacultyNameKey";
		
		/** constant for query path Employee Department of XpathDepartmentKey */
		public static final String XPATH_EMPLOYEE_DEPARTMENT_KEY = "XpathDepartmentKey";
		
		/** constant for query path Employee Designation of XpathDesignationKey */
		public static final String XPATH_EMPLOYEE_DESIGNATION_KEY = "XpathDesignationKey";
		
		/** constant for file path EmployeeRequest.xml  */
		public static final String EMPLOYEE_REQUEST_PATH_STRING  = "src/com/csse/config/EmployeeRequest.xml";
		
		/** constant for file path Employee-modified.xml */
		public static final String EMPLOYEE_MODIFIED_PATH_STRING = "src/com/csse/config/Employee-modified.xsl";
		
		/** constant for file path EmployeeResponse.xml */
		public static final String EMPLOYEE_RESPONSE_PATH_STRING = "src/com/csse/config/EmployeeResponse.xml";
		
		/** constant for counter path employee*/
		public static final String COUNTER_PATH = "count(//Employees/Employee)";
		
	}
}
