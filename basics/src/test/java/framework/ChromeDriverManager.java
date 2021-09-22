package framework;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverManager extends DriverManager {

	public void createDriver() throws URISyntaxException {
		WEB_DRIVER_SYSTEM_PROPERTY = "webdriver.chrome.driver";
		String DriverName = "chromedriver.exe";
		
		URL res = getClass().getClassLoader().getResource(DriverName);
		File file = Paths.get(res.toURI()).toFile();
		String absolutePath = file.getAbsolutePath();
		System.setProperty(WEB_DRIVER_SYSTEM_PROPERTY, absolutePath);
		
		DriverManager.driver = new ChromeDriver();
	}

}
