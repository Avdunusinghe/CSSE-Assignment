package com.csse.main;

import com.csse.business.EmployeeService;
import com.csse.pipeline.XMLTransfrom;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			XMLTransfrom.requestTransform();
			
			EmployeeService service = new EmployeeService();
			service.employeeFromXml();
			service.employeeTableCreate();
			service.employeesAdd();
			service.employeeGetById("EMP10004");
			service.employeeDelete("EMP10001");
			service.employeeDisplay();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
