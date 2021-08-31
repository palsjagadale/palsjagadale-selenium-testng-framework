package testNGsessions;

import org.testng.annotations.Test;

public class DependsOnMethodsConcept {
	
	@Test
	public void loginTest() {
		System.out.println("Loginpage");
		int i = 9/0;
	}
	
	
	@Test(dependsOnMethods="loginTest",priority=2)
	public void homepageTest()
	{
		System.out.println("homepage");
	}
	
	@Test(dependsOnMethods="loginTest", priority=1)
	public void searchBoxTest()
	{
		System.out.println("searchtest");
	}

}
