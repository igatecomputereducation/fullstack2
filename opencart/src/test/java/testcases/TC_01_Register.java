package testcases;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.HomePage;
import pageobjects.LogOutPage;
import pageobjects.MyAccountPage;
import pageobjects.RegisterPage;
import testbases.TestCaseBase;

public class TC_01_Register extends TestCaseBase{

		
	@Test(priority = 1,groups = {"regression"})
	public void register() {
		HomePage hp=new HomePage(driver);
		hp.registerClick();
		AssertJUnit.assertTrue(hp.isRegisterLoaded());
	}
	
	@Test(priority = 2,dependsOnMethods = {"register"},groups = {"regression"})
	public void registerDataentry() {
		log.info("Entering register data..");
		String fkpwd=faker.internet().password();
		RegisterPage rp=new RegisterPage(driver);
		rp.setFirstName(faker.address().firstName());
		rp.setLastName(faker.address().lastName());
		rp.setEmail(faker.internet().emailAddress());
		rp.setTelephone(faker.phoneNumber().cellPhone());
		rp.setPassword(fkpwd);
		rp.setConfirm(fkpwd);
		rp.setNewsLetter("yes");
		rp.clickAgree();
		rp.clickContinue();
		rp.your_store_con();
		AssertJUnit.assertTrue(rp.isMyAccountPageLoaded());
	}
	
	@Test(priority = 3,dependsOnMethods = {"registerDataentry"},groups = {"regression"})
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
