package basics;

import org.openqa.selenium.WebDriver;

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
