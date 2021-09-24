package framework;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {
	private WebDriver driver;
	
	public void createDriver() {
		return;
	}

	public WebDriver getDriver() {
		return driver;
	}
	
	public void quitDriver() {
		this.driver.quit();
	}

	protected void setDriver(WebDriver driver) {
		this.driver = driver;
	}
}
