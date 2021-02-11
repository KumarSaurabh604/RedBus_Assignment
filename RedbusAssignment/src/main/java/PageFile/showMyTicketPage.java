package PageFile;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class showMyTicketPage {

	WebDriver driver;

	public showMyTicketPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//*[@id='hmb']/div[2]/ul/li[4]/span/span")
	public WebElement Show_My_Ticket_BtN;

	@FindBy(how = How.XPATH, using = "//*[@id='searchTicketTIN']")
	public WebElement Ticket_No_Block;

	@FindBy(how = How.XPATH, using = "//*[@id='searchTicketEmail']")
	public WebElement Email_id_Block;

	@FindBy(how = How.XPATH, using = "//*[@id='ticketSearch']")
	public WebElement Search_Btn;

	public void ShowMyTicketBtn() {
		Show_My_Ticket_BtN.click();
	}

	public void EnterTicketNo(String value) {
		Ticket_No_Block.sendKeys(value);
	}

	public void EnterEmailId(String value) {
		Email_id_Block.sendKeys(value);
	}

	public void ClickOnSearchBtn() {
		Search_Btn.click();
	}

}