package SeleniumSession;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class waitForFrame {
	
	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://classic.crmpro.com/");
		
		driver.findElement(By.name("username")).sendKeys("groupautomtion");
		driver.findElement(By.name("password")).sendKeys("Test@12345");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		
		WebDriverWait wait = new WebDriverWait(driver, 0);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("mainpanel"));

		driver.findElement(By.linkText("CONTANTS")).click();
		

	}
	
	
	public static void waitForFrameANDSwitchToIt(String Framename, int timeout)
	{
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("Framename"));
	}
	
	public static void waitForFrameANDSwitchToIt(By framelocator, int timeout)
	{
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("framelocator"));
	}
	
	public static void waitForFrameANDSwitchToIt(int frameIndex, int timeout)
	{
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("frameIndex"));
	}
	
	public static void waitForFrameANDSwitchToIt(WebElement frameelement, int timeout)
	{
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("frameelement"));
	}


}
