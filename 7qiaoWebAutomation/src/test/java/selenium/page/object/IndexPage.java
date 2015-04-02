package selenium.page.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IndexPage {

	WebDriver driver;
	WebElement loginBtn;
	WebElement emailInput;
	WebElement passwordInput;
	WebElement loginConfirm;
	WebElement teachHref;
	WebElement userHeadImage;
	WebElement userHeadImage2;
	WebElement lessionList;

	public IndexPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getLoginBtn() {
		loginBtn = driver.findElement(By.cssSelector("a[headerid='btnLoginModal1'][href='/login.dhtml#login']"));
		return loginBtn;
	}

	public WebElement getInputEmail() {
		emailInput = driver.findElement(By.cssSelector("input[type='text'][name='email']"));
		return emailInput;
	}

	public WebElement getInputPassWord() {
		passwordInput = driver.findElement(By
				.xpath("//input[@type='password' and @name='password']"));
		return passwordInput;
	}

	public WebElement getLoginConfirm() {
		loginConfirm = driver.findElement(By
				.xpath("//a[@class='btn btn-block' and @role='button']"));
		return loginConfirm;
	}

	public WebElement getTeachHref() {
		loginConfirm = driver
				.findElement(By.xpath("//a[@href='/teach.dhtml']"));
		return loginConfirm;
	}

	public WebElement getUserHeadImage() {
//		userHeadImage = driver.findElement(By.id("myDropDown_header"));
		
		userHeadImage = driver.findElement(By.cssSelector("img[headerid='userHeadImage'][class='_headimage img-circle']"));
		return userHeadImage;
	}
	
	public WebElement getUserHeadImage2(){
		userHeadImage2 = driver.findElement(By.xpath("/html/body/div[1]/div/ul[2]/li/a"));
		return userHeadImage2;
	}

	public WebElement getLessonList() {
		lessionList = driver.findElement(By
				.xpath("//a[@href='/teach.dhtml']"));
		return lessionList;
	}

}
