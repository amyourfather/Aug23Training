package basics;

import org.openqa.selenium.WebDriver;

public class ChromeDriverProductPage extends ChromeDriverDocPage implements Page{

	public ChromeDriverProductPage(WebDriver driver) {
		super(driver);
	}
	
	public ChromeDriverProductSeries DisplayProductSeries(String alt, String EndingUrl) {
		String ProductUrl = "https://ampeg.com/products/"+ EndingUrl +"/";
		String ProductXpath = "//img[@alt = '" + alt + "']/..";
		ClickTo(ProductXpath, ProductUrl);
		
		return new ChromeDriverProductSeries(driver);
	}

}
