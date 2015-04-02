package selenium.my.test;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class test1 {
	
	
	@Test
	public void testBaiduSearch(){
		
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.baidu.com");
		WebElement element = driver.findElement(By.id("kw"));
		element.sendKeys("����");
		WebElement element2 = driver.findElement(By.id("su"));
		element2.click();
		driver.close();
		
		
		
		
	}
	
	@Test
	public void testIEBaiduSearch(){
		System.setProperty("webdriver.ie.driver",
				"C:\\SeleniumTool\\IEDriverServer.exe");
		DesiredCapabilities capab = DesiredCapabilities.internetExplorer();
		capab.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION,
				true);
		WebDriver driver = new InternetExplorerDriver(capab);
		driver.get("http://www.baidu.com");
		WebElement element = driver.findElement(By.id("kw"));
		element.sendKeys("����");
		WebElement element2 = driver.findElement(By.id("su"));
		element2.click();
		driver.close();
	}
	
	@Test
	public void testChromeBaiduSearch(){
		System.setProperty("webdriver.chrome.driver", "D:\\Program Files (x86)\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.baidu.com");
		WebElement element = driver.findElement(By.id("kw"));
		element.sendKeys("����");
		WebElement element2 = driver.findElement(By.id("su"));
		element2.click();
		driver.close();
	}
}
