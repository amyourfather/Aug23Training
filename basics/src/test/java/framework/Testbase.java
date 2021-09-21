package framework;

import java.time.Duration;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import ampegTest.foundation.ChromeDriverDocPage;

public abstract class Testbase {
	private DriverManager DManager;
	protected WebDriver driver;
	private String ChromeDriverPath;
	private final String WEB_DRIVER_SYSTEM_PROPERTY = "webdriver.chrome.driver"; 
	protected ChromeDriverDocPage ChromeDriverDocPage;
	@Before
	public void PreinitChorme() {	
		
		//will fix later
		ChromeDriverPath = "C:\\Users\\techo\\Desktop\\Selenium\\chromedriver.exe";
		
		System.setProperty(WEB_DRIVER_SYSTEM_PROPERTY, ChromeDriverPath);
		DManager = WebDriverFactory.getManager("Chrome");
		DManager.createDriver();
		driver = DManager.getDriver();
		ChromeDriverDocPage = new ChromeDriverDocPage(driver);
	}
	
	@After
	public void cleanup(){
		DManager.quitDriver();
	}
}
