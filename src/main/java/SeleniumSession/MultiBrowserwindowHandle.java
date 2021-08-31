package SeleniumSession;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultiBrowserwindowHandle {
	
	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();

		driver.get("https://opensource-demo.orangehrmlive.com/");                                       //parent Window
		
		driver.findElement(By.xpath("//img[@alt='LinkedIn OrangeHRM group']")).click();                    //Child Window				
		  Set<String> handlesId = driver.getWindowHandles();
		  List<String> handlesindex = new ArrayList<String>(handlesId);		  
		  String orangeparentWindow = handlesindex.get(0);
		  String LinkdInchildWindow = handlesindex.get(1);		  
		  driver.switchTo().window(LinkdInchildWindow);
		  System.out.println(driver.getCurrentUrl());
		  driver.close();		  
		  driver.switchTo().window(orangeparentWindow);
		  System.out.println(driver.getCurrentUrl());
		  
		  driver.findElement(By.xpath("//img[@alt='OrangeHRM on Facebook']")).click();
		  Set<String> handlesId1 = driver.getWindowHandles();
		  List<String> handlesindex1 = new ArrayList<String>(handlesId1);
		  String orangeparentWindow1 = handlesindex1.get(0);
		  String FacebookchildWindow = handlesindex1.get(1);		  
		  driver.switchTo().window(FacebookchildWindow);
		  System.out.println(driver.getCurrentUrl());
		  driver.close();			  
		  driver.switchTo().window(orangeparentWindow1);
		  System.out.println(driver.getCurrentUrl());
		  
		  
		  driver.findElement(By.xpath("//img[@alt='OrangeHRM on twitter']")).click();
		  Set<String> handlesId2 = driver.getWindowHandles();
		  List<String> handlesindex2 = new ArrayList<String>(handlesId2);
		  String orangeparentWindow2 = handlesindex2.get(0);
		  String TwitterchildWindow = handlesindex2.get(1);		  
		  driver.switchTo().window(TwitterchildWindow);
		  System.out.println(driver.getCurrentUrl());
		  driver.close();			  
		  driver.switchTo().window(orangeparentWindow2);
		  System.out.println(driver.getCurrentUrl()); 
		  
		  
		  driver.findElement(By.xpath("//img[@alt='OrangeHRM on youtube']")).click();
		  Set<String> handlesId3 = driver.getWindowHandles();
		  List<String> handlesindex3 = new ArrayList<String>(handlesId3);
		  String orangeparentWindow3 = handlesindex3.get(0);
		  String youtubechildWindow = handlesindex3.get(1);		  
		  driver.switchTo().window(youtubechildWindow);
		  System.out.println(driver.getCurrentUrl());
		  driver.close();			  
		  driver.switchTo().window(orangeparentWindow3);
		  System.out.println(driver.getCurrentUrl()); 
				
	}
		
	

}
