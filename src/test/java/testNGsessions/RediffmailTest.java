package testNGsessions;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RediffmailTest extends BaseTest {

	@Test
	public void pageTitleTest() {
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Rediffmail");
	}

	@Test
	public void pageURLTest() {
		String URL = driver.getCurrentUrl();
		System.out.println(URL);
		Assert.assertTrue(URL.contains("rediff"));

	}

}
