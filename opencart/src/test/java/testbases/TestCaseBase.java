package testbases;
import java.io.FileReader;
import java.time.Duration;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

import com.github.javafaker.Faker;

public class TestCaseBase {

	protected WebDriver driver;
	protected Logger log;
	protected Faker faker; 
	protected Properties p;
	@BeforeClass
	public void setUp() {
		log = LogManager.getLogger();
		faker = new Faker();
		try {
			FileReader fread=new FileReader(".//src/test/resources/data.properties");
			p=new Properties();
			p.load(fread);
		}
		catch(Exception e) 
		{
			System.out.println(e.getMessage());
		}
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(5));
		driver.get(p.getProperty("openpage"));
		driver.manage().window().maximize();
	}
}
