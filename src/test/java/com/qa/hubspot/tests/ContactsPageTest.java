package com.qa.hubspot.tests;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.qa.hubspot.Base.BasePage;
import com.qa.hubspot.pages.ContactsPage;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.util.Constants;
import com.qa.hubspot.util.ExcelUtil;
public class ContactsPageTest {
	
	WebDriver driver;
	BasePage basePage;
	Properties prop;
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;

@BeforeMethod
public void setUp() throws InterruptedException  {
	basePage = new BasePage();
	prop = basePage.initialize_properties();
	driver = basePage.initialize_driver(prop);
	loginPage= new LoginPage(driver);
	homePage = loginPage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
	contactsPage =homePage.goToContactsPage();
}

@Test(priority = 1)
public void verifyContactsPageTitle() {
	String title = contactsPage.getContactsPageTitle();
	System.out.println("Contacts Page title is :" + title);
	Assert.assertEquals(title, Constants.CONTACTS_PAGE_TITLE);
}
@DataProvider()
public Object[][] getContactData() {
	Object data[][]=ExcelUtil.getTestData("createcontact");
	return data;
}
@Test(priority = 2, dataProvider ="getContactData")
public void CreateNewContactTest(String email,String firstname, String lastname, String jobTitle) {
	contactsPage.createContact(email, firstname, lastname, jobTitle);
}

@AfterMethod
public void tearDown() {
	driver.quit();
	}

}
