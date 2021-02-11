package PageFile;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class MyTripPage {

	WebDriver driver;

	public MyTripPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(how = How.ID, using = "signin-block")
	public WebElement User_Icon_Btn;

	@FindBy(how = How.XPATH, using = "//*[@id='hc']/ul/li[1]")
	public WebElement My_Trips_BTN;

	@FindBy(how = How.XPATH, using = "//*[@id='Upcoming']")
	public WebElement Upcoming_Trips_Btn;

	public void ClickOnUserIconBtn() {
		User_Icon_Btn.click();
	}

	public void ClickOnMyTripsBtn() {
		My_Trips_BTN.click();
	}

	public void CompletedBtNIsDisplayed() {
		Assert.assertEquals(true, Upcoming_Trips_Btn.isDisplayed());

	}

	public void CompletedBtNIsNotDisplayed() {
		
		SoftAssert soft = new SoftAssert();
		soft.assertFalse(Upcoming_Trips_Btn.isDisplayed());
		soft.assertAll();

	}
}
