package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {
	protected WebDriver driver;
	
	private DriverManager(String driverType) {
		
	}
	
	public void createDriver() {
		this.driver = new ChromeDriver();
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
	public void quitDriver() {
		this.driver.quit();
	}
}
