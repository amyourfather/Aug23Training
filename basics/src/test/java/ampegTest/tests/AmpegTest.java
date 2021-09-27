package ampegTest.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import ampegTest.foundation.DriverDocPage;
import ampegTest.pageObjects.DriverHomePage;
import ampegTest.pageObjects.DriverProductDetail;
import ampegTest.pageObjects.DriverProductSeries;
import ampegTest.pageObjects.DriverProductPage;
import framework.Testbase;

public class AmpegTest extends Testbase{
	private DriverDocPage DriverDocPage;
	@Test
	public void CanDisplayHomePageTest() {
		DriverDocPage = new DriverDocPage(driver);
		DriverHomePage HomePage = DriverDocPage.DisplayHomePage();
		String currentURL = driver.getCurrentUrl();
		String HomeUrl = HomePage.getHomeUrl();
		assertEquals("cant not go to url: " + HomeUrl, currentURL, HomeUrl);
	}
	
	@Test
	public void CanDisplayProductPageTest() {
		DriverDocPage = new DriverDocPage(driver);
		String ProductPageUrl = "https://ampeg.com/products/";
		
		DriverProductPage ProductPage = DriverDocPage
				.DisplayHomePage()
				.DisplayProductPage();
		String currentUrl = driver.getCurrentUrl();
		
		assertEquals("cant not go to url: " + ProductPageUrl, currentUrl, ProductPageUrl);
	}
	
	@Test
	public void CanClickToViewProductSeriesTest1() {
		DriverDocPage = new DriverDocPage(driver);
		String Series = "pro";
		String alt = "SVT Pro Series: Bass heads";
		String ProductSeriesUrl = "https://ampeg.com/products/pro/";
		
		DriverProductSeries ProductSeriesPage = DriverDocPage
				.DisplayHomePage()
				.DisplayProductPage()
				.DisplayProductSeries(alt, Series);
		String currentUrl = driver.getCurrentUrl();
		
		assertEquals("cant not go to url: " + ProductSeriesUrl, currentUrl, ProductSeriesUrl);
	}
	
	@Test 
	public void CanClickSVT_3PRO(){
		DriverDocPage = new DriverDocPage(driver);
		String Series = "pro";
		String SVT_3PRO_Path = "//img[@alt = 'SVT-3PRO']/..";
		String SVT_3PRO_URL = "https://ampeg.com/products/pro/svt3pro/";
		String alt = "SVT Pro Series: Bass heads";
		
		DriverProductDetail ProductDetailPage = DriverDocPage
				.DisplayHomePage()
				.DisplayProductPage()
				.DisplayProductSeries(alt, Series)
				.DisplayProductDetail(SVT_3PRO_Path, SVT_3PRO_URL);
		
		String currentUrl = driver.getCurrentUrl();
		
		assertEquals("cant not go to url: " + SVT_3PRO_URL, currentUrl, SVT_3PRO_URL);
	}
	
	@Test
	public void CanClickBreadcrumb_Home() {
		DriverDocPage = new DriverDocPage(driver);
		String Series = "pro";
		String SVT_3PRO_Path = "//img[@alt = 'SVT-3PRO']/..";
		String SVT_3PRO_URL = "https://ampeg.com/products/pro/svt3pro/";
		String alt = "SVT Pro Series: Bass heads";
		
		DriverHomePage Homepage = DriverDocPage
				.DisplayHomePage()
				.DisplayProductPage()
				.DisplayProductSeries(alt, Series)
				.DisplayProductDetail(SVT_3PRO_Path, SVT_3PRO_URL)
				.BackToHome();
		
		String currentUrl = driver.getCurrentUrl();
		
		assertEquals("cant not go to url: " + Homepage.getHomeUrl(), currentUrl, Homepage.getHomeUrl());
	}
	
	@Test
	public void CanClickToViewProductSeriesTest2() {
		DriverDocPage = new DriverDocPage(driver);
		String Series = "classic";
		String alt = "Classic Series: Bass heads & enclosures";
		String ProductSeriesUrl = "https://ampeg.com/products/classic/";
		
		DriverProductSeries ProductSeriesPage = DriverDocPage
				.DisplayHomePage()
				.DisplayProductPage()
				.DisplayProductSeries(alt, Series);
		String currentUrl = driver.getCurrentUrl();
		
		assertEquals("cant not go to url: " + ProductSeriesUrl, currentUrl, ProductSeriesUrl);
	}
	
	@Test 
	public void CanClickSVT_410HLF(){
		DriverDocPage = new DriverDocPage(driver);
		String Series = "classic";
		String SVT_410HLF_Path = "//img[@src[contains(.,'410HLF')]]/..";
		String SVT_410HLF_URL = "https://ampeg.com/products/classic/svt410hlf/";
		String alt = "Classic Series: Bass heads & enclosures";
		
		DriverProductDetail ProductDetailPage = DriverDocPage
				.DisplayHomePage()
				.DisplayProductPage()
				.DisplayProductSeries(alt, Series)
				.DisplayProductDetail(SVT_410HLF_Path, SVT_410HLF_URL);
		
		String currentUrl = driver.getCurrentUrl();
		
		assertEquals("cant not go to url: " + SVT_410HLF_URL, currentUrl, SVT_410HLF_URL);
	}
	
	@Test
	public void HandlingWeightTest() {
		DriverDocPage = new DriverDocPage(driver);
		String Series = "classic";
		String SVT_410HLF_Path = "//img[@src[contains(.,'410HLF')]]/..";
		String SVT_410HLF_URL = "https://ampeg.com/products/classic/svt410hlf/";
		String alt = "Classic Series: Bass heads & enclosures";
		
		DriverProductDetail ProductDetailPage = DriverDocPage
				.DisplayHomePage()
				.DisplayProductPage()
				.DisplayProductSeries(alt, Series)
				.DisplayProductDetail(SVT_410HLF_Path, SVT_410HLF_URL);
		
		String TextXPath = "//div[@class = 'specsCopy']";
		String[] result = ProductDetailPage.GetText(TextXPath).split("\n");
		String ExpectedResult = "Handling Weight: 85 Pounds";
		//System.out.println(result[result.length - 1]);
		assertEquals("last item in 'Specifications' is not \"" + ExpectedResult + "\"", result[result.length - 1], ExpectedResult );
	}
	
}
