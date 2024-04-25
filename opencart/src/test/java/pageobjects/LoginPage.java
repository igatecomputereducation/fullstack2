package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	private WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="email")
	WebElement login_email;
	
	@FindBy(name="password")
	WebElement login_password;
	
	@FindBy(xpath = "//input[@value='Login']")
	WebElement login_btn;
	
	
	@FindBy(xpath="//h2[normalize-space()='My Account']")
	WebElement myacct;
	
	public void setLoginEmail(String email) {
		login_email.sendKeys(email);
	}
	
	public void setLoginPassword(String password) {
		login_password.sendKeys(password);
	}
	public void clickLogin() {
		login_btn.click();
	}
		
	
}
