package framework;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.Properties;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

public abstract class Testbase {
	private DriverManager DManager;
	protected WebDriver driver;
	
	@Before
	public void Preinit() throws IOException, URISyntaxException {
		
		
		Properties pro = new Properties();
		String propFileName = "config.properties";
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
		if (inputStream != null) {
			pro.load(inputStream);
		} else {
			throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
		}
		
		String DriverName = pro.getProperty("BrowserType");
		
		
		DManager = WebDriverFactory.getManager(DriverName);
		DManager.createDriver();
		driver = DManager.getDriver();
	}
	
	@After
	public void cleanup(){
		//DManager.quitDriver();
	}
}
