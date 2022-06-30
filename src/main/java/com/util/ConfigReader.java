package com.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


import org.apache.commons.configuration.CompositeConfiguration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.SystemConfiguration;

public class ConfigReader {
	
	private Properties prop;
	
	public Properties init_prop( ) {
		prop = new Properties();
		
		try {
			FileInputStream ip = new FileInputStream("./src/test/resources/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return prop;
	}
	
	/*
	 * public Properties init_prop( ) { prop = new Properties();
	 * 
	 * CompositeConfiguration configuration = new CompositeConfiguration(); try {
	 * configuration.addConfiguration(new SystemConfiguration());
	 * configuration.addConfiguration(new
	 * PropertiesConfiguration("./src/test/resources/config/config.properties"));
	 * prop. } catch (ConfigurationException e) { e.printStackTrace(); }
	 * 
	 * return prop; }
	 */

}
