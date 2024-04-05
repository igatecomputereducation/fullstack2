package testcases;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.HomePage;
import testbases.TestCaseBase;

public class TC_02_Login extends TestCaseBase{


	@Test(priority = 1)
	public void login() {
		HomePage hp=new HomePage(driver);
		hp.loginClick();
		Assert.assertTrue(hp.isLoginpageLoaded());
	}
	
	
	
}
