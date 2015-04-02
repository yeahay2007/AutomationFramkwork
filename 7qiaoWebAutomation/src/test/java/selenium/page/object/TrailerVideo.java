package selenium.page.object;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


/*
 * This page object is basic on http://192.168.4.10:9090/v/2001212
 */

public class TrailerVideo {
	WebDriver driver;
	WebElement joinCourse;
	public WebElement emailInput;
	public WebElement passwordInput;
	WebElement replyElement;
	WebElement loginBtn;
	WebElement userName;

	public TrailerVideo(WebDriver driver) {
		this.driver = driver;
	}

	@Test
	public void verifyJoinCourse() {
		System.out.println(joinCourse.getText() + " " + "出现");
		Assert.assertEquals("加入学习", joinCourse.getText());
	}

	public WebElement getJoinCourse() {
		joinCourse = driver.findElement(By.id("btnStudy"));
		return joinCourse;
	}

	public WebElement getInputEmail() {
//		emailInput = driver.findElement(By
//				.xpath("//input[@type='text' and @name='email']"));
		emailInput = driver.findElement(By.cssSelector("input[type='text'][name='email']"));
		return emailInput;
	}

	public WebElement getInputPassWord() {
		passwordInput = driver.findElement(By
				.xpath("//input[@type='password' and @name='password']"));
		return passwordInput;
	}

	public WebElement getReply() {
		replyElement = driver.findElement(By.xpath("//textarea[@id='commentContent' and @placeholder='请输入内容']"));
		return replyElement;
	}
	
	public WebElement getLoginBtn(){
		loginBtn = driver.findElement(By
				.xpath("//a[@class='btn btn-block' and @role='button']"));
		return loginBtn;
	}
	
	public WebElement getUserName(){
		userName = driver.findElement(By.id("comment_userName"));
		return userName;
	}

}
