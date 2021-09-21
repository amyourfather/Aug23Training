package tests;

import static org.junit.Assert.*;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.ChromeDriverDocPage;
import pageObjects.ChromeDriverHomePage;
import pageObjects.ChromeDriverProductDetail;
import pageObjects.ChromeDriverProductPage;
import pageObjects.ChromeDriverProductSeries;

public class AmpegTest {
	private String ChromeDriverPath;
	private final String WEB_DRIVER_SYSTEM_PROPERTY = "webdriver.chrome.driver"; 
	private final long WaitTimeOut = 5;
	private Duration NavWaitTimeOut = Duration.ofSeconds(5);
	private Duration PollingMilSec = Duration.ofMillis(100);
	private WebDriver driver;
	private ChromeDriverDocPage ChromeDriverDocPage;
	
	
	@Before
	public void PreinitChorme() {	
		
		ChromeDriverPath = "C:\\Users\\techo\\Desktop\\Selenium\\chromedriver.exe";
		
		System.setProperty(WEB_DRIVER_SYSTEM_PROPERTY, ChromeDriverPath);
		driver = new ChromeDriver();
		ChromeDriverDocPage = new ChromeDriverDocPage(driver);
	}
	
	@Test
	public void CanDisplayHomePageTest() {
		ChromeDriverHomePage HomePage = ChromeDriverDocPage.DisplayHomePage();
		String currentURL = driver.getCurrentUrl();
		String HomeUrl = HomePage.getHomeUrl();
		assertEquals("cant not go to url: " + HomeUrl, currentURL, HomeUrl);
		
		driver.quit();
	}
	
	@Test
	public void CanDisplayProductPageTest() {
		String ProductPageUrl = "https://ampeg.com/products/";
		
		ChromeDriverProductPage ProductPage = ChromeDriverDocPage
				.DisplayHomePage()
				.DisplayProductPage();
		String currentUrl = driver.getCurrentUrl();
		
		assertEquals("cant not go to url: " + ProductPageUrl, currentUrl, ProductPageUrl);
		
		driver.quit();
	}
	
	@Test
	public void CanClickToViewProductSeriesTest1() {
		String Series = "pro";
		String alt = "SVT Pro Series: Bass heads";
		String ProductSeriesUrl = "https://ampeg.com/products/pro/";
		
		ChromeDriverProductSeries ProductSeriesPage = ChromeDriverDocPage
				.DisplayHomePage()
				.DisplayProductPage()
				.DisplayProductSeries(alt, Series);
		String currentUrl = driver.getCurrentUrl();
		
		assertEquals("cant not go to url: " + ProductSeriesUrl, currentUrl, ProductSeriesUrl);
		driver.quit();
	}
	
	@Test 
	public void CanClickSVT_3PRO(){
		String Series = "pro";
		String SVT_3PRO_Path = "//img[@alt = 'SVT-3PRO']/..";
		String SVT_3PRO_URL = "https://ampeg.com/products/pro/svt3pro/";
		String alt = "SVT Pro Series: Bass heads";
		
		ChromeDriverProductDetail ProductDetailPage = ChromeDriverDocPage
				.DisplayHomePage()
				.DisplayProductPage()
				.DisplayProductSeries(alt, Series)
				.DisplayProductDetail(SVT_3PRO_Path, SVT_3PRO_URL);
		
		String currentUrl = driver.getCurrentUrl();
		
		assertEquals("cant not go to url: " + SVT_3PRO_URL, currentUrl, SVT_3PRO_URL);
		
		driver.quit();
	}
	
	@Test
	public void CanClickBreadcrumb_Home() {
		String Series = "pro";
		String SVT_3PRO_Path = "//img[@alt = 'SVT-3PRO']/..";
		String SVT_3PRO_URL = "https://ampeg.com/products/pro/svt3pro/";
		String alt = "SVT Pro Series: Bass heads";
		
		ChromeDriverHomePage Homepage = ChromeDriverDocPage
				.DisplayHomePage()
				.DisplayProductPage()
				.DisplayProductSeries(alt, Series)
				.DisplayProductDetail(SVT_3PRO_Path, SVT_3PRO_URL)
				.BackToHome();
		
		String currentUrl = driver.getCurrentUrl();
		
		assertEquals("cant not go to url: " + Homepage.getHomeUrl(), currentUrl, Homepage.getHomeUrl());
		driver.quit();
	}
	
	@Test
	public void CanClickToViewProductSeriesTest2() {
		String Series = "classic";
		String alt = "Classic Series: Bass heads & enclosures";
		String ProductSeriesUrl = "https://ampeg.com/products/classic/";
		
		ChromeDriverProductSeries ProductSeriesPage = ChromeDriverDocPage
				.DisplayHomePage()
				.DisplayProductPage()
				.DisplayProductSeries(alt, Series);
		String currentUrl = driver.getCurrentUrl();
		
		assertEquals("cant not go to url: " + ProductSeriesUrl, currentUrl, ProductSeriesUrl);
		driver.quit();
	}
	
	@Test 
	public void CanClickSVT_410HLF(){
		String Series = "classic";
		String SVT_410HLF_Path = "//img[@src[contains(.,'410HLF')]]/..";
		String SVT_410HLF_URL = "https://ampeg.com/products/classic/svt410hlf/";
		String alt = "Classic Series: Bass heads & enclosures";
		
		ChromeDriverProductDetail ProductDetailPage = ChromeDriverDocPage
				.DisplayHomePage()
				.DisplayProductPage()
				.DisplayProductSeries(alt, Series)
				.DisplayProductDetail(SVT_410HLF_Path, SVT_410HLF_URL);
		
		String currentUrl = driver.getCurrentUrl();
		
		assertEquals("cant not go to url: " + SVT_410HLF_URL, currentUrl, SVT_410HLF_URL);
		
		driver.quit();
	}
	
	@Test
	public void HandlingWeightTest() {
		String Series = "classic";
		String SVT_410HLF_Path = "//img[@src[contains(.,'410HLF')]]/..";
		String SVT_410HLF_URL = "https://ampeg.com/products/classic/svt410hlf/";
		String alt = "Classic Series: Bass heads & enclosures";
		
		ChromeDriverProductDetail ProductDetailPage = ChromeDriverDocPage
				.DisplayHomePage()
				.DisplayProductPage()
				.DisplayProductSeries(alt, Series)
				.DisplayProductDetail(SVT_410HLF_Path, SVT_410HLF_URL);
		
		String TextXPath = "//div[@class = 'specsCopy']";
		String[] result = ProductDetailPage.GetText(TextXPath).split("\n");
		String ExpectedResult = "Handling Weight: 85 Pounds";
		//System.out.println(result[result.length - 1]);
		assertEquals("last item in 'Specifications' is not \"" + ExpectedResult + "\"", result[result.length - 1], ExpectedResult );
		driver.quit();
	}
	
}
