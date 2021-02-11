package TestFile;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import PageFile.MyProfilePage;
import PageFile.SignIn_Page;
//
//import CommonUtils.Base_Class;
//import CommonUtils.ExcelData;
//import Pages_RedBus.My_Profile_Window_Page;
//import Pages_RedBus.Sign_In_Page;
import Utils.BaseFIle;

public class MyProfileTest extends BaseFIle {
	
	public final static Logger logger = Logger.getLogger(cancelTicketTest.class);

	@Test
	public void ProfileWindowCheck() throws Throwable {

		String status = reader.getRowTestData("Sheet1", "ProfileWindowCheck").get("TestStatus");

		if (status.toLowerCase().trim().equals("yes")) {
			
			logger.info("*************************Profile Check Test Starts Here********************");

			driverInitialize(prop.getProperty("browser"),prop.getProperty("browserType"));

			SignIn_Page obj3 = new SignIn_Page(driver);
			extentTest = extent.startTest("Testing My Profile Info Button");

			Thread.sleep(5000);
			obj3.id();
			Thread.sleep(5000);
			obj3.signIn();
			Thread.sleep(5000);
			obj3.googlebtn();
			Thread.sleep(5000);

			String user_id = reader.getRowTestData("Sheet1", "ProfileWindowCheck").get("Email");
			String pass = reader.getRowTestData("Sheet1", "ProfileWindowCheck").get("Password");

			//valid login method
			obj3.SwitchWindow(user_id, pass);//taking values from excel sheet
			Thread.sleep(5000);

			MyProfilePage win = new MyProfilePage(driver);
			win.ClickOnProfileInfo();
			Thread.sleep(5000);
			win.ClickOnMyProfile();
			Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"profile_details\"]/div/div/span")).isDisplayed());
			Thread.sleep(5000);
			
			logger.info("*************************Profile Check Test Ends Here********************");

		} else {

			extentTest = extent.startTest("Profile Check Funtionality  ");
			throw new SkipException("Profile Check Funtionality  Test Case has been Skipped");
		}
	}

}