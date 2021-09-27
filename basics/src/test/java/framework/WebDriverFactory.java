package framework;

public class WebDriverFactory {
	public static DriverManager getManager(String driverType) {
		if(driverType.equals("Chrome")) {
			return new ChromeDriverManager();
		} else if(driverType.equals("Edge")) {
			return new EdgeDriverManager();
		}
		return null;
	}
}
