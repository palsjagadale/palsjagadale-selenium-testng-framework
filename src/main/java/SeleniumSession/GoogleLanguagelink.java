package SeleniumSession;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleLanguagelink {

	static WebDriver driver;
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.google.co.in/");
		
		By langlink = By.xpath("//div[@id='SIvCob']/a");
		clickonelement(langlink, "मराठी");
		
		/*
		 * List<WebElement> langlist = driver.findElements(langlink);
		 * System.out.println(langlist.size());
		 * 
		 * for(WebElement e : langlist) { String textoflang= e.getText();
		 * System.out.println(textoflang);
		 * 
		 * if (textoflang.equals("मराठी")) { e.click(); break; } }
		 */

	}
	
	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}
	
	public static void clickonelement(By locator, String value) {

		List<WebElement> elelist = getElements(locator);
		System.out.println(elelist.size());

		for (WebElement e : elelist) {

			if (e.getText().equals(value)) {
				e.click();
				break;
			}

		}

	}
	
	

}
