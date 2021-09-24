package ampegTest.pageObjects;

import org.openqa.selenium.WebDriver;

import ampegTest.foundation.DriverDocPage;

public class DriverProductPage extends DriverDocPage{

	public DriverProductPage(WebDriver driver, String HomeUrl) {
		super(driver, HomeUrl);
	}
	
	public DriverProductSeries DisplayProductSeries(String alt, String EndingUrl) {
		String ProductUrl = "https://ampeg.com/products/"+ EndingUrl +"/";
		String ProductXpath = "//img[@alt = '" + alt + "']/..";
		ClickTo(ProductXpath, ProductUrl);
		
		return new DriverProductSeries(driver, HomeUrl);
	}
}