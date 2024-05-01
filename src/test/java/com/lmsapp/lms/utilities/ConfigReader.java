package com.lmsapp.lms.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
	
	public static ThreadLocal<Properties> prop = new ThreadLocal<Properties>();
	
	private static void init_prop() {		
		prop.set(new Properties());
		try {
			//FileInputStream fis = new FileInputStream("C:\\Users\\User\\eclipse-workspace\\LMSapp\\src\\test\\resources\\config\\global.properties");
			InputStream fis = ConfigReader.class.getClassLoader().getResourceAsStream("config/global.properties");
			prop.get().load(fis);
		} 
		catch (IOException e) {
			
			e.printStackTrace();
		}		 
	}
	
	public static String getProperty(String key) {
		if (prop.get() == null) {
			init_prop();
		}
		return prop.get().getProperty(key);
	}
	public static void setProperty(String key, String value) {
		if (prop.get() == null) {
			init_prop();
		}
		prop.get().setProperty(key,value);
	}
	
	public String getLocation() {
	    if (prop.get() == null) {
	        init_prop();
	    }
	    return prop.get().getProperty("Location");
	}

	public String getEmail() {
	    if (prop.get() == null) {
	        init_prop();
	    }
	    return prop.get().getProperty("Email");
	}
	    
		public String getURL() {
		    if (prop.get() == null) {
		        init_prop();
		    }
		    return prop.get().getProperty("URL");
		}
	    
	    public String getFirstName() {
		    if (prop.get() == null) {
		        init_prop();
		    }
		    return prop.get().getProperty("FirstName");
	    }
	    
	    public  String getLastName(){
	        if (prop.get() == null) {
	            init_prop();
	        }
	        return prop.get().getProperty("LastName");
	    }
	    
	    public  String getMiddleName(){
	        if (prop.get() == null) {
	            init_prop();
	        }
	        return prop.get().getProperty("MiddleName");
	    }

	    public  String getPhoneNumber(){
	        if (prop.get() == null) {
	            init_prop();
	        }
	        return prop.get().getProperty("PhoneNumber");
	    }
	    
	    public  String getPostGraduate(){
	        if (prop.get() == null) {
	            init_prop();
	        }
	        return prop.get().getProperty("PostGraduate");
	    }
	    
	    public  String getGraduate(){
	        if (prop.get() == null) {
	            init_prop();
	        }
	        return prop.get().getProperty("Graduate");
	    }
	    
	    public  String getComments(){
	        if (prop.get() == null) {
	            init_prop();
	        }
	        return prop.get().getProperty("Comments");
	    }
	}



