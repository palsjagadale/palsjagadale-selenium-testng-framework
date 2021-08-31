package testNGsessions;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGBasics {
	
	//precondtions : @before
	//Test cases : @test - test steps + assertions (Act vs Exp result)
	//Post condtions : @after
	
	
	
	//Beforemethod and Aftermethod : execute before/after each test case
	//Test will pick on the alphabetical order of method name.
	
	
	@BeforeSuite
	public void DBConnections()
	{
		System.out.println("BS-------DBConnections");
		
	}
	
	@BeforeTest
	public void createUser()
	{
		System.out.println("BT----------CrateUser");
	}
	
	
	@BeforeClass
	public void launchbrowser()
	{
		System.out.println("BC----------------LaunchBrowser");
	}
	
	
	@BeforeMethod
	public void loginmethod()
	{
		System.out.println("BM------------------loginmethod ");
	}
	
	
	@Test
	public void homepageTest()
	{
		System.out.println("test1-----------homepageTest");
	}
	
	@Test
	public void addtocartTest()
	{
		System.out.println("test2-----------addtocart");
	}
	
	@Test
	public void paymentpageTest()
	{
		System.out.println("test3-----------paymentpageTest");
	}

	
	@AfterMethod
	public void logout()
	{
		System.out.println("AM----------logout");
	}
	
	
	@AfterClass
	public void closeBrowser() {
		System.out.println("AC---------------------closeBrowser");
	}
	
	@AfterTest
	public void deleteuser()
	{
		System.out.println("AT----------deleteuser");
	}
	
	
	@AfterSuite
	public void disconnectDB()
	{
		System.out.println("AS--------------------------disconnectDB");
	}
	
}
