package com.igate;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestCase1 {

	WebDriver driver;
	
	@BeforeClass
	public void loadPage() {
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(5));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
	}
	
	@Test(priority = 1)
	public void login() {
		LoginPage l=new LoginPage(driver);
		l.setUserName("admin");
		l.setPassword("admin123");
		l.loginClick();
		String title=driver.getTitle();
		Assert.assertEquals(title, "OrangeHRM");
	}
	
	@AfterClass
	public void close() {
		//driver.quit();
	}
	
}
