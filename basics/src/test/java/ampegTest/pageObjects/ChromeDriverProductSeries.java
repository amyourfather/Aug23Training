package ampegTest.pageObjects;

import org.openqa.selenium.WebDriver;

import ampegTest.foundation.ChromeDriverDocPage;

public class ChromeDriverProductSeries extends ChromeDriverDocPage {

	public ChromeDriverProductSeries(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public ChromeDriverProductDetail DisplayProductDetail(String xpath, String URL) {
		ClickTo(xpath, URL);
		return new ChromeDriverProductDetail(driver);
	}

}
