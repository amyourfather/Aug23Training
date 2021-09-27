package demoqaTest.foundation;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import ampegTest.pageObjects.DriverHomePage;
import basics.Page;

public abstract class DriverDocPage implements Page {
	protected WebDriver driver;
	protected final long WaitTimeOut = 5;
	protected Duration NavWaitTimeOut = Duration.ofSeconds(5);
	protected Duration PollingMilSec = Duration.ofMillis(100);
	protected String TextBoxUrl = "https://demoqa.com/text-box";
	protected String RadioButtonUrl = "https://demoqa.com/radio-button";
	protected String LinksUrl = "https://demoqa.com/links";
	
	public DriverDocPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public DriverDocPage NavigateToPage(String URL) {
		if (URL == this.TextBoxUrl) {
			
		}
		
		if (URL == this.RadioButtonUrl) {
			
		}
		
		if (URL == this.LinksUrl) {
			
		}
		return null;
		
		//driver.navigate().to(HomeUrl);
		//return new DriverDocPage(driver);
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
	
	//public String getHomeUrl() {
	//	return HomeUrl;
	//}
}
