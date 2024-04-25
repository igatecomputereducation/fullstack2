package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Register")
	WebElement link_register;
	
	@FindBy(linkText = "Login")
	WebElement link_login;
	
	@FindBy(xpath = "//span[@class='caret']")
	WebElement open_dropdown;
		
	
	public void registerClick() {
		
		open_dropdown.click();
		link_register.click();
	}
	
	public boolean isRegisterLoaded() {
		return driver.getTitle().equals("Register Account");
	}
	

	public void loginClick() {
		open_dropdown.click();
		link_login.click();
	}
	
	
	public boolean isInHomepage() {
		return driver.getTitle().equals("Your Store");
	}
	
}
