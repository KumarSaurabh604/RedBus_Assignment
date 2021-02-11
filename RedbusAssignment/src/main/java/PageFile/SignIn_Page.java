package PageFile;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignIn_Page {

	WebDriver driver;

	public SignIn_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(how = How.ID, using = "sign-in-icon-down")//select_box_sign
	public WebElement Id;

	@FindBy(how = How.ID, using = "hc")
	public WebElement signIn;

	@FindBy(how = How.CLASS_NAME, using = "modalIframe")
	public WebElement frame;

	@FindBy(how = How.ID, using = "newFbId")
	public WebElement facebookBtn;

	@FindBy(how = How.ID, using = "email")
	public WebElement facebookEmail;

	@FindBy(how = How.ID, using = "pass")
	public WebElement facebookPass;

	@FindBy(how = How.ID, using = "loginbutton")
	public WebElement LoginBtn;
	
	@FindBy(how = How.XPATH, using = "//button[@name='__CONFIRM__']")
	public WebElement confirm;
	
	@FindBy(how = How.XPATH, using = "//i[@class='icon-close']")
	public WebElement close;

	public void id() {
		WebElement element = new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOfElementLocated(By.id("sign-in-icon-down")));
		Id.click();
	}

	public void signIn() {
		signIn.click();
	}

	public void googlebtn() throws InterruptedException {
		driver.switchTo().frame(frame);
	}

	public void SwitchWindow(String userID,String password) throws InterruptedException {

		String parentwindow = driver.getWindowHandle();

		facebookBtn.click();
		Set<String> allWindows = driver.getWindowHandles();

		int count = allWindows.size();

		for (String child : allWindows) {
			if (!parentwindow.equalsIgnoreCase(child)) {

				driver.switchTo().window(child);
				driver.manage().window().maximize();
				Thread.sleep(5000);
				facebookEmail.sendKeys(userID);
				facebookPass.sendKeys(password);
				Thread.sleep(5000);
				LoginBtn.click();
				Thread.sleep(5000);
			}

		}
		Thread.sleep(5000);
		
		driver.switchTo().window(parentwindow);
		Thread.sleep(5000);
//		close.click();

	}
	
	public void SwitchToWindow(String email, String pass) throws InterruptedException {

		String parentwindow = driver.getWindowHandle();

		facebookBtn.click();
		Set<String> allWindows = driver.getWindowHandles();

		int count = allWindows.size();

		for (String child : allWindows) {
			if (!parentwindow.equalsIgnoreCase(child)) {

				driver.switchTo().window(child);
				driver.manage().window().maximize();
				Thread.sleep(5000);
				facebookEmail.sendKeys(email);
				facebookPass.sendKeys(pass);
				Thread.sleep(5000);
				LoginBtn.click();
				Thread.sleep(5000);
			}

		}
		
	}
	

}
