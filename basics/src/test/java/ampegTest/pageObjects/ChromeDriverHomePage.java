package ampegTest.pageObjects;

import org.openqa.selenium.WebDriver;

import ampegTest.foundation.ChromeDriverDocPage;
import basics.Page;

public class ChromeDriverHomePage extends ChromeDriverDocPage implements Page{

	public ChromeDriverHomePage(WebDriver driver) {
		super(driver);
	}
	
	public ChromeDriverProductPage DisplayProductPage() {
		String ProductPageUrl = "https://ampeg.com/products/";
		String TopBarProductNavXpath = "//div[@id = 'global-topnav']//a[@title = 'Products']";
		ClickTo(TopBarProductNavXpath, ProductPageUrl);
		return new ChromeDriverProductPage(driver);
	}

}
