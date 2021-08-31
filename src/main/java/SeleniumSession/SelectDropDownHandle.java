package SeleniumSession;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectDropDownHandle {
	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(3000, TimeUnit.SECONDS);
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");

		// driver.findElement(By.linkText("Accept Cookies")).click();

		By industry = By.id("Form_submitForm_Industry");
		By country = By.id("Form_submitForm_Country");

//		WebElement indus_ele = driver.findElement(industry);
//		WebElement country_ele = driver.findElement(country);
//
//		// HTML tag should be select tag
//		Select select = new Select(indus_ele);
//		// select.selectByIndex(5);								 // use when values are always fix like month, days , dates.
//		select.selectByVisibleText("Education");
//		// select.deselectByValue("Electronics"); 				// if value Attribute is available in HTML select tag.
//		
//		Select select_country = new Select(country_ele);
//		select_country.selectByVisibleText("India");
		
		doSelectByVisibleText(industry, "Education");
		doSelectByVisibleText(country, "India");
		//doSelectByIndex(country, 4);
		//doSelectByValue(industry, "India");
	}

	public static WebElement getElement(By locator)
	{
		return driver.findElement(locator);
	}
	
	public static void doSelectByVisibleText(By locator, String text)
	{
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(text);
	}

//	public static void doSelectByIndex(By locator, int index)
//	{
//		Select select = new Select(getElement(locator));
//		select.selectByIndex(index);
//	}
//	
//	public static void doSelectByValue(By locator, String value)
//	{
//		Select select = new Select(getElement(locator));
//		select.selectByValue(value);
//	}
	
}
