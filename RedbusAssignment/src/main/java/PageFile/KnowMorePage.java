package PageFile;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class KnowMorePage {

	WebDriver driver;

	public KnowMorePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//a[@class='know_more']")
	public WebElement Know_More_BTN;

	@FindBy(how = How.XPATH, using = "//*[@name='tin']")
	public WebElement Ticket_Number;

	@FindBy(how = How.XPATH, using = "//*[@name='EmailId']")
	public WebElement EmaiIdValue;

	@FindBy(how = How.XPATH, using = "//*[@type='submit']")
	public WebElement Submit_Btn;
	
	@FindBy(how = How.XPATH, using = "//*[@id='rh_header']/div/div/a")
    public WebElement RedBus_Logo;

	public void clickSignin() {
		Know_More_BTN.click();
	}

	public void EnterTicketNumber(String name) {
		Ticket_Number.sendKeys(name);
	}

	public void enterEmail(String name) {
		EmaiIdValue.sendKeys(name);
	}

	public void clickSubmitBtm() {
		Submit_Btn.click();
	}
	
	public void RedBusLogoIsPresent() {//Method for assertion
        Assert.assertEquals(true, RedBus_Logo.isDisplayed());// Assertion
    }
}
