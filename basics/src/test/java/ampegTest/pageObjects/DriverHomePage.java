package ampegTest.pageObjects;

import org.openqa.selenium.WebDriver;
import ampegTest.foundation.DriverDocPage;

public class DriverHomePage extends DriverDocPage{

	public DriverHomePage(WebDriver driver, String HomeUrl) {
		super(driver, HomeUrl);
	}
	
	public DriverProductPage DisplayProductPage() {
		String ProductPageUrl = "https://ampeg.com/products/";
		String TopBarProductNavXpath = "//div[@id = 'global-topnav']//a[@title = 'Products']";
		ClickTo(TopBarProductNavXpath, ProductPageUrl);
		return new DriverProductPage(driver, HomeUrl);
	}
}