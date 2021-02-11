package TestFile;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import PageFile.SignIn_Page;
import PageFile.UpdateProfilePage;
import Utils.BaseClass;
import Utils.BaseFIle;

public class UpdateProfileTest extends BaseFIle {
	
	public final static Logger logger = Logger.getLogger(cancelTicketTest.class);

	@Test
	public void ValidUpdate() throws Throwable {

		String status = reader.getRowTestData("Sheet1", "ValidUpdate").get("TestStatus");

		if (status.toLowerCase().trim().equals("yes")) {
			
			logger.info("*************************Update Profile Test Starts Here********************");

			driverInitialize(prop.getProperty("browser"),prop.getProperty("browserType"));

			SignIn_Page obj = new SignIn_Page(driver);
			extentTest = extent.startTest("Update Profile Test ");

			obj.id();
			obj.signIn();
//		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			Thread.sleep(5000);
			obj.googlebtn();
//		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			Thread.sleep(5000);

			String user_id = reader.getRowTestData("Sheet1", "ValidUpdate").get("Email");
			String pass = reader.getRowTestData("Sheet1", "ValidUpdate").get("Password");

			obj.SwitchWindow(user_id, pass);
//		Assert.assertTrue(driver.getTitle().contains("Book Bus Travels"));
			Thread.sleep(5000);
			obj.id();

			BaseClass base = new BaseClass();

			UpdateProfilePage upd = new UpdateProfilePage(driver);
			upd.editProfile();
			
			String name = reader.getRowTestData("Sheet1", "ValidUpdate").get("Name");
			upd.editValidName(name);
			
			upd.finalSelect();
			Thread.sleep(3000);

			Assert.assertTrue(driver.findElement(By.id("nf_success")).isDisplayed());
			
			logger.info("*************************Update Profile Test Ends Here********************");

		} else {

			extentTest = extent.startTest("Valid Profile Update Funtionality  ");
			throw new SkipException("Valid Profile Update Funtionality  Test Case has been Skipped");
		}

	}

	@Test
	public void InvalidUpdate() throws Throwable {

		String status = reader.getRowTestData("Sheet1", "InvalidUpdate").get("TestStatus");

		if (status.toLowerCase().trim().equals("yes")) {
			
			logger.info("*************************Invalid Update Profile Test Starts Here********************");

			driverInitialize(prop.getProperty("browser"),prop.getProperty("browserType"));

			SignIn_Page obj = new SignIn_Page(driver);
			extentTest = extent.startTest("Update Profile Test ");

			obj.id();
			obj.signIn();
//		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			Thread.sleep(5000);
			obj.googlebtn();
//		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			Thread.sleep(5000);

			String user_id = reader.getRowTestData("Sheet1", "InvalidUpdate").get("Email");
			String pass = reader.getRowTestData("Sheet1", "InvalidUpdate").get("Password");

			obj.SwitchWindow(user_id, pass);
//		Assert.assertTrue(driver.getTitle().contains("Book Bus Travels"));
			Thread.sleep(5000);
			obj.id();

//		BaseClass base = new BaseClass();

			UpdateProfilePage upd = new UpdateProfilePage(driver);
			upd.editProfile();
			upd.editInvalidName();
			upd.finalSelect();
			Thread.sleep(3000);

			Assert.assertTrue(driver.findElement(By.id("nf_success")).isDisplayed());
			
			logger.info("*************************Invalid Update Profile Test Ends Here********************");

		} else {

			extentTest = extent.startTest("Invalid Profile Update Funtionality  ");
			throw new SkipException("Invalid Profile Update Funtionality  Test Case has been Skipped");
		}
	}

}
