package framework;

import java.time.Duration;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import ampegTest.foundation.ChromeDriverDocPage;

public class Testbase {
	
	protected WebDriver driver;
	private String ChromeDriverPath;
	private final String WEB_DRIVER_SYSTEM_PROPERTY = "webdriver.chrome.driver"; 
	protected ChromeDriverDocPage ChromeDriverDocPage;
	private final long WaitTimeOut = 5;
	private Duration NavWaitTimeOut = Duration.ofSeconds(5);
	private Duration PollingMilSec = Duration.ofMillis(100);
	@Before
	public void PreinitChorme() {	
		
		ChromeDriverPath = "C:\\Users\\techo\\Desktop\\Selenium\\chromedriver.exe";
		
		System.setProperty(WEB_DRIVER_SYSTEM_PROPERTY, ChromeDriverPath);
		driver = new ChromeDriver();
		ChromeDriverDocPage = new ChromeDriverDocPage(driver);
	}
	
	@After
	public void cleanup(){
		this.driver.quit();
	}
}
