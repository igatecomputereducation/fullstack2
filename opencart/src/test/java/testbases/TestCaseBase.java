package testbases;
import org.testng.annotations.Parameters;
import java.io.FileReader;
import java.time.Duration;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

import com.github.javafaker.Faker;

@Listeners(utils.ExtentReportManager.class)
public class TestCaseBase {

	protected WebDriver driver;
	protected Logger log;
	protected Faker faker; 
	protected Properties p;
	
	@BeforeClass(groups = {"sanity","regression"})
	@Parameters({"browser"})
	public void setUp(String browser) {
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
		switch(browser) {
			case "chrome":
				driver=new ChromeDriver();
				break;
			case "edge":
				driver=new EdgeDriver();
				break;
			default:
				return;
		}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(5));
		driver.get(p.getProperty("openpage"));
		driver.manage().window().maximize();
	}
}
