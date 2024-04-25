package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

	
	WebDriver driver;
	public RegisterPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "firstname")
	private WebElement f_name;
	
	@FindBy(name = "lastname")
	private WebElement l_name;
	

	@FindBy(name = "email")
	private WebElement email;
	
	@FindBy(name = "telephone")
	private WebElement tel;
	
	@FindBy(name = "password")
	private WebElement pwd;
	
	@FindBy(name = "confirm")
	private WebElement confirm;
	
		
	@FindBy(name = "agree")
	private WebElement agree;
	
	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement btn_continue;
	
	@FindBy(xpath = "//a[normalize-space()='Continue']")
	private WebElement your_store_con;
	
	public void setFirstName(String fname) {
		f_name.sendKeys(fname);
	}
	
	public void setLastName(String lname) {
		l_name.sendKeys(lname);
	}
	
	public void setEmail(String email) {
		this.email.sendKeys(email);
	}
	
	public void setTelephone(String tel) {
		this.tel.sendKeys(tel);
	}
	
	
	public void setPassword(String pwd) {
		this.pwd.sendKeys(pwd);
	}
	
	public void setConfirm(String cpwd) {
		confirm.sendKeys(cpwd);
	}
	
	public void setNewsLetter(String opt) {
		List<WebElement> nl =driver.findElements(By.name("newsletter"));
		if(opt.equals("yes"))
			nl.get(0).click();
		else
			nl.get(1).click();
	}
	
	public void clickAgree() {
		agree.click();
	}
	
	public void clickContinue() {
		btn_continue.click();
	}
	
	public void your_store_con() {
		your_store_con.click();
	}
	
	public boolean isMyAccountPageLoaded() {
		return driver.getTitle().equals("My Account");
	}
	
}
