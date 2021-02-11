package PageFile;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class rPoolPage {

	WebDriver driver;

	public rPoolPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(how = How.ID, using = "cars")
	public WebElement rPoolBtn;

	@FindBy(how = How.XPATH, using = "//*[@id='howItWorks']/div/div/div[2]/div[1]/div[2]")
	public WebElement requestBtn;

	@FindBy(how = How.XPATH, using = "//*[@id=\"howItWorks\"]/div/div/div[2]/div[1]/div[3]")
	public WebElement chooseBtn;

	@FindBy(how = How.XPATH, using = "//*[@id='howItWorks']/div/div/div[2]/div[1]/div[4]")
	public WebElement payBtn;

	@FindBy(how = How.XPATH, using = "//*[@id='howItWorks']/div/div/div[1]/span[2]")
	public WebElement offerRideTab;

	@FindBy(how = How.XPATH, using = "//*[@id='howItWorks']/div/div/div[2]/div[1]/div[2]")
	public WebElement offerRideBtn;

	@FindBy(how = How.XPATH, using = "//*[@id='howItWorks']/div/div/div[2]/div[1]/div[3]")
	public WebElement chooseRideBtn;

	@FindBy(how = How.XPATH, using = "//*[@id='howItWorks']/div/div/div[2]/div[1]/div[4]")
	public WebElement getPoint;

	public void findRide() throws Throwable {

		rPoolBtn.click();
		Thread.sleep(3000);
		requestBtn.click();
		Thread.sleep(3000);
		chooseBtn.click();
		Thread.sleep(3000);
		payBtn.click();

	}

	public void offerRide() throws Exception {

		offerRideTab.click();
		Thread.sleep(3000);
		offerRideBtn.click();
		Thread.sleep(3000);
		chooseRideBtn.click();
		Thread.sleep(3000);
		getPoint.click();
		

	}
}
