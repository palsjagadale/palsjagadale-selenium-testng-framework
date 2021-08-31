package SeleniumSession;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TotalImages {
	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");

		// get count of all the links
		// print the text of each link and ingore blank value
		// findElements written list of webelements.

		By images = By.tagName("img");

		List<WebElement> imageslist = getElements(images);
		System.out.println(imageslist.size());

		//print index - assignment
		for (WebElement e : imageslist) {
			String altValue = e.getAttribute("alt");
			String srcValue = e.getAttribute("src");
			System.out.println(altValue + " " + srcValue);

		}

	}

	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}
	
	/*
	 * public static void gettotallinks(By locator) { List<WebElement> imageslist =
	 * getElements(locator); System.out.println(imageslist.size());
	 * 
	 * for (WebElement e : imageslist) { String altValue = e.getAttribute("alt");
	 * String srcValue = e.getAttribute("src"); System.out.println(altValue + " " +
	 * srcValue);
	 * 
	 * }
	 * 
	 * }
	 */

}
