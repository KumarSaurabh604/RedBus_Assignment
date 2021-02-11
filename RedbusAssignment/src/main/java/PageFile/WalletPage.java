package PageFile;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class WalletPage {

	WebDriver driver;

	public WalletPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//*[@id='i-icon-profile']")
	public WebElement Profile_BTN;

	@FindBy(how = How.XPATH, using = "//*[@id='hc']/ul/li[4]")
	public WebElement Wallet_BtN;

	public void ClickOnProfileBtn() {
		Profile_BTN.click();
	}

	public void ClickOnWalletBtN() {
		Wallet_BtN.click();
	}

}