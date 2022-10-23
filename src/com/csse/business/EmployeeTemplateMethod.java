package com.csse.business;

import java.util.ArrayList;

import com.csse.domain.Employee;

public abstract class EmployeeTemplateMethod {
	
	public abstract void employeeFromXml();
	
	public abstract void employeeTableCreate();
	
	public abstract void employeesAdd();
	
	public abstract void employeeGetById(String employeeId);
	
	public abstract void employeeDelete(String employeeId);
	
	public abstract void employeeDisplay();
	
	public abstract void employeeOutput(ArrayList<Employee> employeeList);
}
