package TestFile;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import Utils.BaseClass;
import Utils.BaseFIle;
import PageFile.KnowMorePage;

public class KnowMoreTest extends BaseFIle {
	
	public final static Logger logger = Logger.getLogger(cancelTicketTest.class);

	@Test
	public void KnowMore() throws Throwable {

		String status = reader.getRowTestData("Sheet1", "KnowMore").get("TestStatus");

		if (status.toLowerCase().trim().equals("yes")) {
			
			logger.info("*************************Know More Test Starts Here********************");

			driverInitialize(prop.getProperty("browser"),prop.getProperty("browserType"));

			KnowMorePage more = new KnowMorePage(driver);
			extentTest = extent.startTest("Know More Test");
			more.clickSignin();

			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			String email = reader.getRowTestData("Sheet1", "KnowMore").get("TicketNumber");//taking the ticket number from the excel sheet
			more.EnterTicketNumber(email);

			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			String ticket = reader.getRowTestData("Sheet1", "KnowMore").get("Email");//taking email from excel file
			more.enterEmail(ticket);

			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			more.clickSubmitBtm();

			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			Thread.sleep(5000);
			Assert.assertTrue(driver.getTitle().contains("bus"));//no details of ticket is available
			
			logger.info("*************************Know More Test Ends Here********************");
			
			Thread.sleep(5000);
		} else {

			extentTest = extent.startTest("Know More Funtionality  ");
			throw new SkipException("Know More Funtionality  Test Case has been Skipped");
		}
	}
}