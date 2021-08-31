package SeleniumSession;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalenderHandling {
	
	static WebDriver driver;

 public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		 driver =  new ChromeDriver();
		driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");
		driver.findElement(By.id("datepicker")).click();
		
		Thread.sleep(2000);
		
		//driver.findElement(By.xpath("//a[text()='31']")).click();
		/*
		 * List<WebElement> datesList = driver.findElements(By.cssSelector("table.ui-datepicker-calendar a"));
		 * for(WebElement e : datesList) 
		 * { 
		 * if (e.getText().equals("31"))
		 *  { 
		 *  e.click();
		 * break;
		 *  }
		 *   }
		 */
		selectbackDate("June 2021", "25");
		
	}
	
	public static void selectFutureDate(String ExpMonthYear, String date)
	{
		String actMonthYear = driver.findElement(By.cssSelector("div.ui-datepicker-title")).getText();
		System.out.println(actMonthYear);
		
		while(!actMonthYear.equals(ExpMonthYear))
		{
			//click on next
			driver.findElement(By.xpath("//span[text()='Next']")).click();
			actMonthYear = driver.findElement(By.cssSelector("div.ui-datepicker-title")).getText();
			System.out.println(actMonthYear);			
		}
		driver.findElement(By.xpath("//a[text()='"+date+"']")).click();
	}
	public static void selectbackDate(String ExpMonthYear, String date)
	{
		if (Integer.parseInt(date)>31)
		{
			return;
		}
		String actMonthYear = driver.findElement(By.cssSelector("div.ui-datepicker-title")).getText();
		System.out.println(actMonthYear);		
		
		  while(!actMonthYear.equals(ExpMonthYear)) {
			  //click on next
		  driver.findElement(By.xpath("//span[text()='Prev']")).click(); 
		  actMonthYear = driver.findElement(By.cssSelector("div.ui-datepicker-title")).getText();
		  System.out.println(actMonthYear); }
		  driver.findElement(By.xpath("//a[text()='"+date+"']")).click();
		 
	}

}
