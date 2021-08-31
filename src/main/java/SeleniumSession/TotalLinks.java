package SeleniumSession;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TotalLinks {

	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");

		// get count of all the links
		// print the text of each link and ingore blank value

		// findElements written list of webelements.

		By links = By.tagName("a");

		List<WebElement> linklist = getElements(links);

		// List<WebElement> linklist = driver.findElements(By.tagName("a"));
		System.out.println(linklist.size());

		for (WebElement e : linklist) {
			String linktest = e.getText();

			if (!linktest.isEmpty()) {
				System.out.println(linktest);

			}

		}

	}

	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

}
