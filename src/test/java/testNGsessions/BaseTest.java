package testNGsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	WebDriver driver;
	
	@Parameters({"browser", "url"})
	@BeforeTest
	public void setUp(String BrowserName, String url)
	{
		
		if (BrowserName.equals("Chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(BrowserName.equals("firefox"))		
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		
		else if(BrowserName.equals("safari"))		
		{
			
			driver = new SafariDriver();
		}
		else
		{
			System.out.println("pass the correct browser " + BrowserName);
		}
		
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(url);
		
	}
	
	@AfterTest
	public void tearDowm()
	{
		driver.quit();
	}
	

}
