package demoqaTest.foundation;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import basics.Page;
import demoqaTest.pageObjects.DriverLinkPage;
import demoqaTest.pageObjects.DriverRadioButtonPage;
import demoqaTest.pageObjects.DriverTextBoxPage;

public class DriverDocPage implements Page {
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
			driver.navigate().to(URL);
			return new DriverTextBoxPage(driver);
		}
		
		if (URL == this.RadioButtonUrl) {
			driver.navigate().to(URL);
			return new DriverRadioButtonPage(driver);
		}
		
		if (URL == this.LinksUrl) {
			driver.navigate().to(URL);
			return new DriverLinkPage(driver);
		}
		throw new IllegalArgumentException("you just entered an unsupported website URL: " + URL);
	}
	
	public void Click(String xpath) {
		WebElement button = driver.findElement(By.xpath(xpath));
		
		WebDriverWait wait = new WebDriverWait(driver, WaitTimeOut);
		wait.until(ExpectedConditions.elementToBeClickable(button));			
		button.click();
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
}
