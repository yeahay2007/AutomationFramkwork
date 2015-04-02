package selenium.browser.pojo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class IEimpl implements IE {

	DesiredCapabilities capab;
	WebDriver driver;

	public IEimpl() {
		System.setProperty("webdriver.ie.driver",
				"C:\\SeleniumTool\\IEDriverServer.exe");
		capab = DesiredCapabilities.internetExplorer();
		capab.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION,
				true);
		driver = new InternetExplorerDriver(capab);
	}

	public WebDriver getIE() {
		return driver;
	}

}
