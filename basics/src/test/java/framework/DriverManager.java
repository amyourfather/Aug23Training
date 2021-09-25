package framework;

import java.io.IOException;
import java.net.URISyntaxException;


import org.openqa.selenium.WebDriver;

public abstract class DriverManager {
	protected static WebDriver driver = null;
	protected String driverType;
	protected String WEB_DRIVER_SYSTEM_PROPERTY; 
	
	public void createDriver() throws IOException, URISyntaxException {
		return;
	}

	public WebDriver getDriver() {
		return driver;
	}
	
	public void quitDriver() {
		DriverManager.driver.quit();
	}
}
