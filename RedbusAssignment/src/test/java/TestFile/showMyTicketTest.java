package TestFile;

import org.apache.log4j.Logger;
import org.testng.SkipException;
import org.testng.annotations.Test;

import PageFile.KnowMorePage;
import PageFile.cancelTicketPage;
import PageFile.showMyTicketPage;
import Utils.BaseClass;
import Utils.BaseFIle;

public class showMyTicketTest extends BaseFIle {
	
	public final static Logger logger = Logger.getLogger(cancelTicketTest.class);

	@Test
	public void showMyTicket() throws Throwable {

		String status = reader.getRowTestData("Sheet1", "showMyTicket").get("TestStatus");

		if (status.toLowerCase().trim().equals("yes")) {
			
			logger.info("*************************Shwo My Ticket Test Starts Here********************");
			
			driverInitialize(prop.getProperty("browser"),prop.getProperty("browserType"));

			cancelTicketPage can = new cancelTicketPage(driver);
			extentTest = extent.startTest("Cancel Ticket Funtionality ");
			Thread.sleep(5000);
			can.ClickOnManageIcon();
			showMyTicketPage show = new showMyTicketPage(driver);
			show.ShowMyTicketBtn();
			
			Thread.sleep(2000);
			String ticket = reader.getRowTestData("Sheet1", "showMyTicket").get("TicketNumber");
			show.EnterTicketNo(ticket);//ticket number from excel sheet
			
			Thread.sleep(2000);
			String email = reader.getRowTestData("Sheet1", "showMyTicket").get("Email");
			show.EnterEmailId(email);//email from excel sheet
			
			Thread.sleep(2000);
			show.ClickOnSearchBtn();
			Thread.sleep(2000);
			KnowMorePage obj1 = new KnowMorePage(driver);
			obj1.RedBusLogoIsPresent();// Applying Assertion that redbus logo is present
			
			logger.info("*************************Show My Ticket Test Ends Here********************");

		} else {

			extentTest = extent.startTest("Show Ticket Funtionality  ");
			throw new SkipException("Show Ticket Funtionality  Test Case has been Skipped");
		}
	}
}