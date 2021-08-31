package SeleniumSession;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GetAttributeTest {
	
	static WebDriver driver;

	public static void main(String[] args) {
		
		String browser = "Chrome";
		BrowserUtil brutil = new BrowserUtil();
		 driver = brutil.launchbrowser(browser);
		brutil.launchUrl("https://demo.opencart.com/index.php?route=account/register");
		
		
		By loginlink = By.linkText("Login");
		//driver.findElement(By.linkText("Login")).getAttribute("href");

		ElementUtil eleutil = new ElementUtil(driver);
		eleutil.getElement(loginlink);
		if (eleutil.doGetAttribute(loginlink, "href").contains("/login"));
		{
			System.out.println("href contains correct link");
		}
	}
	
	
	public static WebElement getElement(By locator) {
		
		return driver.findElement(locator);
	}
	
	
	public static String getAttribute(By locator, String attrname) {
		return getElement(locator).getAttribute(attrname);
	}

}
