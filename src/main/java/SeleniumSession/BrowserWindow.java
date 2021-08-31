package SeleniumSession;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserWindow {   

	public static void main(String[] args) {
		
		//browser window pop up / new tab window/new browser window.
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");                    	 //parent Window
		driver.findElement(By.xpath("//img[@alt='OrangeHRM on twitter']")).click();				//Child Window
		System.out.println(driver.getTitle());
		
		Set<String> handles = driver.getWindowHandles(); 	
		//set always unique/no duplicate value 				// value and doesnot maintains index (indexless collection)
		Iterator<String> it = handles.iterator();          //used for orderless data
		
		String ParentWindowId = it.next();		
		System.out.println("parent window id id :" + ParentWindowId);
		
		String childWindowId = it.next();
		System.out.println(ParentWindowId);
		System.out.println("parent window id id :" + childWindowId);
		
		//switching:
		driver.switchTo().window(childWindowId);
		System.out.println(driver.getCurrentUrl());
		
		driver.close();
		
		driver.switchTo().window(ParentWindowId);
		System.out.println(driver.getCurrentUrl());
		

	}

}

//open all the browser together - driver.getwindowhandles
		//switch 1by 1 and keep closing it
		
		
		//case 2 : open one by one and close it
