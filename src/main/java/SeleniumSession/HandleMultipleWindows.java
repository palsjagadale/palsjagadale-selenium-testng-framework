package SeleniumSession;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleMultipleWindows {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		System.out.println(driver.getTitle());
		
		driver.findElement(By.xpath("//img[@alt='LinkedIn OrangeHRM group']")).click();
		driver.findElement(By.xpath("//img[@alt='OrangeHRM on Facebook']")).click();
		driver.findElement(By.xpath("//img[@alt='OrangeHRM on twitter']")).click();
		driver.findElement(By.xpath("//img[@alt='OrangeHRM on youtube']")).click();
		
		
		Set<String> handleId = driver.getWindowHandles();		
		List<String> handleindex = new ArrayList<String>(handleId);
		
		String OrangeParentWindow = handleindex.get(0);
		String youtubewindow =  handleindex.get(1);
		String twitterwindow = handleindex.get(2);
		String Facebookwindow = handleindex.get(3);
		String  LinkedInwindow = handleindex.get(4);
	
		System.out.println("OrangeParentWindow:" + OrangeParentWindow + " " + "LinkedInwindow:" + LinkedInwindow + " "
				+ "Facebookwindow:" + Facebookwindow + " " + "twitterwindow:" + twitterwindow + " " + "youtubewindow:"
				+ youtubewindow);

		driver.switchTo().window(twitterwindow);
		System.out.println(driver.getCurrentUrl());
		driver.close();

		driver.switchTo().window(LinkedInwindow);
		System.out.println(driver.getCurrentUrl());
		driver.close();

		driver.switchTo().window(Facebookwindow);
		System.out.println(driver.getCurrentUrl());
		driver.close();

		driver.switchTo().window(youtubewindow);
		System.out.println(driver.getCurrentUrl());
		driver.close();
		 
		driver.switchTo().window(OrangeParentWindow).getCurrentUrl();
		driver.close();
		  
		 
		
		
		
		
	}

}
