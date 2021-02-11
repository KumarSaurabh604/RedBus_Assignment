package TestFile;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import PageFile.SearchBus_Page;
import PageFile.ModifyDatePage;
import Utils.BaseFIle;

public class SearchBus_Test extends BaseFIle {

	public final static Logger logger = Logger.getLogger(cancelTicketTest.class);

	@Test
	public void searchBuses() throws Throwable {

		String status = reader.getRowTestData("Sheet1", "searchBuses").get("TestStatus");

		if (status.toLowerCase().trim().equals("yes")) {
			
			logger.info("*************************Search Buses Test Starts Here********************");

			driverInitialize(prop.getProperty("browser"),prop.getProperty("browserType"));

			SearchBus_Page obj = new SearchBus_Page(driver);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			extentTest = extent.startTest("Search Bus Test ");
			Thread.sleep(5000);
			
			//values from excel sheet
			String source = reader.getRowTestData("Sheet1", "searchBuses").get("FromLocation");
			String destination = reader.getRowTestData("Sheet1", "searchBuses").get("ToLocation");

			obj.sourceLocation(source);
			obj.destinationLocation(destination);
			
			obj.clickCalender();
			obj.chooseDate();
			obj.clickSearchBtn();
			Assert.assertTrue(driver.getTitle().contains("Search Bus Tickets"));
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			Thread.sleep(5000);
			
			logger.info("*************************Search Buses Test Ends Here********************");

		} else {

			extentTest = extent.startTest("Search Bus Funtionality  ");
			throw new SkipException("Search Bus Funtionality  Test Case has been Skipped");
		}
	}
}
