package SeleniumSession;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonTest {
	static WebDriver driver;
	public static void main(String[] args) {
		BrowserUtil br = new BrowserUtil();
		 driver = br.launchbrowser("Chrome");
		br.launchUrl("https://www.amazon.in");
		String Title = br.getPageTitle();
		System.out.println("Page Tile" + Title);
		if (Title.contains("Amazon")) {
			System.out.println("page title is correct");
		}

		else {
			System.out.println("page title is incorrect");
		}

		String pageUrl = br.getPageUrl();
		System.out.println("page Url:" + pageUrl);

		By footerlinks = By.xpath("//div[@class='navFooterVerticalColumn navAccessibility']//a");
		List <String> footerTextList = getLinksTextList(footerlinks);
		if(footerTextList.size()==22)
		{
			System.out.println("footer list count is correct");
		}

		
		if(footerTextList.contains("About Us"))
		{
			System.out.println("footer link is available - About US");
		}
		/*
		 * ElementUtil utilele = new ElementUtil(driver); List<WebElement> footerlist =
		 * utilele.getElements(footerlinks); System.out.println(footerlist.size());
		 * 
		 * for (WebElement e : footerlist) { System.out.println(e.getText()); }
		 * 
		 */
		driver.close();
		
		BrowserUtil br1 = new BrowserUtil();
		 driver = br1.launchbrowser("Chrome");
		br1.launchUrl("https://www.amazon.in");
		JavaScriptUtil js = new JavaScriptUtil(driver);
		String text1 = js.gettitleByJS();
		System.out.println(text1);

	}
	
	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}
	
	
	public static List<String> getLinksTextList(By locator) {
		List<String> eleTextList = new ArrayList<String>();

		List<WebElement> elelist = getElements(locator);
		System.out.println("element count:" + elelist.size());

		for (WebElement e : elelist) {

			String eletext = e.getText();
			if (!eletext.isEmpty()) {
				eleTextList.add(eletext);
			}
		}

		return eleTextList;

	}

}
