package fw.driver.actions;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import fw.interfaces.IwebComponent;



/**
 * @author Sudharsan Raju
 *
 */
public class ButtonActions implements IwebComponent {
	
	private WebDriver driver;
	private Logger oLog = LoggerActions.getLogger(ButtonActions.class);
	
	public ButtonActions(WebDriver driver) {
		this.driver = driver;
		oLog.debug("Button Helper : " + this.driver.hashCode());
	}
	
	public void click(By locator) {
		click(driver.findElement(locator));
		oLog.info(locator);
	}
	
	public void click(WebElement element){
		element.click();
		oLog.info(element);
	}
}
