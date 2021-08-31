package testNGsessions;

import org.testng.annotations.Test;

public class PriorityConcept {
	
	@Test(priority=3)
	public void a_Test()
	{
		System.out.println("a Test");
	
		
	}
	@Test(priority=1)
	public void b_Test()
	{
		System.out.println("b Test");
	
		
	}

	@Test(priority=0)
	public void c_Test()
	{
		System.out.println("c Test");
	
		
	}

	@Test(priority=-2)
	public void d_Test()
	{
		System.out.println("d Test");
	
		
	}

	@Test(priority=5)
	public void e_Test()
	{
		System.out.println("e Test");
	
		
	}


}
