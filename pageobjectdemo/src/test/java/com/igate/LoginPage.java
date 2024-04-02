package com.igate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	WebDriver driver;
	By luname,lpwd,llbtn;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		luname=By.name("username");
		lpwd=By.name("password");
		llbtn=By.tagName("button");
		
	}
	public void setUserName(String uname) {
		driver.findElement(luname).sendKeys(uname);
	}
	public void setPassword(String pwd) {
		driver.findElement(lpwd).sendKeys(pwd);
	}
	public void loginClick() {
		driver.findElement(llbtn).click();
	}
	
	
	/*
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	public void setUserName(String uname) {
		driver.findElement(By.name("username")).sendKeys(uname);
	}
	public void setPassword(String pwd) {
		driver.findElement(By.name("password")).sendKeys(pwd);
	}
	public void loginClick() {
		driver.findElement(By.tagName("button")).click();
	}*/
	
}
