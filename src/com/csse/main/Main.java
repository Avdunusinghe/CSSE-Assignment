package com.csse.main;

import com.csse.business.EmployeeService;
import com.csse.business.EmployeeTemplate;
import com.csse.pipeline.XMLTransfrom;
import java.util.logging.Logger;

import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;

import java.util.logging.Level;

/*
* Main class
*
* entry point of the application
*
*/
public class Main {
	
	/**
	 * @param args
	 */
	public static final Logger logger = Logger.getLogger(Main.class.getName());
	
	/**
	 * main method
	 * @throws Exception 
	 * 
	 * @throws TransformerException                 -specifies an exceptional
	 *                                              condition that occurred during
	 *                                              the transformation process.
	 * @throws TransformerFactoryConfigurationError -Thrown when a problem with
	 *                                              configuration with the
	 *                                              Transformer Factories exists.
	 */

	public static void main(String[] args) {
		
		try {
			
		    XMLTransfrom.requestTransform();
			
			EmployeeTemplate service = new EmployeeService();
			
			service.applyemployeeOperation();
			//service.employeeGetById("EMP10004");
			//service.employeeDelete("EMP10001");
			//service.getEmployeeDetails();
			
		} catch (TransformerException  ex) {
			
			logger.log(Level.SEVERE,  ex.getMessage());
			
		} catch (TransformerFactoryConfigurationError  ex) {
			
			logger.log(Level.SEVERE,  ex.getMessage());
			
		}catch (Exception ex) {
			
			logger.log(Level.SEVERE,  ex.getMessage());
		}
	}

}
