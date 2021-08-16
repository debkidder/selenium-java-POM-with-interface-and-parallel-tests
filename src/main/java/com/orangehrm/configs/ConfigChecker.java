package com.orangehrm.configs;

// I only created this class for troubleshooting; it can be deleted if needed
public class ConfigChecker {

	public static void main(String[] args) {
		
		ConfigReader reader = new ConfigReader();
		//reader.printConfig();
		
		System.out.println("From configs.properties file:");
		System.out.println("");
		System.out.println("URL:");
		System.out.println(reader.getConfigURL());
		

	}
	
}



