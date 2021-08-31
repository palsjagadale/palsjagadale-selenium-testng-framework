package testNGsessions;

import org.testng.annotations.Test;

public class ExpectedExceptionConcept {
	String name = "testng";
	
	@Test(expectedExceptions = {ArithmeticException.class, NullPointerException.class})
	public void loginTest() {
		System.out.println("Loginpage");
		int i = 9/0;
		ExpectedExceptionConcept obj = null;
		System.out.println(obj.name);
	}
	
	
	@Test
	public void homepageTest()
	{
		System.out.println("homepage");
	}
	
	@Test
	public void searchBoxTest()
	{
		System.out.println("searchtest");
	}
}
