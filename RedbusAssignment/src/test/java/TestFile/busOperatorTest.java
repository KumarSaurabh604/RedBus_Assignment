package TestFile;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import PageFile.busOperatorPage;
import Utils.BaseFIle;

//import CommonUtils.Base_Class;
//import Pages_RedBus.Bus_Operator_Page;

public class busOperatorTest extends BaseFIle {
	public final static Logger logger = Logger.getLogger(busOperatorTest.class);

	@Test
	public void searchBusesWithTopOperator() throws Throwable {
		
		//taking status from Excel file

		String status = reader.getRowTestData("Sheet1", "searchBusesWithTopOperator").get("TestStatus");
		if (status.toLowerCase().trim().equals("yes")) {
			
			//initializing the driver and its type
			driverInitialize(prop.getProperty("browser"), prop.getProperty("browserType"));

			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			busOperatorPage obj = new busOperatorPage(driver);
			extentTest = extent.startTest("SEARCH WITH OPERATOR");
			obj.clickOneTopOperator();
			obj.selectBusRoute();
			obj.clickCloseIcon();
			Assert.assertTrue(driver.getTitle().contains("Pune to Bangalore"));
		} else {
			extentTest = extent.startTest("SEARCH WITH OPERATOR");
			throw new SkipException("Search Buses With Top Operator, Test Case has been Skipped");
		}
		logger.info("Buses found successfully");
	}

	@Test
	public void findAllBusOperators() throws Throwable {

		//taking status from Excel file
		String status = reader.getRowTestData("Sheet1", "searchBusesWithTopOperator").get("TestStatus");
		if (status.toLowerCase().trim().equals("yes")) {
			driverInitialize(prop.getProperty("browser"), prop.getProperty("browserType"));

			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			busOperatorPage obj = new busOperatorPage(driver);
			extentTest = extent.startTest("FIND ALL BUS OPERATOR");
			obj.clickAllOperators();
			obj.switchWindow();
			Assert.assertTrue(driver.getTitle().contains("Abhimanyu"));
		} else {
			extentTest = extent.startTest("FIND ALL BUS OPERATOR");
			throw new SkipException("FIND ALL BUS OPERATOR, Test Case has been Skipped");
		}
		logger.info("Bus operators found successfully");
	}
}