package testcases;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.HomePage;
import pageobjects.RegisterPage;
import testbases.TestCaseBase;

public class TC_01_Register extends TestCaseBase{

		
	@Test(priority = 1)
	public void register() {
		HomePage hp=new HomePage(driver);
		hp.registerClick();
		Assert.assertTrue(hp.isRegisterLoaded());
	}
	
	@Test(priority = 2,dependsOnMethods = {"register"})
	public void registerDataentry() {
		RegisterPage rp=new RegisterPage(driver);
		rp.setFirstName("subbu");
		rp.setLastName("immadisetty");
		rp.setEmail("hello@gmail.com");
		rp.setTelephone("9234474");
		rp.setPassword("password123");
		rp.setConfirm("password123");
		rp.setNewsLetter("yes");
		rp.clickAgree();
		rp.clickContinue();
		
	}
	
	
}
