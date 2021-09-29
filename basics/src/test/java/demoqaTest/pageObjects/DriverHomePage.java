package demoqaTest.pageObjects;

import org.openqa.selenium.WebDriver;

import demoqaTest.foundation.DriverDocPage;

public class DriverHomePage extends DriverDocPage {
	private final String joinNowUrl = "https://www.toolsqa.com/selenium-training/";
	private final String joinNowXpath = "//img[@alt='Selenium Online Training']/..";
	private String joinWindowHandle;
	public DriverHomePage(WebDriver driver) {
		super(driver);
	}

	public DriverTrainingPage ClickJoinNow() {
		this.joinWindowHandle = super.ClickNewTab(joinNowXpath, joinNowUrl);
		return new DriverTrainingPage(driver);
	}

	public String getJoinWindowHandle() {
		return joinWindowHandle;
	}
}
