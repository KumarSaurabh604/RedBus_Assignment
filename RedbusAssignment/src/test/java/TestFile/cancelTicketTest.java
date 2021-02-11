package TestFile;

import org.apache.log4j.Logger;
import org.testng.SkipException;
import org.testng.annotations.Test;
import PageFile.cancelTicketPage;
import Utils.BaseClass;
import Utils.BaseFIle;

public class cancelTicketTest extends BaseFIle {
	
	public final static Logger logger = Logger.getLogger(cancelTicketTest.class);
	
	@Test
	public void CancelTicketFuntion() throws Throwable {

		String status = reader.getRowTestData("Sheet1", "CancelTicketFuntion").get("TestStatus");//taking status from excel file
		if (status.toLowerCase().trim().equals("yes")) {
			
			logger.info("*************************Cancel Ticket Test Starts Here********************");
			
			driverInitialize(prop.getProperty("browser"),prop.getProperty("browserType"));

			cancelTicketPage can = new cancelTicketPage(driver);
			extentTest = extent.startTest("Cancel Ticket Funtionality ");
			Thread.sleep(5000);
			can.ClickOnManageIcon();
			Thread.sleep(2000);
			can.ClickOnCancelIcon();
			Thread.sleep(2000);
//		BaseClass obj = new BaseClass();

			String ticketNumber = reader.getRowTestData("Sheet1", "CancelTicketFuntion").get("TicketNumber");
			can.EnterTicketNumber(ticketNumber);
			Thread.sleep(2000);

			String email = reader.getRowTestData("Sheet1", "CancelTicketFuntion").get("Email");
			can.EnterEmailId(email);
			Thread.sleep(2000);
			can.ClickOnSelectPassenger();
			Thread.sleep(2000);
			can.WarningMsgIsDisplayed();// Applying Assertion
			logger.info("*************************Cancel Ticket Test Starts Here********************");
//			tearDown();
		} else {

			extentTest = extent.startTest("Cancel Ticket Funtion");
			throw new SkipException("Cancel Ticket Funtion Test Case has been Skipped");
		}
	}
}