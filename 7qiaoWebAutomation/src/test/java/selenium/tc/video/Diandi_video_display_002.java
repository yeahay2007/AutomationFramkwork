package selenium.tc.video;

import static org.junit.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import selenium.browser.pojo.BrowserFactory;
import selenium.page.object.TrailerVideo;
import selenium.project.util.PropertiesReader;

/**
 * 测试用例名称：Diandi_video_display_002
 * 前提条件：
 *     1.视频有预告 
 *     2.不登录用户
 * 步骤：
 *     1.进入有预告的视频
 *     2.预告播放完毕后，在视频窗口中出现加入学习
 *     
 */

public class Diandi_video_display_002 {
	static BrowserFactory browser = new BrowserFactory("chrome");
	static PropertiesReader reader = new PropertiesReader();
	static Logger logger = Logger.getLogger(Diandi_video_display_002.class);
	static TrailerVideo trailerVideo = new TrailerVideo(
			browser.getChromeDriver());
	static WebDriverWait wait = new WebDriverWait(browser.getChromeDriver(), 20);

	@Test
	public void displayJoinStudyForTrailerVideo() {
		try {
			logger.info("Step 1: 打开一个没有预告的视频");
			browser.getChromeDriver().get(
					reader.getPropertiesName("TrailerVideo"));

			logger.info("Step 2: 验证视频时候出现加入学习");
			wait.until(ExpectedConditions.elementToBeClickable(trailerVideo
					.getJoinCourse()));
			trailerVideo.verifyJoinCourse();

			logger.info("Step 3: 验证出现加入学习");
			Assert.assertEquals("加入学习", trailerVideo.getJoinCourse().getText());

			logger.info("Step 4: 点击加入学习");
			trailerVideo.getJoinCourse().click();

			logger.info("Step 5: 验证登录窗口出现");
			wait.until(ExpectedConditions.visibilityOf(trailerVideo.getLoginBtn()));
			Assert.assertEquals("登录", trailerVideo.getLoginBtn().getText());

			logger.info("Test result: Test case Diandi_video_display_002 success");
		} catch (Exception e) {
			logger.info("Test result: Test case Diandi_video_display_002 failed");
			System.out.println(e);
			assertTrue(false);
		} finally {
			browser.getChromeDriver().quit();
		}

	}

}
