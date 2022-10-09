package fw.driver.actions;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import fw.interfaces.IwebComponent;


/**
 * @author Sudharsan Raju
 */
public class JavaScriptActions implements IwebComponent {

	private WebDriver driver;
	private Logger oLog = LoggerActions.getLogger(JavaScriptActions.class);

	public JavaScriptActions(WebDriver driver) {
		this.driver = driver;
		oLog.debug("JavaScriptHelper : " + this.driver.hashCode());
	}

	public Object executeScript(String script) {
		JavascriptExecutor exe = (JavascriptExecutor) driver;
		oLog.info(script);
		return exe.executeScript(script);
	}

	public Object executeScript(String script, Object... args) {
		JavascriptExecutor exe = (JavascriptExecutor) driver;
		oLog.info(script);
		return exe.executeScript(script, args);
	}

	public void scrollToElemet(WebElement element) {
		executeScript("window.scrollTo(arguments[0],arguments[1])",
				element.getLocation().x, element.getLocation().y);
		oLog.info(element);
	}

	public void scrollToElemet(By locator) {
		scrollToElemet(driver.findElement(locator));
		oLog.info(locator);
	}

	public void scrollToElemetAndClick(By locator) {
		WebElement element = driver.findElement(locator);
		scrollToElemet(element);
		element.click();
		oLog.info(locator);
	}

	public void scrollToElemetAndClick(WebElement element) {
		scrollToElemet(element);
		element.click();
		oLog.info(element);
	}

	public void scrollIntoView(WebElement element) {
		executeScript("arguments[0].scrollIntoView()", element);
		oLog.info(element);
	}

	public void scrollIntoView(By locator) {
		scrollIntoView(driver.findElement(locator));
		oLog.info(locator);
	}

	public void scrollIntoViewAndClick(By locator) {
		WebElement element = driver.findElement(locator);
		scrollIntoView(element);
		element.click();
		oLog.info(locator);
	}

	public void scrollIntoViewAndClick(WebElement element) {
		scrollIntoView(element);
		element.click();
		oLog.info(element);
	}
}