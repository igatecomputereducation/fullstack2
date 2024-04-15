package com.igate;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.igate.ExtentReportManager.class)
public class TestCase {
	@BeforeClass
	public void setup() {
		System.out.println("Setting up the tescase");
	}
	@Test(priority = 1)
	public void testStep1() {
		System.out.println("first test method");
		Assert.assertTrue(true);
	}
	@Test(priority = 2)
	public void testStep2() {
			System.out.println("second test method");
			Assert.assertTrue(false);
		}
	@Test(priority = 3,dependsOnMethods = {"testStep2"})
    public void testStep3() {
		System.out.println("Third test method");
		
	}
    @AfterClass
	public void tearDown() {
		System.out.println("End of testcase");
	}
	
}
