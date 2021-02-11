package PageFile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ModifyDatePage {
	
	WebDriver driver;
	public ModifyDatePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	//div[@class="onward-modify-btn g-button clearfix fl"]
	
	@FindBy(how = How.XPATH, using = "//div[@class='onward-modify-btn g-button clearfix fl']")
	public WebElement modify;
	
	@FindBy(how = How.XPATH, using = "//*[@id='switchButton']")
	public WebElement switchBtn;
	
	@FindBy(how = How.XPATH, using = "//*[@id='fixer']/section/div/div[4]/button")
	public WebElement search;
	
	
	
	public void modify() {
		modify.click();
	}
	
	public void switchButton() {
		switchBtn.click();
	}
	
	public void searchBtn() {
		search.click();
	}
	
	
}
