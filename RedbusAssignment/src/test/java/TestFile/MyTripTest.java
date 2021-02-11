package TestFile;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.testng.SkipException;
import org.testng.annotations.Test;

import PageFile.MyTripPage;
import PageFile.SignIn_Page;
import Utils.BaseFIle;

public class MyTripTest extends BaseFIle {
	
	public final static Logger logger = Logger.getLogger(cancelTicketTest.class);

	@Test
	public void MyTripsWindow() throws Throwable {

		String status = reader.getRowTestData("Sheet1", "MyTripsWindow").get("TestStatus");

		if (status.toLowerCase().trim().equals("yes")) {
			
			logger.info("*************************My Trip Test Starts Here********************");

			driverInitialize(prop.getProperty("browser"),prop.getProperty("browserType"));

			SignIn_Page obj1 = new SignIn_Page(driver);
			extentTest = extent.startTest("My Trip window Test ");

			Thread.sleep(5000);
			obj1.id();
			Thread.sleep(5000);
			obj1.signIn();
			Thread.sleep(5000);
			obj1.googlebtn();
			Thread.sleep(5000);

			//values from excel sheet
			String user_id = reader.getRowTestData("Sheet1", "MyTripsWindow").get("Email");
			String pass = reader.getRowTestData("Sheet1", "MyTripsWindow").get("Password");

			obj1.SwitchWindow(user_id, pass);//valid login method
			Thread.sleep(2000);

			MyTripPage win = new MyTripPage(driver);
			win.ClickOnUserIconBtn();
			Thread.sleep(2000);
			win.ClickOnMyTripsBtn();
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			win.CompletedBtNIsDisplayed();// Applying Assertion
			
			logger.info("*************************My Trip Test Ends Here********************");

		} else {

			extentTest = extent.startTest("My Trip Funtionality  ");
			throw new SkipException("My Trip Funtionality  Test Case has been Skipped");
		}
	}

	@Test
	public void MyTripsWindowFailed() throws Throwable {

		String status = reader.getRowTestData("Sheet1", "MyTripsWindowFailed").get("TestStatus");

		if (status.toLowerCase().trim().equals("yes")) {
			
			logger.info("*************************My Trip failed Test Starts Here********************");

			driverInitialize(prop.getProperty("browser"),prop.getProperty("browserType"));

			SignIn_Page obj1 = new SignIn_Page(driver);
			extentTest = extent.startTest("Valid Login with Facebook Test ");

			Thread.sleep(5000);
			obj1.id();
			Thread.sleep(5000);
			obj1.signIn();
			Thread.sleep(5000);
			obj1.googlebtn();
			Thread.sleep(5000);
			
			//Taking values from excel sheet
			String user_id = reader.getRowTestData("Sheet1", "MyTripsWindowFailed").get("Email");
			String pass = reader.getRowTestData("Sheet1", "MyTripsWindowFailed").get("Password");

			obj1.SwitchWindow(user_id, pass);//valid login method
			Thread.sleep(2000);

			MyTripPage win = new MyTripPage(driver);
			win.ClickOnUserIconBtn();
			Thread.sleep(2000);
			win.ClickOnMyTripsBtn();
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			win.CompletedBtNIsNotDisplayed();// Applying Assertion
			
			logger.info("*************************My Trip Failed Test Ends Here********************");
			
		} else {

			extentTest = extent.startTest("My Trip Failed Funtionality  ");
			throw new SkipException("My Trip Failed Funtionality  Test Case has been Skipped");
		}
	}
}
