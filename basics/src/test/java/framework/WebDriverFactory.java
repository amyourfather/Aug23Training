package framework;

public class WebDriverFactory {
	public static DriverManager getManager(String driverType) {
		return new DriverManager(driverType);
	}
}
