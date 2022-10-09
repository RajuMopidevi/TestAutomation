package fw.settings;

import java.util.LinkedHashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import fw.interfaces.IconfigReader;

/**
 * @author Sudharsan Raju
 *
 */
public class ObjectRepo {
	
	private static final ThreadLocal<WebDriver> localDriver = new InheritableThreadLocal<>();
	public static WebDriver getLocaldriver() {
		return localDriver.get();
	}
	private static WebDriver driver;
	public static IconfigReader reader;
	public static Map<String, Object> data = new LinkedHashMap<String, Object>();
	
	public static WebDriver getDriver() {
		return localDriver.get();
	}
	public static void setDriver(WebDriver driver) {
		localDriver.set(driver);
	}
	
}

