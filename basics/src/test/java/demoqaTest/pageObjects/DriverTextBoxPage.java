package demoqaTest.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import demoqaTest.foundation.DriverDocPage;

public class DriverTextBoxPage extends DriverDocPage {

	public DriverTextBoxPage(WebDriver driver) {
		super(driver);
	}
	
	public void FillInText(String xpath, String text) {
		WebElement fillInPlace = driver.findElement(By.xpath(xpath));
		fillInPlace.sendKeys(text);
	}
}
