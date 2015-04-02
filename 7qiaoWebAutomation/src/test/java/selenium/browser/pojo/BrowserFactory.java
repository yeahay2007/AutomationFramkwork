package selenium.browser.pojo;

import org.openqa.selenium.WebDriver;

public class BrowserFactory {
	IE ie;
	Firefox firefox;
	Chrome chrome;

	public BrowserFactory(String type) {
		if (type.equalsIgnoreCase("ie")) {
			ie = new IEimpl();
		} else if (type.equalsIgnoreCase("firefox")) {
			firefox = new Firefoximpl();
		} else {
			chrome = new Chromeimpl();
		}
	}

	public WebDriver getIEDriver() {
		return ie.getIE();
	}

	public WebDriver getFirefoxDriver() {
		return firefox.getFirefox();
	}

	public WebDriver getChromeDriver() {
		return chrome.getChrome();
	}
}
