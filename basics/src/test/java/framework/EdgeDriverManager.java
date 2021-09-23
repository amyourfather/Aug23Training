package framework;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import org.openqa.selenium.edge.EdgeDriver;

public class EdgeDriverManager extends DriverManager {

	public void createDriver() throws URISyntaxException {
		
		WEB_DRIVER_SYSTEM_PROPERTY = "webdriver.edge.driver";
		String DriverName = "msedgedriver.exe";
		
		URL res = getClass().getClassLoader().getResource(DriverName);
		File file = Paths.get(res.toURI()).toFile();
		String absolutePath = file.getAbsolutePath();
		
		System.setProperty(WEB_DRIVER_SYSTEM_PROPERTY, absolutePath);
		DriverManager.driver = new EdgeDriver();
	}
}
