package testNGsessions;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AmazonTest extends BaseTest {

	@Test(priority=1)
	public void pageTitleTest() {
		driver.get("https://www.amazon.in");
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title,
				"Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
	}

	@Test(priority=2)
	public void pageURLTest() {
		String URL = driver.getCurrentUrl();
		System.out.println(URL);
		
	}

	@Test(priority=3)
	public void serchBoxTest() {
		driver.findElement(By.id("twotabsearchtextbox")).isDisplayed();
	}

}
