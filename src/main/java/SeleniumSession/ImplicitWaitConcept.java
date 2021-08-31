package SeleniumSession;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImplicitWaitConcept {
	
	WebDriver driver;
	
	//Wait in selenium : Synchronization : can be applied for WebElements and non WebElements(url, title, alert, pop up)
	//Two types: 
	//Static Wait : Thread.sleep(500)......pause the script for given number of second.
	//Dynamic wait :sec ...if element is found 	withtin the 4 sesc (rest of the 6 sec will be ignored.
			//a. Implicitly wait
			//b. Explicitly Wait  ----> WebDriver Wait (c)----> Fluent Wait (c) ------> wait(I)

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		//Implicitly Wait : Dynamic wait : Only applicable for WebElements.
										//	Its a global wait ---will be applicable for all the upcoming webelements 
										//after given time it will throw noSuchElemntFound exception if its not loaded.
		
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		
		WebElement emailId = driver.findElement(By.id("input-email"));
		WebElement password = driver.findElement(By.id("input-password"));
		WebElement emailBtn = driver.findElement(By.xpath("//input[@value='Login']"));
		
		emailId.sendKeys("naveenanimation20@gmail.com");
		password.sendKeys("Selenium12345");
		emailBtn.click();
		
		
		//can override the implicit wait 
		//home page
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
				
		//nullify of implicitWait
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		
		//js pop up confirmation - (alert) -----can't use implicit wait on non webelement.
		
		
		
		
		

	}

}
