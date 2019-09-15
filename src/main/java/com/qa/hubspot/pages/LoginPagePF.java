package com.qa.hubspot.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.hubspot.util.ElementUtilPF;

public class LoginPagePF {
	WebDriver driver;
	ElementUtilPF elementutilPF;
    
	// Define Page Locators (PF) for WebElements
	
	@FindBy(id = "username")
	WebElement emailId;
	@FindBy(id = "password")
	WebElement password;
	@FindBy(id = "loginBtn")
	WebElement loginButton;
	
	// Create Constructor for Page Class:
	
	public LoginPagePF(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementutilPF = new ElementUtilPF(driver);
	}
	
	// Page Actions:
	public void doLogin(String uSeRnAmE, String pwd) {
		elementutilPF.waitForElementPresent(emailId);
		emailId.sendKeys(uSeRnAmE);
		password.sendKeys(pwd);
		loginButton.click();
	}
	
	
	
	
	
	
	

}
