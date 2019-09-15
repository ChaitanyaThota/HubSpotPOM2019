package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.hubspot.Base.BasePage;

import com.qa.hubspot.pages.LoginPagePF;
import com.qa.hubspot.util.ElementUtilPF;

public class LoginPagePFTest {
	WebDriver driver;
	Properties prop;
	BasePage basePage;
	LoginPagePF loginPagePF;
	ElementUtilPF elementutilpf;
	
@BeforeMethod
public void setUp() throws InterruptedException   {
	 		basePage = new BasePage();
	 		prop = basePage.initialize_properties();
	 		driver = basePage.initialize_driver(prop);
	 		loginPagePF= new LoginPagePF(driver);
	 		
	 		}

@Test()
public void doLoginTest() {
	loginPagePF.doLogin(prop.getProperty("username"), prop.getProperty("password"));
}


@AfterMethod
public void tearDown() {
	 basePage.quitBrowser();
		
	}

}
