package com.csse.business;

import java.util.ArrayList;

import com.csse.domain.Employee;

public abstract class EmployeeTemplate {
	
	public abstract void configureemployeeDetailsFromXml();
	
	public abstract void applyConfigurationEmployeeEntity();
	
	public abstract void saveEmployee();
	
	public abstract void employeeGetById(String employeeId);
	
	public abstract void employeeDelete(String employeeId);
	
	public abstract void getEmployeeDetails();
	
	public abstract void dispalyEmployeeDetails(ArrayList<Employee> employeeList);
	
	//Template method
	public final void applyemployeeOperation() {
		
		configureemployeeDetailsFromXml();
		
		applyConfigurationEmployeeEntity();
		
		saveEmployee();
		
	}
}
