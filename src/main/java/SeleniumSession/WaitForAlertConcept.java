package SeleniumSession;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitForAlertConcept {
	
	static WebDriver driver;

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://rediff.com/cgi-bin/login.cgi");
		
		driver.findElement(By.name("proceed")).click();
		String Text = getAlertText(5);		
		System.out.println(Text);		
		//acceptAlert(5);
		
	
		/*
		 * WebDriverWait wait = new WebDriverWait(driver, 5); Alert alert =
		 * wait.until(ExpectedConditions.alertIsPresent());
		 * 
		 * System.out.println(alert.getText()); alert.accept();
		 */
		
	}
	
	public static Alert waitForAlert(int timeout) {

		WebDriverWait wait = new WebDriverWait(driver, timeout);
		return wait.until(ExpectedConditions.alertIsPresent());
	}

	public static String getAlertText(int timeout) {
	     String text =  waitForAlert(timeout).getText();
	     System.out.println(text);
	     acceptAlert(timeout);
	     return text;
	}

	public static void acceptAlert(int timeout) {
		waitForAlert(timeout).accept();
	}

	public static void dismisstAlert(int timeout) {
		waitForAlert(timeout).dismiss();
	}

	public static void dismisstAlert(int timeout, String value) {
		waitForAlert(timeout).sendKeys(value);
	}

}


	



