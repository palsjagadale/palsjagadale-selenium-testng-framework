package SeleniumSession;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Locators {

	public static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
//	
//	//create webelement 		+	//perform action
//	//id locator is the static method so we are calling it directly using By class name.
//	//By is the class
//	driver.findElement(By.id("Form_submitForm_FirstName")).sendKeys("Pallavi"); 
//	driver.findElement(By.id("Form_submitForm_LastName")).sendKeys("Nikam");

//	//2nd :
//	WebElement firstName = driver.findElement(By.id("Form_submitForm_FirstName")); 
//	WebElement lastName = driver.findElement(By.id("Form_submitForm_LastName"));
//	firstName.sendKeys("Pallavi");
//	lastName.sendKeys("Nikam");

//	//3rd : By locator;
//	By firstName = By.id("Form_submitForm_FirstName");
//	By lastName = By.id("Form_submitForm_LastName");
//	
//	WebElement el_fn = driver.findElement(firstName);
//	WebElement el_ln = driver.findElement(lastName);
//	
//	el_fn.sendKeys("pallavi");
//	el_ln.sendKeys("Nikam");

		// 4th: generic methods
//	By firstName = By.id("Form_submitForm_FirstName");
//	By lastName = By.id("Form_submitForm_LastName");
//	getElement(firstName).sendKeys("Pallavi");
//	getElement(lastName).sendKeys("Nikam");
//	
//		// 5th : using generic methods for actions
//
//		By firstName = By.id("Form_submitForm_FirstName");
//		By lastName = By.id("Form_submitForm_LastName");
//		
//		doSendKeys(firstName, "Pallavi");
//		doSendKeys(lastName, "Nikam");
//		
		
		//6th Create a new ElementUtil class with generic fucntions
		By firstName = By.id("Form_submitForm_FirstName");
		By lastName = By.id("Form_submitForm_LastName");
		
		ElementUtil eleUtil = new ElementUtil(driver);
		eleUtil.doSendKeys(firstName, "Pallavi");
		eleUtil.doSendKeys(lastName, "Nikam");
		
		driver.close();
		
	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public static void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}
	public static void selectDropdown(By locator, String Value) {

		Select sl = new Select(getElement(locator));
		sl.selectByVisibleText(Value);

	}
	
	public static void doClick(By locator) {
		getElement(locator).click();
	}
	
	public static String doGetAttribute(By locator, String AttrName)
	{
		return getElement(locator).getAttribute(AttrName);
	}
	
	public static String doGetText(By locator)
	{
		return getElement(locator).getText();
	}
	
	public static  boolean doDisplayed(By locator)
	{
		return getElement(locator).isDisplayed();
	}
	
	public static boolean doEnable(By locator)
	{
		return getElement(locator).isEnabled();
	}

}
