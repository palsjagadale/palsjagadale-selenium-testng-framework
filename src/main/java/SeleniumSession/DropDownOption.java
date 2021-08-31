package SeleniumSession;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownOption {
	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		doMaximizeWindow();
		doPageTimeout();

		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");

		By industry = By.xpath("//select[@id='Form_submitForm_Industry']");
		By country = By.xpath("//select[@id='Form_submitForm_Country']");
		
		  List<String> indusList = doGetDopDownOptionList(industry);
		  	  
		  if (indusList.size()==21)
		  {
			  System.out.println("pass");
		  } 
		  
		  if (indusList.contains("Healthcare"))
		  {
			  System.out.println("pass");
		  }
		  
		 // List<String> countrList= doGetDopDownOptionList(country);
		  
		  selectDopDownOptionList(country, "India");
		  
			/*
			 * WebElement indus_ele = driver.findElement(industry); 
			 * -WebElement country_ele = driver.findElement(country);
			 */
		  
			/*
			 * Select indus_select = new Select(indus_ele); List<WebElement> indusList =
			 * indus_select.getOptions(); System.out.println(indusList.size());
			 */

		
		/*
		 * for (WebElement e : indusList) { String indusListOption = e.getText();
		 * System.out.println(indusListOption);
		 * 
		 * String indusAttriListOptions = e.getAttribute(indusListOption);
		 * System.out.println(indusAttriListOptions); }
		 */
		 

		/*
		 * for (int i = 0; i <= indusList.size(); i++) { * System.out.println(i); String
		 * text = indus_ele.getText();
		 *  System.out.println(text); 
		 * String getAttriIndusoptions = indus_ele.getAttribute(indus_ele.getText());
		 * System.out.println(getAttriIndusoptions); }
		 */		 

	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public static List<String> doGetDopDownOptionList(By locator) {
		
		List<String> optionValueList = new ArrayList<String>();
		Select select = new Select(getElement(locator));
		List<WebElement> optionList = select.getOptions();
		System.out.println(optionList.size());

		for (WebElement e : optionList) {
			String text = e.getText();
			optionValueList.add(text);
			
			/*
			 * String optiontext = e.getAttribute(text); System.out.println(optiontext);
			 */
		}
		
		return optionValueList;

	}
	
	public static void selectDopDownOptionList(By locator, String value) {

		Select select = new Select(getElement(locator));
		List<WebElement> optionList = select.getOptions();
		System.out.println(optionList.size());

		for (WebElement e : optionList) {
			String text = e.getText();
			if(text.equals(value))
			{
				e.click();
				break;
			}
		}
	}


	public static void doMaximizeWindow() {
		driver.manage().window().maximize();

	}

	public static void doPageTimeout() {
		driver.manage().timeouts().pageLoadTimeout(2000, TimeUnit.SECONDS);

	}

}
