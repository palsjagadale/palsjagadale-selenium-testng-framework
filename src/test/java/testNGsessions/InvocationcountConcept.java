package testNGsessions;

import org.testng.annotations.Test;

public class InvocationcountConcept {
	
		
	@Test(invocationCount=10)
	public void loginTest() {
		System.out.println("Loginpage");
		
	}

}
