package ampegTest.foundation;


import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import ampegTest.pageObjects.DriverHomePage;

public class DriverDocPage{
	protected WebDriver driver;
	protected final long WaitTimeOut = 5;
	protected Duration NavWaitTimeOut = Duration.ofSeconds(5);
	protected Duration PollingMilSec = Duration.ofMillis(100);
	protected String HomeUrl = "https://ampeg.com/index.html";
	
	public DriverDocPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public DriverHomePage DisplayHomePage() {
		driver.navigate().to(HomeUrl);
		return new DriverHomePage(driver);
	}
	
	public void ClickTo(String xpath, String URL) {
		WebElement button = driver.findElement(By.xpath(xpath));
		
		WebDriverWait wait = new WebDriverWait(driver, WaitTimeOut);
		wait.until(ExpectedConditions.elementToBeClickable(button));			
		button.click();
		
		FluentWait<WebDriver> urlchangewait = new FluentWait<WebDriver>(driver)
				.withTimeout(this.NavWaitTimeOut)
				.pollingEvery(this.PollingMilSec)
				.ignoring(NoSuchElementException.class);
		urlchangewait.until(ExpectedConditions.urlToBe(URL));
	}
	
	public String GetText(String xpath) {
		WebElement Location = driver.findElement(By.xpath(xpath));
		return Location.getText();
	}
	
	public String getHomeUrl() {
		return HomeUrl;
	}
}
