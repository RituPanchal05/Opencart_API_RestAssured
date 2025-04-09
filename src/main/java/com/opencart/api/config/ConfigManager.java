package com.opencart.api.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/** @author Ritu Panchal
 
 
 * ConfigManager class is responsible for loading and providing access
 * to configuration values defined in the config.properties file.
 * This helps in centralizing all configurable values used throughout the project.
 * 
 * The file is loaded once statically when the class is first referenced.
 */
public class ConfigManager {

    // Properties object to hold the key-value pairs from the config file
    private static Properties props = new Properties();

    // Static block runs only once when the class is loaded
    static {
        try {
        	 System.out.println("📁 Step 1: Loading config from Config.Properties via ConfigManager.java");
            // Loading the config file from the resources directory
            FileInputStream fis = new FileInputStream("src/main/resources/Config.Properties");
            props.load(fis); // Load key-value pairs into props
        } catch (IOException e) {
            // If the file is not found or cannot be read, throw a runtime exception
            throw new RuntimeException("Could not load config.properties");
        }
    }

    /**
     * Returns the base URL of the application.
     * @return base URL as String
     */
    public static String getBaseUrl() {
        return props.getProperty("base.url");
    }
    
    

    /**
     * Returns the admin username configured in the config file.
     * @return admin username as String
     */
    public static String getAdminUsername() {
        return props.getProperty("admin.username");
    }
    

    /**
     * Returns the admin API key configured in the config file.
     * @return admin API key as String
     */
    public static String getAdminApiKey() {
        return props.getProperty("admin.key");
    }
}
