package SeleniumSession;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StaleElementForWebElement {
		static WebDriver driver;
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		WebElement ele = driver.findElement(By.id("input-email"));
			ele.sendKeys("test@gmail.com");
			driver.navigate().refresh();
			ele = driver.findElement(By.id("input-email"));
			ele.sendKeys("test@gmail.com");

	}

}
