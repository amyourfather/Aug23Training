package ampegTest.pageObjects;

import org.openqa.selenium.WebDriver;

import ampegTest.foundation.DriverDocPage;

public class DriverProductDetail extends DriverDocPage {

	public DriverProductDetail(WebDriver driver) {
		super(driver);
	}
	
	public DriverHomePage BackToHome() {
		String BreadcrumbHomeXpath = "//div[@id = 'navLinks']//a[text() = 'Home']";
		ClickTo(BreadcrumbHomeXpath, HomeUrl);
		return new DriverHomePage(driver);
	}

}
