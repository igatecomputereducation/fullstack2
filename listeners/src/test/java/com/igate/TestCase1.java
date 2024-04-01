package com.igate;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestCase1 {

	@BeforeClass
	public void loadPage() {
		System.out.println("Loading page..");
	}
	
	@Test(priority = 1)
	public void login() {
		System.out.println("Login...");
		AssertJUnit.assertEquals("hello", "hello");
	}
	
	@Test(priority = 2)
	public void indashboard() {
		System.out.println("Dashboard");
		AssertJUnit.assertTrue(false);
	}
	
	@Test(priority = 3,dependsOnMethods = {"indashboard"})
	public void logout() {
		System.out.println("logging out");
	}
	
	@AfterClass
	public void closePage() {
		System.out.println("Closing page..");
	}
}
