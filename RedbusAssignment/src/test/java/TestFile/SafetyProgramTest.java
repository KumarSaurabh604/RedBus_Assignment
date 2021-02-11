package TestFile;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import Utils.BaseFIle;

import PageFile.SafetyProgramPage;

public class SafetyProgramTest extends BaseFIle {

	public final static Logger logger = Logger.getLogger(cancelTicketTest.class);

	@Test
	public void safetyProgram() throws Throwable {

		String status = reader.getRowTestData("Sheet1", "safetyProgram").get("TestStatus");

		if (status.toLowerCase().trim().equals("yes")) {
			
			logger.info("*************************Safety Program Test Starts Here********************");

//			BaseFIle obj = new BaseFIle();
			driverInitialize(prop.getProperty("browser"),prop.getProperty("browserType"));
			extentTest = extent.startTest("Safety Program Test ");

			SafetyProgramPage safety = new SafetyProgramPage(driver);
			safety.ClickOnSafetyKnowMore();
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			
			safety.ClickOnViewSafetyBtn();
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			Assert.assertTrue(
					driver.findElement(By.xpath("//*[@id=\"rh_header\"]/div/div/div[2]/div[3]")).isDisplayed());
			
			logger.info("*************************Safety Program Test Ends Here********************");

		} else {

			extentTest = extent.startTest("Safety Program Funtionality  ");
			throw new SkipException("Safety Program Funtionality  Test Case has been Skipped");
		}
	}
}