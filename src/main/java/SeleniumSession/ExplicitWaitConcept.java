package SeleniumSession;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitWaitConcept {
	
	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://https://classic.crmpro.com/index.html");
		
		
		By username = By.name("username");
		By password = By.name("password");
		By login = By.xpath("//input[@type='submit']");
		
		
		
		/*
		 * WebDriverWait wait = new WebDriverWait(driver, 10); // no default constructor
		 * wait.until(ExpectedConditions.presenceOfElementLocated(username)).sendKeys(
		 * "xyz@xyz.com");
		 * 
		 * WebElement el = driver.findElement(username); el.sendKeys("xyz@xyz.com");
		 */
		
		waitforElementpresence(username, 10).sendKeys("naveen@gmail.com");
		
		WebElement el2 = driver.findElement(password);
		el2.sendKeys("test123");
		
		WebElement el3 = driver.findElement(login);
		el3.click();
	}
	
	
	/**
	 * An expectation for checking that an element is present on the DOM of a page.
	 * This does notnecessarily mean that the element is visible.
	 * @param locator
	 * @param timeout
	 * @return
	 */
	
	public static WebElement waitforElementpresence(By locator, int timeout)
	{
		WebDriverWait wait = new WebDriverWait(driver, timeout); //no default constructor 
		 return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	public static WebElement waitforElementpresence(By locator, int timeout, int intervalTime)
	{
		WebDriverWait wait = new WebDriverWait(driver, timeout, intervalTime); //no default constructor 
		 return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	

}
