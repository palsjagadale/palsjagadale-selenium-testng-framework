package SeleniumSession;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserWindowwithList {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");						//parent window
		System.out.println(driver.getTitle());
		
		driver.findElement(By.xpath("//img[@alt='OrangeHRM on youtube']")).click();				//Child Window
		System.out.println(driver.getTitle());
		
		Set<String> handles = driver.getWindowHandles();
		List<String> handlesId = new ArrayList<String>(handles);
		String parentWidnow = handlesId.get(0);
		String childWindow = handlesId.get(1);
		
		driver.switchTo().window(childWindow);
				System.out.println(driver.getCurrentUrl());
				driver.close();
		
		driver.switchTo().window(parentWidnow);
		System.out.println(driver.getCurrentUrl());

	}

}
