package ampegTest.pageObjects;

import org.openqa.selenium.WebDriver;

import ampegTest.foundation.DriverDocPage;

public class DriverProductSeries extends DriverDocPage {

	public DriverProductSeries(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public DriverProductDetail DisplayProductDetail(String xpath, String URL) {
		ClickTo(xpath, URL);
		return new DriverProductDetail(driver);
	}

}
