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

public class busOperatorPage {

	WebDriver driver;

	public busOperatorPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//a[text()='Rajdhani Express']")
	public WebElement top_operator;

	@FindBy(how = How.XPATH, using = "//a[text()='Pune to Bangalore Bus']")
	public WebElement bus_route;

	@FindBy(xpath = "//div[@class='close']")
	public WebElement icon_close;

	@FindBy(how = How.CSS, using = "#rh_footer > div:nth-child(2) > div > div > div > a")
	public WebElement all_operatorbtn;

	@FindBy(how = How.XPATH, using = "//*[@id='root']/div/article[2]/div[1]/ul/li[38]/a")
	public WebElement selected_operator;

	public void clickOneTopOperator() {
		top_operator.click();
	}

	public void selectBusRoute() throws InterruptedException {
		bus_route.click();
		Thread.sleep(4000);
	}

	public void clickCloseIcon() {
		icon_close.click();
	}

	public void clickAllOperators() throws InterruptedException {
		Thread.sleep(1000);
		all_operatorbtn.click();
	}

	public void switchWindow() {//method to switch the window from parent to child
		String parentwindow = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();
		int count = allWindows.size();
		for (String child : allWindows) {
			if (!parentwindow.equalsIgnoreCase(child)) {
				driver.switchTo().window(child);
				WebDriverWait wait = new WebDriverWait(driver, 30);
				WebElement element = wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//*[@id='root']/div/article[1]/div[3]/h2")));
				selected_operator.click();
			}
		}
	}
}
