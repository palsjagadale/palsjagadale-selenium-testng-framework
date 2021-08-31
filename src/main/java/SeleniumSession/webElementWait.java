package SeleniumSession;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class webElementWait {
	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
			
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		By emailId = By.id("input-email");
		By password = By.id("input-password");
		By emailBtn = By.xpath("//input[@value='Login']");
		
		WebDriverWait wait = new WebDriverWait(driver, 5);
		WebElement email_ele = wait.until(ExpectedConditions.visibilityOfElementLocated(emailId));
		email_ele.sendKeys("test@gmail.com");
		driver.findElement(password).sendKeys("test123");
		driver.findElement(emailBtn).click();
	}
	
	
	/**
	 * An expectation for checking that an element is present on the DOM of a page. This does notnecessarily mean that the element is visible.
	 * @param locator
	 * @param timeout
	 * @return
	 */
	
	public WebElement waitforElementpresence(By locator, int timeout)
	{
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	
	/**
	 * An expectation for checking that an element is present on the DOM of a page and visible.Visibility means that the element is not only displayed but also has a height and width that isgreater than 0.
	 * @param locator
	 * @param timeout
	 * @return
	 */
	
	public static WebElement waitForElementVisible(By locator, int timeout)
	{
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	 
	}
}

