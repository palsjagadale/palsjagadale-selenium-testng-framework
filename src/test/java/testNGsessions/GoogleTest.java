package testNGsessions;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleTest extends BaseTest {

	@Test(priority = 1)
	public void pageTitleTest() {
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Google");
	}

	@Test(priority = 2)
	public void pageURLTest() {
		String URL = driver.getCurrentUrl();
		System.out.println(URL);
		Assert.assertTrue(URL.contains("google"));

	}

}
