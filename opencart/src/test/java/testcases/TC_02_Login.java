package testcases;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.HomePage;
import pageobjects.LogOutPage;
import pageobjects.LoginPage;
import pageobjects.MyAccountPage;
import testbases.TestCaseBase;

public class TC_02_Login extends TestCaseBase{


	@Test(priority = 1,groups = {"regression"})
	public void login() {
		log.info("****beg of TC_02_Login********");
		HomePage hp=new HomePage(driver);
		
		log.info("Click on login homepage login");
		hp.loginClick();
		
		log.info("checking in login page");
		
		String page_title=driver.getTitle();
		
		if(page_title.equals("Account Login"))
		{
			Assert.assertTrue(true);
			log.info("In login page");
		}
		else
		{
			log.error("Problem in loading login page");
			Assert.fail();
		}
	}
	
	@Test(priority = 2,dependsOnMethods = {"login"},groups = {"regression"})
	public void login_data_entry() {
		
		log.info("Entering login data");
		LoginPage lp=new LoginPage(driver);
		lp.setLoginEmail(p.getProperty("username"));
		lp.setLoginPassword(p.getProperty("password"));
		lp.clickLogin();
		String page_title=driver.getTitle();
		
		if(page_title.equals("My Account"))
		{
			Assert.assertTrue(true);
			log.info("In My Account page");
		}
		else
		{
			log.error("Problem in loading My Account Page");
			Assert.fail();
		}
	}
	
	@Test(priority = 3,dependsOnMethods = {"login_data_entry"},groups = {"regression"})
	public void loggingout() {
		MyAccountPage mp=new MyAccountPage(driver);
		mp.clickLogout();
		LogOutPage lout=new LogOutPage(driver);
		lout.logOutContinue();
		
	}
	
	@Test(priority = 4, dependsOnMethods = {"loggingout"},groups = {"regression"})
	public void logoutToHome() {
		HomePage hp=new HomePage(driver);
		AssertJUnit.assertTrue(hp.isInHomepage());
	}
	
}
