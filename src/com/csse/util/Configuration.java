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
	public static final Logger log = Logger.getLogger(Configuration.class.getName());
	
	static {
		try {
			
			properties.load(QueryCommand.class.getResourceAsStream("../config/config.properties"));
			
		} catch (IOException e) {
			log.log(Level.SEVERE,e.getMessage());
		}catch(IllegalArgumentException e) {
			log.log(Level.SEVERE,e.getMessage());
		}catch(NullPointerException e) {
			log.log(Level.SEVERE,e.getMessage());
		}catch(Exception e) {
			log.log(Level.SEVERE,e.getMessage());
		}
	}

}
