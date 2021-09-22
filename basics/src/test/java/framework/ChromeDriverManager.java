package framework;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.Properties;

import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverManager extends DriverManager {

	public ChromeDriverManager(String driverType) {
		super(driverType);
	}
	
	public void createDriver() throws IOException, URISyntaxException {
		Properties pro = new Properties();
		String propFileName = "config.properties";
		
		if (this.driverType == null) {
			return;
		}
		
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
		
		if (inputStream != null) {
			pro.load(inputStream);
		} else {
			throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
		}
		
		WEB_DRIVER_SYSTEM_PROPERTY = pro.getProperty(driverType);
		String DriverName = pro.getProperty(WEB_DRIVER_SYSTEM_PROPERTY);
		
		URL res = getClass().getClassLoader().getResource(DriverName);
		File file = Paths.get(res.toURI()).toFile();
		String absolutePath = file.getAbsolutePath();
		System.setProperty(WEB_DRIVER_SYSTEM_PROPERTY, absolutePath);
		
		//will change later
		
		this.driver = new ChromeDriver();
	}

}
