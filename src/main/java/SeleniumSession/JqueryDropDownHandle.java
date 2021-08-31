package SeleniumSession;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JqueryDropDownHandle {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(2000, TimeUnit.SECONDS);
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
		By Dropdown = By.id("justAnInputBox");
		By options = By.cssSelector(".comboTreeItemTitle");

		ElementUtil eleUtil = new ElementUtil(driver);
		eleUtil.doClick(Dropdown);
		selectchoice(options, "choice 6 1");
		multiselectchoice(options, "choice 1", "choice 2", "choice 4");
		

		/*
		 * List<WebElement> choiceList = eleUtil.getElements(options);
		 * 
		 * System.out.println(choiceList.size());
		 * 
		 * for (WebElement e : choiceList) { String text = e.getText();
		 * System.out.println(text);
		 * 
		 * if (text.equals("choice 2 1"))
		 * 
		 * { e.click(); break; }
		 * 
		 * }
		 */
		

	}
	
	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}
	
	
	  public static void selectchoice(By locator, String value) {
	  
	  List<WebElement> choiceList = getElements(locator);
	  
	  System.out.println(choiceList.size());
	  
	  for (WebElement e : choiceList) { String text = e.getText();
	  System.out.println(text);
	  
	  if (text.equals(value)) { e.click(); break; }
	  
	  }
	  
	  }
	 
	
		public static void multiselectchoice(By locator, String... value) {

			List<WebElement> choiceList = getElements(locator);

			System.out.println(choiceList.size());

			if (!value[0].equalsIgnoreCase("all")) {

				for (WebElement e : choiceList) {
					String text = e.getText();
					System.out.println(text);
					for (int j = 0; j < value.length; j++) {
						if (text.equals(value[j])) {
							e.click();
							break;
						}
					}

				}
			} else {
				for (WebElement e : choiceList) {
					e.click();
				}
			}

		}

	}
