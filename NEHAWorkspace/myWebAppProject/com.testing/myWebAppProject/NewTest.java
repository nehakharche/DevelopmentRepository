package myWebAppProject;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NewTest {
	@BeforeMethod
	public void beforeMethod()
	{
		System.out.println("Before method");
		System.out.println("Test Case-3");
	}
	@Test
	public void testCase1()
	{
		System.out.println("Test Case-1");
		System.out.println("Test Case-3");
	}
	@Test
	public void testCase2()
	{
		System.out.println("Test Case-2");
		System.out.println("Test Case-2");
	}
	@AfterMethod
	public void afterMethod()
	{
	System.out.println("After method");
	System.out.println("After method");
	}
}
