package TestFile;

import org.apache.log4j.Logger;
import org.testng.SkipException;
import org.testng.annotations.Test;

import PageFile.MyProfilePage;
import PageFile.SignIn_Page;
import PageFile.walletCardInfoPage;
import Utils.BaseFIle;

public class walletCardInfoTest extends BaseFIle {
	
	public final static Logger logger = Logger.getLogger(cancelTicketTest.class);

	@Test
	public void SavedCardInWallet() throws Throwable {

		String status = reader.getRowTestData("Sheet1", "SavedCardInWallet").get("TestStatus");

		if (status.toLowerCase().trim().equals("yes")) {
			
			logger.info("*************************Wallet Info Test Starts Here********************");

			driverInitialize(prop.getProperty("browser"),prop.getProperty("browserType"));

			SignIn_Page obj1 = new SignIn_Page(driver);
			extentTest = extent.startTest("Displaying saved cards in wallet ");

			Thread.sleep(5000);
			obj1.id();
			Thread.sleep(2000);
			obj1.signIn();
			Thread.sleep(2000);
			obj1.googlebtn();
			Thread.sleep(2000);

			String user_id = reader.getRowTestData("Sheet1", "SavedCardInWallet").get("Email");
			String pass = reader.getRowTestData("Sheet1", "SavedCardInWallet").get("Password");

			obj1.SwitchWindow(user_id, pass);
			Thread.sleep(2000);
			MyProfilePage win = new MyProfilePage(driver);
			win.ClickOnProfileInfo();
			walletCardInfoPage wallet = new walletCardInfoPage(driver);
			wallet.ClickOnWalletCardBtN();
			Thread.sleep(2000);
			wallet.HelpBtNIsDisplayed();// Applying assertion that help button is displayed
			
			logger.info("*************************Wallet Info Test Ends Here********************");

		} else {

			extentTest = extent.startTest("Saved Card In Wallet Funtionality  ");
			throw new SkipException("Saved Card In Wallet Funtionality  Test Case has been Skipped");
		}
	}
}