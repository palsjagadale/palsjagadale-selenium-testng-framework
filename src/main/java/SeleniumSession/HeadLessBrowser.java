package SeleniumSession;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HeadLessBrowser {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		/*
		 * FirefoxOptions fo = new FirefoxOptions(); fo.addArguments("--headless");
		 */
		
		ChromeOptions co =new ChromeOptions();
		co.addArguments("--headless");
		//co.addArguments("--incognito");
		
		
		WebDriver driver= new ChromeDriver(co);		
		driver.get("http://amazon.com");
		System.out.println(driver.getTitle());
		driver.quit();
		
		
		///which class is responsible to run TC in headless mode  : ChromeOptions 
		//argument name : --headless/--incognito

	}

}
