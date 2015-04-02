package selenium.my.test;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumSample {
	
	@Test
	public void testBaiduPage(){
//		System.setProperty("webdriver.firefox.bin", "C:/Program Files (x86)/Mozilla Firefox/firefox.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.baidu.com");
		
		WebElement searchBox = driver.findElement(By.id("kw"));
		searchBox.sendKeys("Apple");;
		
		WebElement submitButton = driver.findElement(By.id("su"));
		submitButton.click();
		
		
		
	}
}
