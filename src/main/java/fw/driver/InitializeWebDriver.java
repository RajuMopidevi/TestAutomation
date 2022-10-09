package fw.driver;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import fw.configReader.PropertyFileReader;
import fw.configuration.browser.BrowserType;
import fw.configuration.browser.ChromeBrowser;
import fw.configuration.browser.FirefoxBrowser;
import fw.exception.NoSutiableDriverFoundException;
import fw.driver.actions.GenericActions;
import fw.driver.actions.LoggerActions;
import fw.settings.ObjectRepo;

import io.cucumber.java.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;

/**
 * @author Sudharsan Raju
 *
 */

public class InitializeWebDriver {

	private Logger oLog = LoggerActions.getLogger(InitializeWebDriver.class);

	public InitializeWebDriver(PropertyFileReader reader) {
		ObjectRepo.reader = reader;
	}

	public WebDriver standAloneStepUp(BrowserType bType) throws Exception {
		try {
			oLog.info(bType);

			switch (bType) {

			case Chrome:
				ChromeBrowser chrome = ChromeBrowser.class.newInstance();
				return chrome.getChromeDriver(chrome.getChromeCapabilities());

			case Firefox:
				FirefoxBrowser firefox = FirefoxBrowser.class.newInstance();
				return firefox.getFirefoxDriver(firefox
						.getFirefoxCapabilities());

			default:
				throw new NoSutiableDriverFoundException(" Driver Not Found : "
						+ ObjectRepo.reader.getBrowser());
			}
		} catch (Exception e) {
			oLog.equals(e);
			throw e;
		}
	}
	
	@Before("~@chrome")
	public void before() throws Exception {
		setUpDriver(ObjectRepo.reader.getBrowser());
		oLog.info(ObjectRepo.reader.getBrowser());
	}

	@After("~@chrome")
	public void after(Scenario scenario) throws Exception {
		tearDownDriver(scenario);
		oLog.info(" Scenario Executed - "+scenario.getName());
	}
	
	@Before(order=4,value="@iexplorer")
	public void beforeExplorer() throws Exception {
		setUpDriver(BrowserType.Iexplorer);
		oLog.info(BrowserType.Iexplorer);
	}

	@After(order=4,value="@iexplorer")
	public void afterExplorer(Scenario scenario) throws Exception {
		tearDownDriver(scenario);
		oLog.info("");
	}

	@Before(order=3,value="@firefox")
	public void beforeFirefox() throws Exception {
		setUpDriver(BrowserType.Firefox);
		oLog.info(BrowserType.Firefox);
	}

	@After(order=3,value="@firefox")
	public void afterFirefox(Scenario scenario) throws Exception {
		tearDownDriver(scenario);
		oLog.info("");
	}

	@Before(order=2,value="@chrome")
	public void beforeChrome() throws Exception {
		setUpDriver(BrowserType.Chrome);
		oLog.info(BrowserType.Chrome);
	}

	@After(order=2,value="@chrome")
	public void afterChrome(Scenario scenario) throws Exception {
		tearDownDriver(scenario);
		oLog.info("");
	}

	@Before(order=1,value="@phantomjs")
	public void beforePhantomjs() throws Exception {
		setUpDriver(BrowserType.PhantomJs);
		oLog.info(BrowserType.PhantomJs);
	}

	@After(order=1,value="@phantomjs")
	public void afterPhantomjs(Scenario scenario) throws Exception {
		tearDownDriver(scenario);
		oLog.info("");
	}

	public void setUpDriver(BrowserType bType) throws Exception {
		ObjectRepo.setDriver(standAloneStepUp(bType));
		oLog.debug("InitializeWebDrive : " + ObjectRepo.getDriver().hashCode());
		ObjectRepo.getDriver()
				.manage()
				.timeouts()
				.pageLoadTimeout(ObjectRepo.reader.getPageLoadTimeOut(),
						TimeUnit.SECONDS);
		ObjectRepo.getDriver()
				.manage()
				.timeouts()
				.implicitlyWait(ObjectRepo.reader.getImplicitWait(),
						TimeUnit.SECONDS);
		ObjectRepo.getDriver().manage().window().maximize();

	}

	public void tearDownDriver(Scenario scenario) throws Exception {
		
		try {
			if (ObjectRepo.getDriver() != null) {
				
				if(scenario.isFailed())
					scenario.log(new GenericActions(ObjectRepo.getDriver()).takeScreenShot(scenario.getName()));
				
				ObjectRepo.getDriver().quit();
				ObjectRepo.reader = null;
				ObjectRepo.setDriver(null);;
				oLog.info("Shutting Down the driver");
			}
		} catch (Exception e) {
			oLog.error(e);
			throw e;
		}
	}

}
