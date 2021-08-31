package SeleniumSession;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestUtil {

	public static void main(String[] args) {
		String browser = "Chrome";
		BrowserUtil br = new BrowserUtil();
		WebDriver driver = br.launchbrowser(browser);
		//br.launchUrl("https://www.orangehrm.com/orangehrm-30-day-trial/");
		br.launchUrl("https://www.freshworks.com/");
//		System.out.println(br.getPageTitle());
//		System.out.println(br.getPageUrl());

//		By firstName = By.id("Form_submitForm_FirstName");
//		By lastName = By.id("Form_submitForm_LastName");
//		By Email = By.id("Form_submitForm_Email");
//		By Job_Title = By.id("Form_submitForm_JobTitle");
//		By company = By.id("Form_submitForm_CompanyName");
//		By phonenumner = By.id("Form_submitForm_Contact");
//		By numerOfEmployee = By.id("Form_submitForm_NoOfEmployees");
//		By Industry = By.id("Form_submitForm_Industry");
//		By Country = By.id("Form_submitForm_Country");
//		By checkBox = By.id("Form_submitForm_SetDummyData");
//		By link = By.linkText("Platform");
		By header = By.tagName("h1");
				

		ElementUtil eleUtil = new ElementUtil(driver);
//		eleUtil.doSendKeys(firstName, "Pallavi");
//		eleUtil.doSendKeys(lastName, "Nikam");
//		eleUtil.doSendKeys(Email, "xyz@xyz.com");
//		eleUtil.doSendKeys(Job_Title, "QA");
//		eleUtil.doSendKeys(company, "XP");
//		eleUtil.doSendKeys(phonenumner, "7777777777");
//		eleUtil.doSendKeys(Industry, "IT");
//		eleUtil.doSendKeys(numerOfEmployee, "10");
//		eleUtil.selectDropdown(Country, "India");
//		eleUtil.selectDropdown(Industry, "Automotive");
//		eleUtil.doClick(checkBox);
//		eleUtil.doClick(link);
		System.out.println(eleUtil.doGetText(header));
		
		
		
		
		// br.closeBrowser();

	}

}