package ampegTest.pageObjects;

import org.openqa.selenium.WebDriver;

import ampegTest.foundation.ChromeDriverDocPage;

public class ChromeDriverProductDetail extends ChromeDriverDocPage {

	public ChromeDriverProductDetail(WebDriver driver) {
		super(driver);
	}
	
	public ChromeDriverHomePage BackToHome() {
		String BreadcrumbHomeXpath = "//div[@id = 'navLinks']//a[text() = 'Home']";
		ClickTo(BreadcrumbHomeXpath, HomeUrl);
		return new ChromeDriverHomePage(driver);
	}

}
