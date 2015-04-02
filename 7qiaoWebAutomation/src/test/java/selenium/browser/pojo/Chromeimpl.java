package selenium.browser.pojo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Chromeimpl implements Chrome{

	WebDriver driver;
	
	public Chromeimpl(){
		System.setProperty("webdriver.chrome.driver", "D:\\Program Files (x86)\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	public WebDriver getChrome() {
		return driver;
	}
	
}
