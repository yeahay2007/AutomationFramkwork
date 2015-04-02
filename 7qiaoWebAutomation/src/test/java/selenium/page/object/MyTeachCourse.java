package selenium.page.object;



import java.text.SimpleDateFormat;
import java.util.Date;




import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class MyTeachCourse {

	WebDriver driver;
	WebElement addBtn;
	WebElement closBtn;
	WebElement deleveCourse;
	WebElement courseWorkingNum;
	WebElement personnalCouse;
	JavascriptExecutor jse = (JavascriptExecutor)driver;  

	public MyTeachCourse(WebDriver driver) {
		this.driver = driver;
	}

	@Test
	public void checkPageTitile() {
		System.out.println(driver.getTitle());
		Assert.assertEquals("我的教学-七巧", driver.getTitle());
	}

	public WebElement getAddBtn() {
		addBtn = driver.findElement(By.id("btnFirmAdd"));
		return addBtn;
	}
	
	public WebElement getPersonnalCouse(){
		personnalCouse = driver.findElement(By.cssSelector("a[href='/buildLesson.dhtml?privflag=0'][class='interest-lesson']"));
		return personnalCouse;
	}

	public WebElement getCloseBtn() {
		closBtn = driver.findElement(By
				.xpath("//button[@class='close' and @data-dismiss='modal']"));
		return closBtn;
	}
	
	@Test
	public void checkVideoCreateNum(){
		System.out.println(driver.findElement(By.id("tabTitle_working")).getText().contains("制作中(1)"));
		Assert.assertEquals("制作中(1)", driver.findElement(By.id("tabTitle_working")).getText());
	}
	
	
	public String courseWorkingNumber(){
		courseWorkingNum = driver.findElement(By.id("tabTitle_working"));
		String num = courseWorkingNum.getText();
		return num;
	}
	
	@Test
	public void checkVideoDeleteStatus(){
		System.out.println(driver.findElement(By.id("tabTitle_working")).getText());
		Assert.assertEquals("制作中(0)", driver.findElement(By.id("tabTitle_working")).getText());
		
	}
	
	@Test
	public void checkDefaultCouseName(){
		System.out.println(driver.findElement(By.xpath("//*[@id='workingList']/div[1]/div/div/div/div[2]/span[1]/a")).getText());
		Assert.assertEquals("未命名", driver.findElement(By.xpath("//*[@id='workingList']/div[1]/div/div/div/div[2]/span[1]/a")).getText());
	}
	
	@Test
	public void CheckCourseCreateDate(){
		System.out.println(driver.findElement(By.className("teach-alter")).getText());
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");  
        String currentDate = sdf.format(d);
        Assert.assertEquals("最后修改于"+currentDate, driver.findElement(By.className("teach-alter")).getText());
	}
	
	public WebElement deleteVideo(){
		deleveCourse = driver.findElement(By.className("delete-course"));
		return deleveCourse;
	}
	
}
