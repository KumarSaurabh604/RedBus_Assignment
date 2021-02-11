package TestFile;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import PageFile.rPoolPage;
import Utils.BaseFIle;

public class rPoolTest extends BaseFIle {
	
	public final static Logger logger = Logger.getLogger(cancelTicketTest.class);

	@Test
	public void carPool() throws Throwable {

		String status = reader.getRowTestData("Sheet1", "carPool").get("TestStatus");

		if (status.toLowerCase().trim().equals("yes")) {
			
			logger.info("*************************rPool Test Starts Here********************");

			driverInitialize(prop.getProperty("browser"),prop.getProperty("browserType"));

			rPoolPage obj = new rPoolPage(driver);
			extentTest = extent.startTest("rPool Test ");

			Thread.sleep(5000);
			obj.findRide();
			Thread.sleep(5000);
			obj.offerRide();
			Assert.assertTrue(driver
					.findElement(
							By.xpath("//*[@id='howItWorks']/div/div/div[2]/div[5]/div/div/div[1]/ul/li[1]/span[2]"))
					.isDisplayed());
			Thread.sleep(5000);
			
			logger.info("*************************rPool Test Ends Here********************");

		} else {

			extentTest = extent.startTest("rPool Funtionality  ");
			throw new SkipException("rPool Funtionality  Test Case has been Skipped");
		}
	}

}
