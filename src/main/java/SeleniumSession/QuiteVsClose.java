package SeleniumSession;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class QuiteVsClose {

	public static void main(String[] args) {
		// System.setProperty("webdriver.chrome.driver",
		// "D:\\\\Selenium\\\\chromedriver_win32\\\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.google.com");
		String Title = driver.getTitle();
		System.out.println("page Title" + Title);
		driver.getCurrentUrl();

		driver.close();
		System.out.println(Title);
		// NoSuchSessionException : Session id is invalid
		// same session id not null it's invalid now.

		driver.quit();
		System.out.println(Title);
		// NoSuchSessionException : Session Id is null. using Webdriver after calling
		// quite?
		// Session id = null

		// Reopen browser : new sessionid will generate after closing/quite the browser.
		driver = new ChromeDriver();
		driver.get("http://www.google.com");
		driver.getTitle();

	}

}
