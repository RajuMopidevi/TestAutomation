package bdd.pages;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import fw.driver.actions.GridActions;
import fw.driver.actions.LoggerActions;
import fw.generic.PageBase;


public class HomePage extends PageBase {
	
	private WebDriver driver;
	private final Logger log = LoggerActions.getLogger(HomePage.class);
	
	public HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	/** Web Elements */
	
	@FindBy(how=How.XPATH,using="//input[@placeholder='What needs to be done?']")
	public WebElement inputBox;
	
	@FindBy(how=How.XPATH,using="//div[@class='view']/label[text()='$Text']")
	public WebElement taskName;

	@FindBy(how=How.XPATH,using="//a[contains(text(),'All')]")
	public WebElement filterLinkAll;
	
	@FindBy(how=How.XPATH,using="//a[contains(text(),'Active')]")
	public WebElement filterLinkActive;	
	
	@FindBy(how=How.XPATH,using="//a[contains(text(),'Completed')]")
	public WebElement filterLinkCompleted;	
	
	@FindBy(how=How.XPATH,using="//button[contains(text(),'Clear completed')]")
	public WebElement buttonClearCompleted;		
	/** Public Methods  **/
	
	public WebDriver getDriver() {
		return this.driver;
	}
	
	public void addTask(String task) {
		log.info(task);
		inputBox.click();
		inputBox.sendKeys(task);
		inputBox.sendKeys(Keys.ENTER);
		log.info(task);
	}
	
	public void taskName(String task) throws IOException {
		log.info(task);
		driver.findElement(By.xpath("//li[@class='todo']/div[@class='view']/label[text()='"+task+"']"));
	}
	
	public void deletedTaskName(String task) throws IOException {
		log.info(task);
		driver.findElement(By.xpath("//li[@class='todo']/div[@class='view']/label[text()='"+task+"']")).isDisplayed();
	}
	public void completedTaskName(String task) throws IOException {
		log.info(task);
		driver.findElement(By.xpath("//li[@class='todo completed']/div[@class='view']/label[text()='"+task+"']")).isDisplayed();
	}
	
	public void greenTickMarkTask(String task) {
		log.info(task);
		driver.findElement(By.xpath("//li[@class='todo completed']/div[@class='view']/input/following-sibling::label[contains(text(),'"+task+"')]")).isDisplayed()
		;
	}
	
	public void emptyCircleNextToTask(String task) {
		driver.findElement(
				By.xpath(
						"//li[@class='todo']/div[@class='view']/input/following-sibling::label[contains(text(),'"+task+"')]")).isDisplayed()
		;
	}
	
	public void clickOnEmptyCircle(String task) throws InterruptedException {
		driver.findElement(
				By.xpath(
						"//li[@class='todo']/div[@class='view']/label[contains(text(),'"+task+"')]/preceding-sibling::input")).click();
		;
		Thread.sleep(2000);
	}
	
	public void clickOnGreenCircle(String task) throws InterruptedException {
		driver.findElement(
				By.xpath(
						"//li[@class='todo completed']/div[@class='view']/label[contains(text(),'"+task+"')]/preceding-sibling::input")).click();
		;
		Thread.sleep(2000);
	}	
	
	public void ClearCompletedExists(String buttonName) {
		log.info(buttonName);
		driver.findElement(By.xpath("//button[contains(text(),'"+buttonName+"')]")).isDisplayed();
	}
	
	public void ClearCompleted(String buttonName) {
		log.info(buttonName);
		driver.findElement(By.xpath("//button[contains(text(),'"+buttonName+"')]")).click();
	}
	
	public void deleteTask(String taskName) {
		log.info(taskName);
		driver.findElement(By.xpath("//div[@class='view']/label[contains(text(),'"+taskName+"')]/following-sibling::button")).click();
	}
	
	public void filterLink(String linkText) {
		log.info(linkText);
		driver.findElement(By.xpath("//a[contains(text(),'"+linkText+"')]")).isDisplayed();
	}
	
	public void itemsLeft(String items) {
		log.info(items);
		driver.findElement(By.xpath("//span[@class='todo-count']/strong")).isDisplayed();
	}
}
