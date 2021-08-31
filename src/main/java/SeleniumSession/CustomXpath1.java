package SeleniumSession;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CustomXpath1 {
	
	static WebDriver driver;

	public static void main(String[] args) {
		
		//xpath - address of element in HTML DOM 		
		//1. absolute xpath
		//2. relative/custom xpath
		
		
		//HTML tag[@attr='value']
		//input[@id='input-email']  | //input[@name='email']  | //input[@type='text' and  @name='email'] | //input[@type='text' and  @name='email' and @id='input-email'] 
		//String xpath = "//input[@name=\"email\"]";		
		// (//input[@class='text'])[last()] ----------for last postion 
		//(//div[@class='navFooterVerticalColumn navAccessibility']//a)[last()] ---------last link 
		
		
		//Xpath - using text() function
		//a[text()='Login']
		//h2 [text() ='Refreshing business software that your teams will love']
		////h3[text()='Marketing Automation']
		//span[text()=' sign up']
		//a[text()='Customers']
		
		
		//Xpath - using contains() function
		//htmltag[contains(@attr,'value')]
		//input[contains(@attr,'value')]
		//input[contains(@id, 'email')]
		//input[contains(@id,'firstname_')]
		
		
		//xpath - contains using text function
		//htmltag[contains(text(),'value')]
		//a[contains(text(),'Order')]
		//h2[contains(text(), 'business')]
		
		
		//contains with one attr and second atrr without contains
		//htmltag[contains(@id,'value') and @atrr='value' and @atrr='value']
		//input[contains(@id , 'input') and @type='text']
		
		
		//xpath - contains with text and atrr
		//htmltag[contains(text(),'value') and @atrr='value' and @atrr='login']
		//a[contains(text(), 'Contact Sales') and @href = '/contact-sales/']
		
		
		//xpath contains with text and contains with atrr
		/////a[contains(text(), 'Contact Sales') and contains(@class, 'btn-orange trial-btn pulse ')]
		
		
		
		
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/index.php?route=account/register");
		
		
		String xpathFN = "//input[@id='input-firstname']";
        String XpathLN = "//input[@id='input-lastname'] "; 
        String xpathEmail = "//input[@id='input-email']";
        String Xpathtel = "//input[@id='input-telephone']";
        String xpathPWD = "//input[@id='input-password']";
        String xpathConfirmPWD = "//input[@id='input-confirm'] ";
        String xpathNewsletterYes = "(//input[@type='radio'])[2]";
        String xpathNewsletterNo = "(//input[@type='radio'])[3]";
        String xpathCheckbox = "//input[@type='checkbox']";
        String xpathContinue ="//input[@type='submit']";
        String text = "//h1[text() = 'Your Account Has Been Created!']";
        
        
        
        
   getElement("xpath", xpathFN).sendKeys("Pallavi");
   getElement("xpath", XpathLN).sendKeys("N");
   getElement("xpath", xpathEmail).sendKeys("naveen2020@gmail.com");
   getElement("xpath", Xpathtel).sendKeys("7777777777");
   getElement("xpath", xpathPWD).sendKeys("Test123");
   getElement("xpath", xpathConfirmPWD).sendKeys("Test123");
   getElement("xpath", xpathNewsletterYes);
   getElement("xpath", xpathNewsletterNo).click();
   getElement("xpath", xpathCheckbox).click();
   getElement("xpath", xpathContinue).click();
  String resultext=  getElement("xpath", text).getText();
  System.out.println(resultext);
   
   
                
		/*
		 * //String linkvalue = "Login";
		 * 
		 * //By Email = getBy("xpath", xpathFN); 
		 * //getElement(Email).sendKeys("naveen");
		 * //getElement("linktext", linkvalue);
		 */	}
	
	
	public static WebElement getElement(By locator)
	{
		return driver.findElement(locator);
		
	}
	
	public static WebElement getElement(String locatortype, String locatorValue)
	{
		
		return driver.findElement(getBy( locatortype,  locatorValue));
	}
	
	public static By getBy(String locatortype, String locatorValue)
	{
		By locator = null;
		switch (locatortype) {
		
		case "id":			
			locator=By.id(locatorValue);			
			break;
			
		case "xpath":			
			locator=By.xpath(locatorValue);			
			break;
			
		case "name":			
			locator=By.name(locatorValue);			
			break;
			
		case "className":			
			locator=By.className(locatorValue);			
			break;

		case "linkText":			
			locator=By.linkText(locatorValue);			
			break;
		case "partialLinkText":			
			locator=By.partialLinkText(locatorValue);			
			break;
			
		case "cssSelector":			
			locator=By.cssSelector(locatorValue);			
			break;

		default:
			System.out.println("Please pass correct locator");
			break;
		}
		
		return locator;
	}

}
