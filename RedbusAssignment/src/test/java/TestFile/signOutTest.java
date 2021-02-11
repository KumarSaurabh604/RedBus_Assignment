package TestFile;

import org.apache.log4j.Logger;
import org.testng.SkipException;
import org.testng.annotations.Test;

import PageFile.MyProfilePage;
import PageFile.SignIn_Page;
import PageFile.signOutPage;
import PageFile.walletCardInfoPage;
import Utils.BaseFIle;

public class signOutTest extends BaseFIle {
	
	public final static Logger logger = Logger.getLogger(cancelTicketTest.class);

	@Test
	public void ValidSignOutFromAllDevices() throws Throwable {

		String status = reader.getRowTestData("Sheet1", "ValidSignOutFromAllDevices").get("TestStatus");

		if (status.toLowerCase().trim().equals("yes")) {
			
			logger.info("************************Valid Sign Out Test Starts Here********************");

			driverInitialize(prop.getProperty("browser"),prop.getProperty("browserType"));

			SignIn_Page obj1 = new SignIn_Page(driver);
			extentTest = extent.startTest("Testing Sign Out Funtionality From All Devices with passed Assertion");

			Thread.sleep(5000);
			obj1.id();
			Thread.sleep(2000);
			obj1.signIn();
			Thread.sleep(2000);
			obj1.googlebtn();
			Thread.sleep(2000);

			String user_id = reader.getRowTestData("Sheet1", "ValidSignOutFromAllDevices").get("Email");
			String pass = reader.getRowTestData("Sheet1", "ValidSignOutFromAllDevices").get("Password");

			obj1.SwitchWindow(user_id, pass);
			Thread.sleep(2000);
			MyProfilePage win = new MyProfilePage(driver);
			win.ClickOnProfileInfo();
			Thread.sleep(2000);
			signOutPage sign = new signOutPage(driver);
			sign.ClickOnSignOutFromAllDevices();
			Thread.sleep(2000);
			walletCardInfoPage wallet1 = new walletCardInfoPage(driver);
			wallet1.HelpBtNIsDisplayed();// Applying assertion
			
			logger.info("*************************Valid SignOut Test Ends Here********************");

		} else {

			extentTest = extent.startTest("Valid Sign Out From All Devices Funtionality  ");
			throw new SkipException("Valid Sign Out From All Devices Funtionality  Test Case has been Skipped");
		}

	}

	@Test
	public void InValidSignOutFromAllDevices() throws Throwable {

		String status = reader.getRowTestData("Sheet1", "InValidSignOutFromAllDevices").get("TestStatus");

		if (status.toLowerCase().trim().equals("yes")) {
			
			logger.info("*************************Invalid SignOut Test Starts Here********************");

			driverInitialize(prop.getProperty("browser"),prop.getProperty("browserType"));

			SignIn_Page obj1 = new SignIn_Page(driver);
			extentTest = extent.startTest("Testing SignOut From All Devices With Failed Assertion");

			Thread.sleep(5000);
			obj1.id();
			Thread.sleep(2000);
			obj1.signIn();
			Thread.sleep(2000);
			obj1.googlebtn();
			Thread.sleep(5000);

			String user_id = reader.getRowTestData("Sheet1", "InValidSignOutFromAllDevices").get("Email");
			String pass = reader.getRowTestData("Sheet1", "InValidSignOutFromAllDevices").get("Password");

			obj1.SwitchWindow(user_id, pass);
			Thread.sleep(5000);
			MyProfilePage win = new MyProfilePage(driver);
			win.ClickOnProfileInfo();
			Thread.sleep(2000);
			signOutPage sign = new signOutPage(driver);
			sign.ClickOnSignOutFromAllDevices();
			Thread.sleep(2000);
			walletCardInfoPage wallet1 = new walletCardInfoPage(driver);
			wallet1.HelpBtNIsNotDisplayed();
			
			logger.info("*************************Invalid SignOut Test Ends Here********************");

			// Applying assertion Failed Test Case
		} else {

			extentTest = extent.startTest("InValid Sign Out From All Devices Funtionality  ");
			throw new SkipException("InValid Sign Out From All Devices Funtionality  Test Case has been Skipped");
		}

	}

}
