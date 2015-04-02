package selenium.tc.video;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import selenium.browser.pojo.BrowserFactory;
import selenium.page.object.NoTrailerVideo;
import selenium.project.util.PropertiesReader;


/**
 * 测试用例名称：Diandi_video_display_001
 * 前提条件：
 *     1.视频没有预告 
 *     2.不登录用户
 * 步骤：
 *     1.进入没有预告的视频
 *     2.视频窗口弹出加入学习窗口
 *     3.点击 加入学习
 */

public class Diandi_video_display_001 {
	static BrowserFactory browser = new BrowserFactory("chrome");
	static PropertiesReader reader = new PropertiesReader();
	static Logger logger = Logger.getLogger(Diandi_video_display_001.class);
	static NoTrailerVideo noTrailerVideo = new NoTrailerVideo(
			browser.getChromeDriver());
	static WebDriverWait wait = new WebDriverWait(browser.getChromeDriver(), 20);

	@Test
	public void displayJoinStudyForNoTrailerVideo() {
		try {
			logger.info("Step 1: 打开一个没有预告的视频");
			browser.getChromeDriver().get(
					reader.getPropertiesName("noTrailerVideo"));
			logger.info("Step 2: 验证视频时候出现加入学习");
			wait.until(ExpectedConditions.elementToBeClickable(noTrailerVideo
					.getJoinCourse()));
			noTrailerVideo.verifyJoinCourse();
			
			logger.info("Step 3: 点击加入学习");
			noTrailerVideo.getJoinCourse().click();
			logger.info("Step 4: 输入用户和密码");
			browser.getChromeDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			wait.until(ExpectedConditions.visibilityOf(noTrailerVideo
					.getInputEmail()));		
			noTrailerVideo.getInputEmail().sendKeys(
					reader.getPropertiesName("username"));
			noTrailerVideo.getInputPassWord().sendKeys(
					reader.getPropertiesName("password"));
			logger.info("Step 5: 点击登录");
			noTrailerVideo.getLoginBtn().click();
			logger.info("Step 6: 验证用户登录成功");
			Assert.assertEquals(reader.getPropertiesName("name"), noTrailerVideo.getUserName().getText());
			logger.info("Test result: Test case Diandi_video_display_001 success");
		} catch (Exception e) {
			logger.info("Test result: Test case Diandi_video_display_001 failed");
			System.out.println(e);
			assertTrue(false);
		} finally {
			 browser.getChromeDriver().quit();
		}

	}

}
