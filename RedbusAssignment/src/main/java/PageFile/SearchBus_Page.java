package PageFile;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchBus_Page {

	WebDriver driver;
	public SearchBus_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	@FindBy(how = How.ID, using = "src")
	public WebElement source;
	
	@FindBy(how = How.XPATH, using = "//*[@id='search']/div/div[1]/div/ul/li")
	public WebElement select_src;
	
	@FindBy(how = How.ID, using = "dest")
	public WebElement destination;
	
	@FindBy(how = How.XPATH, using = "//*[@id='search']/div/div[2]/div/ul/li")
	public WebElement select_dest;
	
	@FindBy(how = How.XPATH, using = "//span[@class='fl icon-calendar_icon-new icon-onward-calendar icon']")
	public WebElement calender;
	
	@FindBy(how = How.XPATH, using = "//*[@id='rb-calendar_onward_cal']/table/tbody/tr[5]/td[7]")
	public WebElement date;
	
	@FindBy(how = How.XPATH, using = "//*[@id='search_btn']")
	public WebElement search_btn;
	
	public void sourceLocation(String location) {
		source.click();
		source.sendKeys(location);
		select_src.click();
	}
	
	public void destinationLocation(String location) {
		destination.click();
		destination.sendKeys(location);
		select_dest.click();
	}
	
	public void clickCalender() {
		calender.click();
	}
	
	public void chooseDate() {
		date.click();
	}
	
	public void clickSearchBtn() throws InterruptedException {
		search_btn.click();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement element = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='onward-modify-btn g-button clearfix fl']")));
	}
	
}
