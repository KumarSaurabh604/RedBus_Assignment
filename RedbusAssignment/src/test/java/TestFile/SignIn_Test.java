package TestFile;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import PageFile.SignIn_Page;
import Utils.BaseFIle;

public class SignIn_Test extends BaseFIle {
	
	public final static Logger logger = Logger.getLogger(cancelTicketTest.class);

	@Test
	public void ValidSignIn() throws Throwable {

		String status = reader.getRowTestData("Sheet1", "ValidSignIn").get("TestStatus");

		if (status.toLowerCase().trim().equals("yes")) {
			
			logger.info("*************************Valid SignIn Test Starts Here********************");

			driverInitialize(prop.getProperty("browser"),prop.getProperty("browserType"));

			SignIn_Page obj = new SignIn_Page(driver);
			extentTest = extent.startTest("Valid SignIn Test ");

			obj.id();
			obj.signIn();
			Thread.sleep(5000);
			obj.googlebtn();
			Thread.sleep(5000);

			String user_id = reader.getRowTestData("Sheet1", "ValidSignIn").get("Email");
			String pass = reader.getRowTestData("Sheet1", "ValidSignIn").get("Password");

			obj.SwitchWindow(user_id, pass);
			Assert.assertTrue(driver.getTitle().contains("Book Bus Travels"));
			Thread.sleep(5000);
			
			logger.info("*************************Valid signIn Test Ends Here********************");

		} else {

			extentTest = extent.startTest("Valid SignIn Funtionality  ");
			throw new SkipException("Valid SignIn Funtionality  Test Case has been Skipped");
		}

	}

	@Test
	public void InvalidSignIn() throws Throwable {

		String status = reader.getRowTestData("Sheet1", "InvalidSignIn").get("TestStatus");

		if (status.toLowerCase().trim().equals("yes")) {
			
			logger.info("*************************Invalid signIn Test Starts Here********************");

			driverInitialize("chrome", "headmode");

			SignIn_Page obj = new SignIn_Page(driver);
			extentTest = extent.startTest("Invalid SignIn Test ");

			obj.id();
			obj.signIn();
			Thread.sleep(5000);
			obj.googlebtn();
			
			String email = reader.getRowTestData("Sheet1", "InvalidSignIn").get("Email");
			String password = reader.getRowTestData("Sheet1", "InvalidSignIn").get("Password");
			
			Thread.sleep(5000);
			obj.SwitchToWindow(email, password);
			
			SoftAssert soft = new SoftAssert();
			soft.assertTrue(driver.getTitle().contains("Book Bus Travels"));
			soft.assertAll();
			Thread.sleep(5000);
			
			logger.info("*************************Invalid signIn Test Ends Here********************");

		} else {

			extentTest = extent.startTest("Invalid SignIn Funtionality  ");
			throw new SkipException("Invalid SignIn Funtionality  Test Case has been Skipped");
		}
	}

}
