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
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
