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
public class CheckBoxOrRadioButtonActions implements IwebComponent {
	
	private WebDriver driver;
	private Logger oLog = LoggerActions.getLogger(CheckBoxOrRadioButtonActions.class);

	public CheckBoxOrRadioButtonActions(WebDriver driver) {
		this.driver = driver;
		oLog.debug("CheckBoxOrRadioButtonHelper : " + this.driver.hashCode());
	}
	
	public void selectCheckBox(By locator) {
		oLog.info(locator);
		selectCheckBox(driver.findElement(locator));
	}
	
	public void unSelectCheckBox(By locator) {
		oLog.info(locator);
		unSelectCheckBox(driver.findElement(locator));
	}
	
	public boolean isIselected(By locator) {
		oLog.info(locator);
		return isIselected(driver.findElement(locator));
	}
	
	public boolean isIselected(WebElement element) {
		boolean flag = element.isSelected();
		oLog.info(flag);
		return flag;
	}
	
	public void selectCheckBox(WebElement element) {
		if(!isIselected(element))
			element.click();
		oLog.info(element);
	}
	
	public void unSelectCheckBox(WebElement element) {
		if(isIselected(element))
			element.click();
		oLog.info(element);
	}
}
