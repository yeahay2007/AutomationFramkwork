package selenium.browser.pojo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Firefoximpl implements Firefox {

	WebDriver driver;
	
	public Firefoximpl(){
		driver = new FirefoxDriver();
	}
	
	public WebDriver getFirefox() {
		return driver;
	}
	
}
