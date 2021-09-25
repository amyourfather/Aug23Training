package framework;

public class WebDriverFactory {
	public static DriverManager getManager(String driverType) {
		if(driverType == "Chrome") {
			return new ChromeDriverManager();
		} else if(driverType == "Edge") {
			return new EdgeDriverManager();
		}
		return null;
	}
}
