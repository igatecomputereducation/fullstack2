package paraller;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.AssertJUnit;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class TestCase1 {

	WebDriver driver;
	
	@BeforeClass
	@Parameters({"driver"})
	public void loadPage(String dname) {
		
		if(dname.equals("chrome"))
			driver=new ChromeDriver();
		if(dname.equals("edge"))
			driver=new EdgeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		try{Thread.sleep(10000);}catch(Exception e) {}
	}
	
	@Test
	public void loginTest() {
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.tagName("button")).click();
		String title=driver.getTitle();
		AssertJUnit.assertEquals(title, "OrangeHRM");
	}
	
	
	
	@AfterClass
	public void close() {
		
	}
	
}
