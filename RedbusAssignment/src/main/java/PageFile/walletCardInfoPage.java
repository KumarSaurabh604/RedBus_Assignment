package PageFile;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class walletCardInfoPage {

	WebDriver driver;

	public walletCardInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//*[@id='hc']/ul/li[2]")
	public WebElement Wallet_Card_BTN;

	@FindBy(how = How.XPATH, using = "//*[@id='rh_header']/div/div/div[2]/div[3]/div/a")
	public WebElement Help_BTN;

	public void ClickOnWalletCardBtN() {
		Wallet_Card_BTN.click();
	}

	public void HelpBtNIsDisplayed() {
		Assert.assertEquals(true, Help_BTN.isDisplayed());// Assertion Method
	}

	public void HelpBtNIsNotDisplayed() {
		Assert.assertNotEquals(true, Help_BTN.isDisplayed());// Assertion Method
	}
}