package com.csse.util;

import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
*
* This class reads the config.property file and attempt to find the resources
*
*/
public class Configuration {
	
	//Create properties instance 
	public static final Properties properties= new Properties();
	
	//Create logger instance 
	public static final Logger logger = Logger.getLogger(Configuration.class.getName());
	
	static {
		try {
			
			properties.load(QueryCommand.class.getResourceAsStream(ApplicationConstants.Configuaration.APPSETTING_CONFIG_PATH));
			
		} catch (IOException ex) {
			
			logger.log(Level.SEVERE, ex.getMessage());
			
		}catch(IllegalArgumentException ex) {
			
			logger.log(Level.SEVERE, ex.getMessage());
			
		}catch(NullPointerException ex) {
			
			logger.log(Level.SEVERE, ex.getMessage());
			
		}catch(Exception ex) {
			
			logger.log(Level.SEVERE, ex.getMessage());
		}
	}

}
