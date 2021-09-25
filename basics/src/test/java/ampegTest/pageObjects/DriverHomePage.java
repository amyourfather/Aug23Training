package ampegTest.pageObjects;

import org.openqa.selenium.WebDriver;
import ampegTest.foundation.DriverDocPage;
import basics.Page;

public class DriverHomePage extends DriverDocPage implements Page{

	public DriverHomePage(WebDriver driver) {
		super(driver);
	}
	
	public DriverProductPage DisplayProductPage() {
		String ProductPageUrl = "https://ampeg.com/products/";
		String TopBarProductNavXpath = "//div[@id = 'global-topnav']//a[@title = 'Products']";
		ClickTo(TopBarProductNavXpath, ProductPageUrl);
		return new DriverProductPage(driver);
	}

}
