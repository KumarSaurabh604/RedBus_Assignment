package TestFile;

import org.apache.log4j.Logger;
import org.testng.SkipException;
import org.testng.annotations.Test;

import PageFile.SignIn_Page;
import PageFile.WalletPage;
import Utils.BaseFIle;

public class WalletTest extends BaseFIle {
	
	public final static Logger logger = Logger.getLogger(cancelTicketTest.class);

	@Test
	public void WalletBalanceCheck() throws Throwable {

		String status = reader.getRowTestData("Sheet1", "WalletBalanceCheck").get("TestStatus");

		if (status.toLowerCase().trim().equals("yes")) {
			
			logger.info("************************Wallet Balance Check Test Starts Here********************");

			driverInitialize(prop.getProperty("browser"),prop.getProperty("browserType"));

			SignIn_Page obj2 = new SignIn_Page(driver);
			extentTest = extent.startTest(" Wallet Money Checking Funtionality");

			Thread.sleep(5000);
			obj2.id();
			Thread.sleep(5000);
			obj2.signIn();
			Thread.sleep(5000);
			obj2.googlebtn();
			Thread.sleep(5000);

			String user_id = reader.getRowTestData("Sheet1", "WalletBalanceCheck").get("Email");
			String pass = reader.getRowTestData("Sheet1", "WalletBalanceCheck").get("Password");

			obj2.SwitchWindow(user_id, pass);
			Thread.sleep(5000);

			WalletPage obj = new WalletPage(driver);
			obj.ClickOnProfileBtn();
			Thread.sleep(5000);
			obj.ClickOnWalletBtN();
			Thread.sleep(5000);
			
			logger.info("*************************Wallet Balance Check Test Ends Here********************");

		} else {

			extentTest = extent.startTest("Wallet Balance Check Funtionality  ");
			throw new SkipException("Wallet Balance Check Funtionality  Test Case has been Skipped");
		}

	}

}
