package selenium.tc.teater;



import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import selenium.browser.pojo.BrowserFactory;
import selenium.page.object.IndexPage;
import selenium.page.object.MyTeachCourse;
import selenium.project.util.PropertiesReader;

/**
 * 测试用例名称：Diandi_teach_center_001
 * 前提条件：
 *     1.没有制作中的课程。  
 *     2.不登录用户
 *     3.选着一个用户账号为教师账号
 *     
 * 步骤：
 *     1.用户在主页面登录
 *     2.用户登录后，进入教师页面
 *     3.创建新的空白课程
 *     4.查看空白课程是否制作成功
 */

public class Diandi_teach_center_001 {
	static BrowserFactory browser = new BrowserFactory("chrome");
	static IndexPage indexPage = new IndexPage(browser.getChromeDriver());
	static MyTeachCourse course = new MyTeachCourse(browser.getChromeDriver());
	static PropertiesReader reader = new PropertiesReader();
	static Logger logger = Logger.getLogger(Diandi_teach_center_001.class);
	static WebDriverWait wait = new WebDriverWait(browser.getChromeDriver(), 20);
	
	public void testUserLogin() {
		// User login process
		logger.info("Test user login");
		logger.info("Navigate to the webaddreass");
		browser.getChromeDriver().get(reader.getPropertiesName("webaddress"));
		logger.info("Login step 1: Click 'Login'");
		browser.getChromeDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(indexPage.getLoginBtn()));
		indexPage.getLoginBtn().click();
		logger.info("Login step 2: Enter emaill address and password");
		browser.getChromeDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.visibilityOf(indexPage.getInputEmail()));
		indexPage.getInputEmail()
				.sendKeys(reader.getPropertiesName("username"));
		indexPage.getInputPassWord().sendKeys(
				reader.getPropertiesName("password"));
		logger.info("Login step 3: Click confirm to login");
		indexPage.getLoginConfirm().click();
	}
	
	
	@Test
	public void testCreateCause() {
		try {
			// User login process
			testUserLogin();

			// Go to 'My Teach page'
			logger.info("Step 1: Create new course");
			logger.info("Step 2: Click on My image");
			wait.until(ExpectedConditions.elementToBeClickable(indexPage
					.getUserHeadImage()));
			indexPage.getUserHeadImage().click();
			logger.info("Step 3: Click on My course");
			indexPage.getLessonList().click();
			logger.info("Step 4: Check 'My teach page'");
			course.checkPageTitile();
			
			// Create course
			logger.info("Step 5-1: Click on 'Create course'");
			wait.until(ExpectedConditions.visibilityOf(course.getAddBtn()));
			course.getAddBtn().click();
			logger.info("Step 5-2: Click on '创建兴趣课程'");
			wait.until(ExpectedConditions.visibilityOf(course.getPersonnalCouse()));
			course.getPersonnalCouse().click();
			logger.info("Step 6: Close '制作课程窗口' ");
			wait.until(ExpectedConditions.elementToBeClickable(course.getCloseBtn()));
			course.getCloseBtn().click();

			// Go back to 'My Teach page'
			logger.info("Step 7: Back to My course page");
			browser.getChromeDriver().navigate().back();
			logger.info("Step 8 : Check 'My teach page'");
			course.checkPageTitile();
			logger.info("Step 9-1 : Check '制作中 1' status");
			course.checkVideoCreateNum();
			logger.info("Step 9-2 : Check '课程名字' status");
			course.checkDefaultCouseName();
			logger.info("Step 9-3 : Check date status");
			course.CheckCourseCreateDate();
						
			//RollBack
			logger.info("Step 10 : Rollback to Delete course");
			wait.until(ExpectedConditions.elementToBeClickable(course.deleteVideo()));
			course.deleteVideo().click();
			Alert javascritpConfirmAlert = browser.getChromeDriver().switchTo().alert();
			javascritpConfirmAlert.accept();
			logger.info("Step 11 : Check '制作中0' status");
			browser.getChromeDriver().navigate().refresh();
			course.checkVideoDeleteStatus();
			
			//Test result
			logger.info("Test result: Test case Diandi_teach_center_001 success");
		} catch (Exception e) {
			logger.error("Test result: Test case Diandi_teach_center_001 fail");
			System.out.println(e);
			Assert.assertTrue(false);  
		} finally{
			browser.getChromeDriver().quit();
		}
	}
	
	

}
