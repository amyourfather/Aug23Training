package framework;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.Properties;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {
	private static WebDriver driver = null;
	private String driverType;
	private String WEB_DRIVER_SYSTEM_PROPERTY; 
	
	public DriverManager(String driverType) {
		this.driverType = driverType;
	}
	
	public void createDriver() throws IOException, URISyntaxException {
		//create driver by drivertype
		Properties pro = new Properties();
		String propFileName = "config.properties";
		
		if (this.driverType == null) {
			return;
		}
		
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
		
		if (inputStream != null) {
			pro.load(inputStream);
		} else {
			throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
		}
		
		String WEB_DRIVER_SYSTEM_PROPERTY = pro.getProperty(driverType);
		String DriverName = pro.getProperty(WEB_DRIVER_SYSTEM_PROPERTY);
		
		System.out.println(DriverName);
		URL res = getClass().getClassLoader().getResource(DriverName);
		String absolutePath = "";
		if(res != null) {
			File file = Paths.get(res.toURI()).toFile();
			absolutePath = file.getAbsolutePath();
		}
		System.out.println(absolutePath);
		System.setProperty(WEB_DRIVER_SYSTEM_PROPERTY, absolutePath);
		//will change later
		this.driver = new ChromeDriver();
	}

	public WebDriver getDriver() {
		return driver;
	}
	
	public void quitDriver() {
		this.driver.quit();
	}
}
