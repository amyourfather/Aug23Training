package framework;

public class WebDriverFactory {
	public static DriverManager getManager(String driverType) {
		if(driverType == "Chrome") {
			return new ChromeDriverManager(driverType);
		} else if(driverType == "Edge") {
			return new EdgeDriverManager(driverType);
		}
		return null;
	}
}
