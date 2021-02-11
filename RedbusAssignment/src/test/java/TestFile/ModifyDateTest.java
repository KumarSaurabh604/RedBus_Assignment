package TestFile;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import PageFile.SearchBus_Page;
import PageFile.ModifyDatePage;
import Utils.BaseFIle;

public class ModifyDateTest extends BaseFIle {
	
	public final static Logger logger = Logger.getLogger(cancelTicketTest.class);
	
	@Test
	public void modifyPage() throws Throwable {

		String status = reader.getRowTestData("Sheet1", "modifyPage").get("TestStatus");

		if (status.toLowerCase().trim().equals("yes")) {
			
			logger.info("*************************Modify Page Test Starts Here********************");

			driverInitialize(prop.getProperty("browser"),prop.getProperty("browserType"));

			SearchBus_Page obj = new SearchBus_Page(driver);
//			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			extentTest = extent.startTest("Search Bus Test ");

			String Tolocation = reader.getRowTestData("Sheet1", "modifyPage").get("ToLocation");
			String Fromlocation = reader.getRowTestData("Sheet1", "modifyPage").get("FromLocation");
			Thread.sleep(5000);

			obj.sourceLocation(Tolocation);//taking ToLocation from excel
			obj.destinationLocation(Fromlocation);// taking FromLocation from excel
			
			Thread.sleep(2000);
			
			obj.clickCalender();
			obj.chooseDate();
			obj.clickSearchBtn();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			Thread.sleep(5000);

			ModifyDatePage page = new ModifyDatePage(driver);
			page.modify();
			Thread.sleep(5000);
			page.switchButton();
			Thread.sleep(5000);
			page.searchBtn();
			Thread.sleep(5000);
			Assert.assertTrue(driver.getTitle().contains("Search Bus Tickets"));
			
			logger.info("*************************Modify page Test Ends Here********************");

		} else {

			extentTest = extent.startTest("Modify Date Funtionality  ");
			throw new SkipException("Modify Date Funtionality Test Case has been Skipped");
		}
	}

}
