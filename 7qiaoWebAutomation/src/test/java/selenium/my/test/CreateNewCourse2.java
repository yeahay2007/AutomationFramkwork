package selenium.my.test;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import selenium.browser.pojo.BrowserFactory;
import selenium.page.object.IndexPage;
import selenium.page.object.MyTeachCourse;
import selenium.project.util.PropertiesReader;


public class CreateNewCourse2 {
	static BrowserFactory browser = new BrowserFactory("chrome");
	static IndexPage indexPage = new IndexPage(browser.getChromeDriver());
	static MyTeachCourse course = new MyTeachCourse(browser.getChromeDriver());
	static PropertiesReader reader = new PropertiesReader();
	static Logger logger = Logger.getLogger(CreateNewCourse2.class);
	static WebDriverWait wait = new WebDriverWait(browser.getChromeDriver(), 20);

	public static void testUserLogin() {

		// User login process
		logger.info("Test user login");
		logger.info("Navigate to the webaddreass");
		browser.getChromeDriver().get(reader.getPropertiesName("webaddress"));
		browser.getChromeDriver().manage().window().maximize();
		logger.info("Click 'Login'");
		indexPage.getLoginBtn().click();
		logger.info("Enter emaill address and password");
		wait.until(ExpectedConditions.visibilityOf(indexPage.getInputEmail()));
		indexPage.getInputEmail()
				.sendKeys(reader.getPropertiesName("username"));
		indexPage.getInputPassWord().sendKeys(
				reader.getPropertiesName("password"));
		logger.info("Click confirm to login");
		indexPage.getLoginConfirm().click();

	}

	@Test
	public void testCreateCause() {

		// User login process
		testUserLogin();

		// Go to 'My Teach page'
		logger.info("Create new course");
		logger.info("Click on My image");
		wait.until(ExpectedConditions.visibilityOf(indexPage.getUserHeadImage()));
		indexPage.getUserHeadImage().click();
		logger.info("Click on My course");
		indexPage.getLessonList().click();
		logger.info("navigate to 'My teach' page");
		browser.getChromeDriver().getTitle();
		logger.info("Check 'My teach page' my page");
		course.checkPageTitile();

		// Create course
		logger.info("Click on 'Create course'");
		wait.until(ExpectedConditions.visibilityOf(course.getAddBtn()));
		course.getAddBtn().click();
	}

	@After
	public void tearDown() {
		browser.getChromeDriver().close();
	}
}
