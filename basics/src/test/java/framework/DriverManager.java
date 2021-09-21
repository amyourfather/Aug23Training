package framework;

import org.openqa.selenium.WebDriver;

public class DriverManager {
	protected WebDriver driver;
	
	public static void createDriver() {
		
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
	public void quitDriver() {
		this.driver.quit();
	}
}
