package demoqaTest.pageObjects;

import org.openqa.selenium.WebDriver;

import demoqaTest.foundation.DriverDocPage;

public class DriverLinkPage extends DriverDocPage {
	private final String homePageUrl = "https://demoqa.com/";
	private final String homeXpath = "//a[@id='simpleLink']";
	private String homeWindowHandle;
	public DriverLinkPage(WebDriver driver) {
		super(driver);
	}
	
	public DriverHomePage ClickToHome() {
		this.homeWindowHandle = super.ClickNewTab(homeXpath, homePageUrl);
		return new DriverHomePage(driver);
	}
	
	public String getHomeWindowHandle() {
		return homeWindowHandle;
	}

}
