package testcases;

import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import pageobjects.HomePage;
import pageobjects.LogOutPage;
import pageobjects.LoginPage;
import pageobjects.MyAccountPage;
import testbases.TestCaseBase;
import utils.OpenCartDataProvider;

public class TC_02_Login_DataDriven extends TestCaseBase{
	
	
	@Test(groups = {"sanity"},dataProvider = "LoginData",dataProviderClass = OpenCartDataProvider.class)
		public void login_data_entry(String email,String pwd,String exp) {
		
			log.info("*********beg of login_data_entry************");
		
		try {
			
			log.info("Opening home page");
			HomePage hp=new HomePage(driver);
			hp.registerClick();
			hp.loginClick();
			
			log.info("Opening login page");
			LoginPage lp=new LoginPage(driver);
			lp.setLoginEmail(email);
			lp.setLoginPassword(pwd);
			lp.clickLogin();
			
			String page_title=driver.getTitle();
			boolean targetpage=page_title.equals("My Account");
			
			log.info("checking my account page");
			MyAccountPage myacc=new MyAccountPage(driver);
			
			if(exp.equals("valid"))
			{
				if(targetpage==true)
				{
					myacc.clickLogout();
					Assert.assertTrue(true);
				}
				else
				{
					Assert.assertTrue(false);
				}
			}
			
			if(exp.equalsIgnoreCase("Invalid"))
			{
				if(targetpage==true)
				{
					myacc.clickLogout();
					Assert.assertTrue(false);
				}
				else
				{
					Assert.assertTrue(true);
				}
			}
			log.info("sucess");
		}
		catch(Exception e) {
			log.error("failure of login test");
			Assert.fail();
			
			
		}
	}
}
