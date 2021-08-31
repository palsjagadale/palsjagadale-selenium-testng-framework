package SeleniumSession;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class waitForAlert {
	
	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		/*
		 * driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		 * driver.findElement(By.name("proceed")).click(); driver.switchTo().alert();
		 * System.out.println(getAlertText(5));
		 * 
		 * WebDriverWait wait = new WebDriverWait(driver, 5); Alert alt =
		 * wait.until(ExpectedConditions.alertIsPresent());
		 * System.out.println(alt.getText()); alt.accept();
		 * 
		 * waitForAlert(5);
		 */
	
		/*
		 * driver.get("https://demo.opencart.com/index.php?route=account/login");
		 * WebDriverWait wait = new WebDriverWait(driver, 5);
		 * if(wait.until(ExpectedConditions.titleContains("Login"))) {
		 * System.out.println(driver.getTitle()); }
		 */
		
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		driver.findElement(By.linkText("Register")).click();		
		WebDriverWait wait = new WebDriverWait(driver, 5);
		if (wait.until(ExpectedConditions.urlContains("/register")))
		{
			System.out.println(driver.getCurrentUrl());
		}
		
		
	

	}
	
	public static String waitForURLContains(String UrlFraction, int timeout)
	{
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		if (wait.until(ExpectedConditions.urlContains(UrlFraction)))
		{
			return driver.getCurrentUrl();
		}
		
		return null;
		
	}
	
	public static String waitForURLIs(String urlvalue, int timeout)
	{
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		if (wait.until(ExpectedConditions.urlToBe(urlvalue)))
		{
			return driver.getCurrentUrl();
		}
		
		return null;
		
	}
	public static String waitForTitleContains(String titlevalue, int timeout)
	{
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		if(wait.until(ExpectedConditions.titleContains("titlevalue")))
		{
			return driver.getTitle();
		}
		return null;
	}
	
	public static String waitForTitleIS(String fullTitle, int timeout)
	{
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		if(wait.until(ExpectedConditions.titleIs("titlevalue")))
		{
			return driver.getTitle();
		}
		return null;
	}
	
	public static Alert waitForAlert(int timeout)
	{
		WebDriverWait wait =  new WebDriverWait(driver, timeout);
		return wait.until(ExpectedConditions.alertIsPresent());
		
	}
	public static String getAlertText(int timeout)
	{
		String text= waitForAlert(5).getText();
		acceptAlert(timeout);
		return text;
	}
	
	public static void acceptAlert(int timeout)
	{
		 waitForAlert(timeout).accept();
	}
	
	public static void dismissAlert(int timeout)
	{
		 waitForAlert(timeout).dismiss();
	}
	
	public static void sendKeysOnAlert(String value, int timeout)
	{
		 waitForAlert(timeout).sendKeys(value);
	}
	


}
