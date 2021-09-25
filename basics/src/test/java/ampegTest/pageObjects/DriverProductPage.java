package ampegTest.pageObjects;

import org.openqa.selenium.WebDriver;

import ampegTest.foundation.DriverDocPage;
import basics.Page;

public class DriverProductPage extends DriverDocPage implements Page{

	public DriverProductPage(WebDriver driver) {
		super(driver);
	}
	
	public DriverProductSeries DisplayProductSeries(String alt, String EndingUrl) {
		String ProductUrl = "https://ampeg.com/products/"+ EndingUrl +"/";
		String ProductXpath = "//img[@alt = '" + alt + "']/..";
		ClickTo(ProductXpath, ProductUrl);
		
		return new DriverProductSeries(driver);
	}

}
