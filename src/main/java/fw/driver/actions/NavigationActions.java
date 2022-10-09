package fw.driver.actions;

import java.net.URL;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import fw.interfaces.IwebComponent;

/**
 * @author Sudharsan Raju
 *	
 *
 */
public class NavigationActions implements IwebComponent {
	
	private WebDriver driver;
	private Logger oLog = LoggerActions.getLogger(NavigationActions.class);

	public NavigationActions(WebDriver driver) {
		this.driver = driver;
		oLog.debug("NavigationHelper : " + this.driver.hashCode());
	}
	
	public void navigateTo(String url) {
		oLog.info(url);
		driver.get(url);
	}

	public void naviagteTo(URL url) {
		oLog.info(url.getPath());
		driver.get(url.getPath());
	}

	public String getTitle() {
		String title = driver.getTitle();
		oLog.info(title);
		return driver.getTitle();
	}

	public String getCurrentUrl() {
		String url = driver.getCurrentUrl();
		oLog.info(url);
		return driver.getCurrentUrl();
	}
	

}
