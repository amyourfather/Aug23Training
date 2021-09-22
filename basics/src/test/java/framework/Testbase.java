package framework;

import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

import ampegTest.foundation.DriverDocPage;

public abstract class Testbase {
	private DriverManager DManager;
	protected WebDriver driver;
	protected DriverDocPage DriverDocPage;
	@Before
	public void Preinit() throws IOException, URISyntaxException {	
		DManager = WebDriverFactory.getManager("Edge");
		DManager.createDriver();
		driver = DManager.getDriver();
		DriverDocPage = new DriverDocPage(driver);
	}
	
	@After
	public void cleanup(){
		DManager.quitDriver();
	}
}
