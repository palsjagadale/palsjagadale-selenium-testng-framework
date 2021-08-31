package SeleniumSession;

import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserUtil {

	public WebDriver driver;

	/**
	 * This method is used to initialized the driver on the basis of given browser name 
	 * 
	 * @param BrowserName
	 * @return this returns WebDriver reference
	 */

	public WebDriver launchbrowser(String BrowserName) {
		if (BrowserName.equals("Chrome")) {
		//System.setProperty("webdriver.chrome.driver", "D:\\\\Selenium\\\\chromedriver_win32\\\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}

		else if (BrowserName.equals("FireFox")) {
			{
				//System.setProperty("webdriver.gecko.driver", "D:\\Selenium\\geckodriver-v0.29.1-win64\\geckodriver.exe");
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}
		}

		else {
			System.out.println("Browser not found");
		}
		return driver;
		
			
		
	}

	public void launchUrl(String Url) {
		if (Url == null) {
			return;
		}
		if (Url.isEmpty()) {
			return;
		}

		driver.get(Url);
	}

	public String getPageTitle() {
		return driver.getTitle();

	}
	
	public String getPageUrl()
	{
		return driver.getCurrentUrl();
	}

	public String getCurrentPageSource() {
		return driver.getPageSource();
	}

	public void closeBrowser() {
		driver.close();
	}

	public void quitBrowser() {
		driver.quit();
	}
	
}