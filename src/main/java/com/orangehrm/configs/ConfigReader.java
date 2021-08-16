package com.orangehrm.configs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ConfigReader {
	

    //public String browserName;
    public String configURL;
    public String username1;
    public String password1;
    public Properties prop;

    public ConfigReader() {
        try {
            Properties prop = new Properties();
            FileInputStream fis = new FileInputStream("C:\\Users\\Debbie\\eclipse-workspace\\CorePOM\\src\\main\\java\\com\\orangehrm\\configs\\configs.properties");
            prop.load(fis);

            //browserName = prop.getProperty("Browser");
            configURL = prop.getProperty("URL");
            username1 = prop.getProperty("Username1");
            password1 = prop.getProperty("Password1");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // can quickly test in ConfigChecker class
    public String getConfigURL() {
    	return configURL;
    }
    
    public String getUsername1() {
    	return username1;
    }
    
    public String getPassword1() {
    	return password1;
    }

}


