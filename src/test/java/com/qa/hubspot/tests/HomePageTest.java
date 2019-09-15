package com.qa.hubspot.tests;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.hubspot.Base.BasePage;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.util.Constants;
public class HomePageTest {
	
	WebDriver driver;
	Properties prop;
	BasePage basePage;
	LoginPage loginPage;
	HomePage homePage;
	
@BeforeMethod
public void setUp() {
		
	  basePage = new BasePage();
      prop = basePage.initialize_properties();
	  driver = basePage.initialize_driver(prop);
	  loginPage= new LoginPage(driver);
	  homePage = loginPage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
	 
			
	}

@Test(priority=1)
public void verifyHomePageTitleTest() {
	String title = homePage.getHomePageTitle();
	System.out.println("Home Page title is: "+ title);
	Assert.assertEquals(title, Constants.HOME_PAGE_TITLE);
}

@Test(priority=2)
public void verifyHomePageHeaderTest() {
	String headerValue = homePage.getHomePageHeaderValue();
	System.out.println("Home Page Header is :"+ headerValue);
	Assert.assertEquals(headerValue, Constants.HOMEPAGE_HEADER_VALUE);
}

@Test(priority=3)
public void verifyLoggedInUserAccountTest() {
	String accountName = homePage.getLoggedInAccountName();
	System.out.println("Logged in account name is:"+ accountName);
	Assert.assertTrue(homePage.verifyLoggedInAccountName());
	Assert.assertEquals(accountName, prop.getProperty("accountname"));
	
}

@AfterMethod													
public void tearDown() {
	driver.quit();
}

}
