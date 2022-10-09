package fw.interfaces;

import fw.configuration.browser.BrowserType;


public interface IconfigReader {
	public String getWebsite();
	public int getPageLoadTimeOut();
	public int getImplicitWait();
	public int getExplicitWait();
	public BrowserType getBrowser();
}
