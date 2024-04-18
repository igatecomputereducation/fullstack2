package testcases;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.HomePage;
import pageobjects.RegisterPage;
import testbases.TestCaseBase;

public class TC_01_Register extends TestCaseBase{

		
	@Test(priority = 1)
	public void register() {
		log.info("***Beg of TC_01_register*****");
		HomePage hp=new HomePage(driver);
		hp.registerClick();
		Assert.assertTrue(hp.isRegisterLoaded());
	}
	
	@Test(priority = 2,dependsOnMethods = {"register"})
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
	}
}
