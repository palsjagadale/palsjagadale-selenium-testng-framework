package SeleniumSession;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ElementIsDisplayed {

	static WebDriver driver;

	public static void main(String[] args) {
		String Browser = "Chrome";

//		WebDriverManager.chromedriver().setup();
//		driver =  new ChromeDriver();

		BrowserUtil brUtil = new BrowserUtil();
		WebDriver driver = brUtil.launchbrowser(Browser);
		brUtil.launchUrl("https://demo.opencart.com/index.php?route=account/register");
		String PageTitle = brUtil.getPageTitle();
		if (PageTitle.contains("search")) {
			System.out.println("Page title is correct");
		}

		By SearchField = By.name("search");
		By SearchButton = By.xpath("//*[@id=\"search\"]/span/button");

		ElementUtil eleUtil = new ElementUtil(driver);
		if (eleUtil.doDisplayed(SearchField)) {
			eleUtil.doSendKeys(SearchField, "Mac");
		}

		if (eleUtil.doEnable(SearchButton)) {

			eleUtil.doClick(SearchButton);
		}

	}

	
}
