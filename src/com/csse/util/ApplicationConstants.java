package com.csse.util;

import java.text.MessageFormat;
/**
 * 
 * This Class includes all the common constants used by the application
 */

public final class ApplicationConstants {
	
	/**
	 * This Class includes all the common constants used ConfigUtil Class 
	 */
	
	public static class ConfigUtil{
		public static final String FILEPATH_STRING =  "../config/config.properties";
	}
	

	/**
	 * This Class includes all the common constants used QueryUtil Class 
	 */
	
	public static class QueryUtil{
		public static final String EMPLOYEE_QUERY_PATH_STRING =  "src/com/csse/config/EmployeeQuery.xml";
	}
	

	/**
	 * This Class includes all the common constants used TransformUtil Class 
	 */
	
	public static class TransformUtil{
		
		public static final String BASE_PATH = "//Employees/Employee[";
		
		public static final String SUB_PATH_EMP_ID ="]/EmployeeID/text()";
		public static final String SUB_PATH_EMP_FULL_NAME ="]/EmployeeFullName/text()";
		public static final String SUB_PATH_EMP_ADDRESS ="]/EmployeeFullAddress/text()";
		public static final String SUB_PATH_EMP_FACULTY_NAME ="]/FacultyName/text()";
		public static final String SUB_PATH_EMP_DEPARTMENT ="]/Department/text()";
		public static final String SUB_PATH_EMP_DESIGNATION ="]/Designation/text()";
			
		public static final String XPATH_EMPLOYEE_ID = "XpathEmployeeIDKey";
		public static final String XPATH_EMPLOYEE_NAME = "XpathEmployeeNameKey";
		public static final String XPATH_EMPLOYEE_ADDRESS = "XpathEmployeeAddressKey";
		public static final String XPATH_EMPLOYEE_FACULTY = "XpathFacultyNameKey";
		public static final String XPATH_EMPLOYEE_DEPARTMENT = "XpathDepartmentKey";
		public static final String XPATH_EMPLOYEE_DESIGNATION = "XpathDesignationKey";
				
		public static final String EMPLOYEE_REQUEST_PATH_STRING  = "src/com/csse/config/EmployeeRequest.xml";
		public static final String EMPLOYEE_MODIFIED_PATH_STRING = "src/com/csse/config/Employee-modified.xsl";
		public static final String EMPLOYEE_RESPONSE_PATH_STRING = "src/com/csse/config/EmployeeResponse.xml";
						
		public static final String COUNTER_PATH = "count(//Employees/Employee)";
				
		/*
		 * 
		 * This method concatenate,String for compile path
		 * 
		 * */
		
		public static String getCompliePath(int number,String path2) {
			String message = MessageFormat.format("{0}" + "{1}"+ "{2}",BASE_PATH, number, path2);
			return message;
		}
	}
}
