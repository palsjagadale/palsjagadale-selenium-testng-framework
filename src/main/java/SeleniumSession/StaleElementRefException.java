package SeleniumSession;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StaleElementRefException {
	
	static WebDriver driver;

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://freshworks.com");
		System.out.println(driver.getTitle());
		
		List<WebElement> footerList = driver.findElements(By.xpath("(//ul[@class='footer-nav'])[1]//a"));
		
		for(int i=0; i<footerList.size(); i++) {
			footerList.get(i).click();
			footerList = driver.findElements(By.xpath("(//ul[@class='footer-nav'])[1]//a"));
		}

	}

}
