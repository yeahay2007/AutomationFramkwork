package selenium.my.test;


//import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
//import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
//import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Untitled {
	  private WebDriver driver;
	  private String baseUrl;
//	  private boolean acceptNextAlert = true;
//	  private StringBuffer verificationErrors = new StringBuffer();

	  @Before
	  public void setUp() throws Exception {
	    driver = new FirefoxDriver();
	    baseUrl = "http://www.7qiao.com/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }

	  @Test
	  public void testUntitled() throws Exception {
	    driver.get(baseUrl + "/");
	    driver.findElement(By.id("btnLoginModal1")).click();
	    driver.findElement(By.id("btnLoginModal1")).click();
	    driver.findElement(By.id("_l_ipt_email")).clear();
	    driver.findElement(By.id("_l_ipt_email")).sendKeys("7qiao@zhggp.com");
	    driver.findElement(By.id("_l_ipt_password")).clear();
	    driver.findElement(By.id("_l_ipt_password")).sendKeys("admin123");
	    driver.findElement(By.id("btn_to_login")).click();
	    driver.findElement(By.id("userHeadImage")).click();
	    driver.findElement(By.linkText("��������")).click();
	    driver.findElement(By.id("userHeadImage")).click();
	    driver.findElement(By.linkText("�ҵĽ�ѧ")).click();
	    driver.findElement(By.id("btnAdd")).click();
	    driver.findElement(By.cssSelector("button.close")).click();
	    
	    driver.findElement(By.linkText("��ѧ")).click();
	  }

	  @After
	  public void tearDown() throws Exception {
	    driver.quit();
//	    String verificationErrorString = verificationErrors.toString();
//	    if (!"".equals(verificationErrorString)) {
//	      fail(verificationErrorString);
//	    }
	  }

//	  private boolean isElementPresent(By by) {
//	    try {
//	      driver.findElement(by);
//	      return true;
//	    } catch (NoSuchElementException e) {
//	      return false;
//	    }
//	  }
//
//	  private boolean isAlertPresent() {
//	    try {
//	      driver.switchTo().alert();
//	      return true;
//	    } catch (NoAlertPresentException e) {
//	      return false;
//	    }
//	  }

//	  private String closeAlertAndGetItsText() {
//	    try {
//	      Alert alert = driver.switchTo().alert();
//	      String alertText = alert.getText();
//	      if (acceptNextAlert) {
//	        alert.accept();
//	      } else {
//	        alert.dismiss();
//	      }
//	      return alertText;
//	    } finally {
//	      acceptNextAlert = true;
//	    }
//	  }
	}


