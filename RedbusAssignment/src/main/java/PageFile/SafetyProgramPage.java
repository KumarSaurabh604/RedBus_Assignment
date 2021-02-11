package PageFile;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SafetyProgramPage {

	WebDriver driver;

	public SafetyProgramPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//div[@id='safetyplusClick']")
	public WebElement Safety_Know_More_BTN;

	@FindBy(how = How.XPATH, using = "//div[@class='bc']")
	public WebElement View_Safety_Plus_Btn;

	public void ClickOnSafetyKnowMore() {
		Safety_Know_More_BTN.click();
	}

	public void ClickOnViewSafetyBtn() {
		View_Safety_Plus_Btn.click();
	}
}