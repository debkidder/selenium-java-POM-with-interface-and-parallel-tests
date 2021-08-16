package com.orangehrm.configs;

// Just for troubleshooting; this class can be deleted if needed
public class ConfigChecker {

	public static void main(String[] args) {
		
		ConfigReader reader = new ConfigReader();
		//reader.printConfig();
		
		System.out.println("From configs.properties file:");
		System.out.println("");
		
		System.out.println("URL:");
		System.out.println(reader.getConfigURL());

		System.out.println("Username1:");
		System.out.println(reader.getUsername1());

		System.out.println("Password1:");
		System.out.println(reader.getPassword1());
				
	}
	
}



