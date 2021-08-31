package SeleniumSession;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverWaitConcept {
	
	static WebDriver driver ;

	public static void main(String[] args) {		
		
		//custom wait- you can define your own wait for a specific element.
		//Explicitly Wait  ----> WebDriver Wait (c)----> Fluent Wait (c) ------> wait(I)
		//not a global wait
		//can be applied for webelements and non webelements (alerts, any pop up, title, url of the page )
		
		WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		
		By emailId = By.id("input-email");
		By password = By.id("input-password");
		By emailBtn = By.xpath("//input[@value='Login']");
		
		
		//  WebDriverWait wait = new WebDriverWait(driver, 10);
		  waitforElementpresence(emailId, 5).sendKeys("naveenanimation20@gmail.com");  		  
		  driver.findElement(password).sendKeys("Selenium");
		  driver.findElement(emailBtn).click();
		 
		
			}
	
	/**
	 * presenceOfElementLocated : An expectation for checking that an element is present on the DOM of a page. This does not necessarily mean that the element is visible.
	 * @param locator
	 * @param timeout
	 * @return
	 */
	
	public static WebElement waitforElementpresence(By locator, int timeout)
	{
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

}
