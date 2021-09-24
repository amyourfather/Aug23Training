package framework;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadProperties {
	
	public String ReadBrowserType() throws IOException {
		Properties properties = new Properties();
		String propFileName = "config.properties";
		InputStream inputStream = null;
		try {
			inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
			properties.load(inputStream);
		} catch (Exception ex) {
			throw new RuntimeException("property file '" + propFileName + "' not found in the classpath");
		} finally {
				inputStream.close();
		}
		String browsertype = properties.getProperty("BrowserType");
		return browsertype;
	}
}
