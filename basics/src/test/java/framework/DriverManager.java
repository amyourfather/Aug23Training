package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {
	private static WebDriver driver = null;
	private String driverType;
	public DriverManager(String driverType) {
		this.driverType = driverType;
	}
	
	public void createDriver() {
		//create driver by drivertype
		if (this.driverType == null) {
			return;
		}
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
