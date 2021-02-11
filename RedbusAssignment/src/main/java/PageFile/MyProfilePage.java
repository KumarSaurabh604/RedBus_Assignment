package PageFile;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class MyProfilePage {

	WebDriver driver;

	public MyProfilePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//*[@id='i-icon-profile']")
	public WebElement Profile_BTN_Info;

	@FindBy(how = How.XPATH, using = "//*[@id='hc']/ul/li[3]")
	public WebElement My_Profile_Btn;

	public void ClickOnProfileInfo() {
		Profile_BTN_Info.click();
	}

	public void ClickOnMyProfile() {
		My_Profile_Btn.click();
	}
}